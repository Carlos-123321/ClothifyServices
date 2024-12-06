package com.example.customersubdomainservice.customersubdomain.datamapperlayer;


import com.example.customersubdomainservice.customersubdomain.datalayer.Address;
import com.example.customersubdomainservice.customersubdomain.datalayer.Customer;
import com.example.customersubdomainservice.customersubdomain.datalayer.CustomerIdentifier;
import com.example.customersubdomainservice.customersubdomain.presentationlayer.CustomerRequestModel;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface CustomerRequestMapper {

    @Mapping(target = "id", ignore = true)
    Customer modelRequestToEntity(CustomerRequestModel customerRequestModel, CustomerIdentifier customerIdentifier,
                                  Address address
                              );
}

