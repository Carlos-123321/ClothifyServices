package com.example.customersubdomainservice.customersubdomain.datalayer;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Customer findByCustomerIdentifier_CustomerId(String customerId);

    Customer findCostumerByEmailAddress(String emailAddress);


    List<Customer> findAllByAddress_Country(String address_country);
}