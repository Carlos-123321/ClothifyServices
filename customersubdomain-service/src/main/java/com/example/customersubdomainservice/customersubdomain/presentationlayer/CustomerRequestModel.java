package com.example.customersubdomainservice.customersubdomain.presentationlayer;


import com.example.customersubdomainservice.customersubdomain.datalayer.PhoneNumber;
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




