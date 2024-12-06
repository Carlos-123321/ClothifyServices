package com.example.apigateway.mapperlayer.customer;

import java.util.List;

import com.example.apigateway.presentationlayer.customer.CustomerController;
import com.example.apigateway.presentationlayer.customer.CustomerResponseModel;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.hateoas.Link;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Mapper(componentModel = "spring")
public interface CustomerResponseMapper {


    CustomerResponseModel entityToResponseModel(CustomerResponseModel customer);

    List<CustomerResponseModel> entityListToResponseModelList(List<CustomerResponseModel> customers);

    @AfterMapping
    default void addLinks(@MappingTarget CustomerResponseModel model) {
        Link selfLink = linkTo(methodOn(CustomerController.class).
                getCustomerByCustomerId(model.getCustomerId())).withSelfRel();
        model.add(selfLink);
    }
}
