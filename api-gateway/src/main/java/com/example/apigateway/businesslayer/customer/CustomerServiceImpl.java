package com.example.apigateway.businesslayer.customer;

import com.example.apigateway.mapperlayer.customer.CustomerResponseMapper;
import com.example.apigateway.domainclientlayer.customer.CustomerServiceClient;
import com.example.apigateway.presentationlayer.customer.CustomerRequestModel;
import com.example.apigateway.presentationlayer.customer.CustomerResponseModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService{

    private final CustomerResponseMapper customerResponseMapper;
    private final CustomerServiceClient customerServiceClient;

    public CustomerServiceImpl(CustomerResponseMapper customerResponseMapper, CustomerServiceClient customerServiceClient) {
        this.customerResponseMapper = customerResponseMapper;
        this.customerServiceClient = customerServiceClient;
    }

    @Override
    public List<CustomerResponseModel> getCustomers() {
        return customerResponseMapper.entityListToResponseModelList(customerServiceClient.getAllCustomers());
    }

    @Override
    public CustomerResponseModel getCustomerByCustomerId(String customerId) {
        return customerResponseMapper.entityToResponseModel(customerServiceClient.getCustomerByCustomerId(customerId));
    }

    @Override
    public void removeCustomer(String customerId) {
        customerServiceClient.removeCustomer(customerId);
    }

    @Override
    public CustomerResponseModel addCustomer(CustomerRequestModel customerRequestModel) {
        return  customerResponseMapper.entityToResponseModel(customerServiceClient.addCustomer(customerRequestModel));
    }

    @Override
    public CustomerResponseModel updateCustomer(CustomerRequestModel customerRequestModel, String customerId) {
        return customerResponseMapper.entityToResponseModel(customerServiceClient.updateCustomer(customerId,customerRequestModel));
    }

}
