package com.example.apigateway.businesslayer.customer;

import com.example.apigateway.presentationlayer.customer.CustomerRequestModel;
import com.example.apigateway.presentationlayer.customer.CustomerResponseModel;
import org.springframework.stereotype.Service;

import java.util.List;



public interface CustomerService {

    List<CustomerResponseModel> getCustomers();
    CustomerResponseModel getCustomerByCustomerId(String customerId);
    CustomerResponseModel addCustomer(CustomerRequestModel customerRequestModel);
    CustomerResponseModel updateCustomer(CustomerRequestModel updatedCustomer, String customerId);
    void removeCustomer(String customerId);
}
