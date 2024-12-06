package com.example.employeessubdomainservice.employeessubdomain.presentationlayer.employee;

import com.example.employeessubdomainservice.employeessubdomain.dataaccesslayer.employee.PhoneNumber;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)

public class EmployeeResponseModel extends RepresentationModel<EmployeeResponseModel> {

    String employeeId;
    String firstName;
    String lastName;
    String emailAddress;
    List<PhoneNumber> phoneNumbers;

    String streetAddress;
    String city;
    String province;
    String country;
    String postalCode;
    String departmentId;
    String departmentName;
    String title;

}
