package com.example.apigateway.domainclientlayer.customer;

import com.example.apigateway.presentationlayer.customer.CustomerRequestModel;
import com.example.apigateway.presentationlayer.customer.CustomerResponseModel;
import com.example.apigateway.utils.HttpErrorInfo;
import com.example.apigateway.utils.InuseException.InvalidInputException;
import com.example.apigateway.utils.InuseException.NotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@Component
@Slf4j
public class CustomerServiceClient {

    private final RestTemplate restTemplate;
    private final ObjectMapper mapper;

    private final String CUSTOMER_SERVICE_BASE_URL;

    private CustomerServiceClient(RestTemplate restTemplate, ObjectMapper objectMapper,
                                  @Value("${app.customer-service.host}") String customerServiceHost,
                                  @Value("${app.customer-service.port}") String customerServicePort){
        this.restTemplate = restTemplate;
        this.mapper = objectMapper;

        CUSTOMER_SERVICE_BASE_URL= "http://" + customerServiceHost + ":" +  customerServicePort + "/api/v1/customers";

    }

    public CustomerResponseModel updateCustomer(String customerId, CustomerRequestModel customerRequestModel) {
        try {
            String url = CUSTOMER_SERVICE_BASE_URL + "/" + customerId;

            // Set the headers for the request
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            // Create the request entity with the league data in the body and headers
            HttpEntity<CustomerRequestModel> requestEntity = new HttpEntity<>(customerRequestModel, headers);

            // Send the PUT request to update the league
            restTemplate.put(url, requestEntity);

            // Assuming the leagues service returns the updated league data, you can fetch it
            CustomerResponseModel updatedLeague = restTemplate.getForObject(url, CustomerResponseModel.class);

            return updatedLeague;
        } catch (HttpClientErrorException ex) {
            throw handleHttpClientException(ex);
        }
    }




    public CustomerResponseModel addCustomer(CustomerRequestModel customerRequestModel) {
        try {
            String url = CUSTOMER_SERVICE_BASE_URL;

            // Set the headers for the request
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            // Create the request entity with the league data in the body and headers
            HttpEntity<CustomerRequestModel> requestEntity = new HttpEntity<>(customerRequestModel, headers);

            // Send the POST request to add the league
            CustomerResponseModel leagueModel = restTemplate.postForObject(url, requestEntity, CustomerResponseModel.class);

            return leagueModel;
        } catch (HttpClientErrorException ex) {
            throw handleHttpClientException(ex);
        }
    }

    public void removeCustomer(String customerId) {
        try {
            String url = CUSTOMER_SERVICE_BASE_URL + "/" + customerId;
            restTemplate.delete(url);
        } catch (HttpClientErrorException ex) {
            throw handleHttpClientException(ex);
        }
    }

    public List<CustomerResponseModel> getAllCustomers(){
        try {
            String url= CUSTOMER_SERVICE_BASE_URL;
            CustomerResponseModel[] customerResponseModels=  restTemplate.getForObject(url,CustomerResponseModel[].class);
            return Arrays.asList(customerResponseModels);

        }catch (HttpClientErrorException ex){
            throw handleHttpClientException(ex);
        }
    }

    public CustomerResponseModel getCustomerByCustomerId(String customerId){
        try {
            String url= CUSTOMER_SERVICE_BASE_URL + "/" + customerId;
            CustomerResponseModel customerModel=  restTemplate.getForObject(url,CustomerResponseModel.class);
            return customerModel;
        }catch (HttpClientErrorException ex){
            throw handleHttpClientException(ex);
        }

    }

    private RuntimeException handleHttpClientException(HttpClientErrorException ex) {
//include all possible responses from the client
        if (ex.getStatusCode() == NOT_FOUND) {
            return new NotFoundException(getErrorMessage(ex));
        }
        if (ex.getStatusCode() == UNPROCESSABLE_ENTITY) {
            return new InvalidInputException(getErrorMessage(ex));
        }
        log.warn("Got an unexpected HTTP error: {}, will rethrow it", ex.getStatusCode());
        log.warn("Error body: {}", ex.getResponseBodyAsString());
        return ex;
    }

    private String getErrorMessage(HttpClientErrorException ex) {
        try {
            return mapper.readValue(ex.getResponseBodyAsString(), HttpErrorInfo.class).getMessage();
        }
        catch (IOException ioex) {
            return ioex.getMessage();
        }
    }

}
