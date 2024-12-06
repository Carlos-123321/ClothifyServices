package com.example.apigateway.domainclientlayer.clothing;

import com.example.apigateway.presentationlayer.employee.EmployeeRequestModel;
import com.example.apigateway.presentationlayer.employee.EmployeeResponseModel;
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
public class ClothingServiceClient {

    private final RestTemplate restTemplate;
    private final ObjectMapper mapper;

    private final String EMPLOYEE_SERVICE_BASE_URL;

    private ClothingServiceClient(RestTemplate restTemplate, ObjectMapper objectMapper,
                                  @Value("${app.employee-service.host}") String employeeServiceHost,
                                  @Value("${app.employee-service.port}") String employeeServicePort){
        this.restTemplate = restTemplate;
        this.mapper = objectMapper;

        EMPLOYEE_SERVICE_BASE_URL= "http://" + employeeServiceHost + ":" +  employeeServicePort + "/api/v1/employees";

    }

    public EmployeeResponseModel updateEmployee(String employeeId, EmployeeRequestModel employeeRequestModel) {
        try {
            String url = EMPLOYEE_SERVICE_BASE_URL + "/" + employeeId;

            // Set the headers for the request
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            // Create the request entity with the league data in the body and headers
            HttpEntity<EmployeeRequestModel> requestEntity = new HttpEntity<>(employeeRequestModel, headers);

            // Send the PUT request to update the league
            restTemplate.put(url, requestEntity);

            // Assuming the leagues service returns the updated league data, you can fetch it
            EmployeeResponseModel updatedLeague = restTemplate.getForObject(url, EmployeeResponseModel.class);

            return updatedLeague;
        } catch (HttpClientErrorException ex) {
            throw handleHttpClientException(ex);
        }
    }




    public EmployeeResponseModel addEmployee(EmployeeRequestModel employeeRequestModel) {
        try {
            String url = EMPLOYEE_SERVICE_BASE_URL;

            // Set the headers for the request
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            // Create the request entity with the league data in the body and headers
            HttpEntity<EmployeeRequestModel> requestEntity = new HttpEntity<>(employeeRequestModel, headers);

            // Send the POST request to add the league
            EmployeeResponseModel leagueModel = restTemplate.postForObject(url, requestEntity, EmployeeResponseModel.class);

            return leagueModel;
        } catch (HttpClientErrorException ex) {
            throw handleHttpClientException(ex);
        }
    }

    public void removeEmployee(String employeeId) {
        try {
            String url = EMPLOYEE_SERVICE_BASE_URL + "/" + employeeId;
            restTemplate.delete(url);
        } catch (HttpClientErrorException ex) {
            throw handleHttpClientException(ex);
        }
    }

    public List<EmployeeResponseModel> getAllEmployees(){
        try {
            String url= EMPLOYEE_SERVICE_BASE_URL;
            EmployeeResponseModel[] employeeResponseModels=  restTemplate.getForObject(url,EmployeeResponseModel[].class);
            return Arrays.asList(employeeResponseModels);

        }catch (HttpClientErrorException ex){
            throw handleHttpClientException(ex);
        }
    }

    public EmployeeResponseModel getEmployeeByEmployeeId(String employeeId){
        try {
            String url= EMPLOYEE_SERVICE_BASE_URL + "/" + employeeId;
            EmployeeResponseModel employeeModel=  restTemplate.getForObject(url,EmployeeResponseModel.class);
            return employeeModel;
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
