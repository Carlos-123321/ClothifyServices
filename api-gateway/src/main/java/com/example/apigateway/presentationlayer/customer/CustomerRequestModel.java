package com.example.apigateway.presentationlayer.customer;

import com.example.apigateway.domainclientlayer.customer.PhoneNumber;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)

public class CustomerRequestModel {

    String firstName;
    String lastName;
    String emailAddress;
    String streetAddress;
    String city;
    String province;
    String country;
    String postalCode;
    List<PhoneNumber> phoneNumbers;

    public CustomerRequestModel() {

    }
}





