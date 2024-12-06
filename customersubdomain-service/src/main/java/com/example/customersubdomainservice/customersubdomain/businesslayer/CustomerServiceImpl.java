package com.example.customersubdomainservice.customersubdomain.businesslayer;


import com.example.customersubdomainservice.customersubdomain.datalayer.Address;
import com.example.customersubdomainservice.customersubdomain.datalayer.Customer;
import com.example.customersubdomainservice.customersubdomain.datalayer.CustomerIdentifier;
import com.example.customersubdomainservice.customersubdomain.datalayer.CustomerRepository;
import com.example.customersubdomainservice.customersubdomain.datamapperlayer.CustomerRequestMapper;
import com.example.customersubdomainservice.customersubdomain.datamapperlayer.CustomerResponseMapper;
import com.example.customersubdomainservice.customersubdomain.presentationlayer.CustomerRequestModel;
import com.example.customersubdomainservice.customersubdomain.presentationlayer.CustomerResponseModel;
import com.example.customersubdomainservice.utils.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerResponseMapper customerResponseMapper;
    private final CustomerRequestMapper customerRequestMapper;



    public CustomerServiceImpl(CustomerRepository customerRepository,
                               CustomerResponseMapper customerResponseMapper,
                               CustomerRequestMapper customerRequestMapper) {
        this.customerRepository = customerRepository;
        this.customerResponseMapper = customerResponseMapper;
        this.customerRequestMapper = customerRequestMapper;
    }

    @Override
    public List<CustomerResponseModel> getCustomers() {
        return customerResponseMapper.entityListToResponseModelList(customerRepository.findAll());
    }

    @Override
    public CustomerResponseModel getCustomerByCustomerId(String customerId) {
        Customer customer = customerRepository.findByCustomerIdentifier_CustomerId(customerId);

        if (customer == null) {
            throw new NotFoundException("Unknown customerId: " + customerId);
        }
        return customerResponseMapper.entityToResponseModel(customer);
    }

    @Override
    public CustomerResponseModel addCustomer(CustomerRequestModel customerRequestModel) {
        Address address = new Address(customerRequestModel.getStreetAddress(), customerRequestModel.getCity(),
            customerRequestModel.getProvince(), customerRequestModel.getCountry(), customerRequestModel.getPostalCode());

        Customer customer = customerRequestMapper.modelRequestToEntity(customerRequestModel, new CustomerIdentifier(), address);

        customer.setAddress(address);
        return customerResponseMapper.entityToResponseModel(customerRepository.save(customer));
    }

    @Override
    public CustomerResponseModel updateCustomer(CustomerRequestModel customerRequestModel, String customerId) {

        Customer existingCustomer = customerRepository.findByCustomerIdentifier_CustomerId(customerId);

        //check if a customer with the provided UUID exists in the system. If it doesn't, return null
        //later, when we implement exception handling, we'll return an exception
        if (existingCustomer == null) {
            throw new NotFoundException("Unknown customerId: " + customerId);
        }
        Address address = new Address(customerRequestModel.getStreetAddress(), customerRequestModel.getCity(),
            customerRequestModel.getProvince(), customerRequestModel.getCountry(), customerRequestModel.getPostalCode());
        Customer updatedCustomer = customerRequestMapper.modelRequestToEntity(customerRequestModel,
            existingCustomer.getCustomerIdentifier(), address);
        updatedCustomer.setId(existingCustomer.getId());

        Customer response = customerRepository.save(updatedCustomer);
        return customerResponseMapper.entityToResponseModel(response);
    }

/*
    @Override
    public void removeCustomerByEmail(String email) {
        Customer existingCustomer = customerRepository.findCostumerByEmailAddress(email);

        if (existingCustomer == null) {
            throw new NotFoundException("Can't find Customer with email: " + email);
        }

        customerRepository.delete(existingCustomer);
    }
*/
    @Override
    public void deleteCustomer(String customerId) {
        Customer foundCustomer = customerRepository.findByCustomerIdentifier_CustomerId(customerId);

        if (foundCustomer == null) {
            throw new NotFoundException("Unknown customerId: " + customerId);
        }
        customerRepository.delete(foundCustomer);
    }

    @Override
    public void removeCustomerByEmail(String email) {

    }

    @Override
    public List<CustomerResponseModel> getCustomersByCountryByPhone(
            String country,
            Map<String, String> queryParams){

        List<Customer> customers;
        Set<String> keys = queryParams.keySet();

        customers = customerRepository.findAllByAddress_Country(country);

        return customerResponseMapper.entityListToResponseModelList(customers);
    }

}
