package com.example.customersubdomainservice.customersubdomain.businesslayer;

import com.example.customersubdomainservice.customersubdomain.presentationlayer.CustomerRequestModel;
import com.example.customersubdomainservice.customersubdomain.presentationlayer.CustomerResponseModel;

import java.util.List;
import java.util.Map;

public interface CustomerService {


    List<CustomerResponseModel> getCustomers();

    CustomerResponseModel getCustomerByCustomerId(String customerId);
    CustomerResponseModel addCustomer(CustomerRequestModel customerRequestModel);
    CustomerResponseModel updateCustomer(CustomerRequestModel updatedCustomer, String customerId);
    void deleteCustomer(String customerId);

    void removeCustomerByEmail(String email);

    List<CustomerResponseModel> getCustomersByCountryByPhone(String country, Map<String, String> queryParams);
}
