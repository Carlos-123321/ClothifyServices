package com.example.employeessubdomainservice.employeessubdomain.mapperlayer;


import com.example.employeessubdomainservice.common.EmployeeIdentifier;
import com.example.employeessubdomainservice.employeessubdomain.dataaccesslayer.department.DepartmentIdentifier;
import com.example.employeessubdomainservice.employeessubdomain.dataaccesslayer.employee.Address;
import com.example.employeessubdomainservice.employeessubdomain.dataaccesslayer.employee.Employee;
import com.example.employeessubdomainservice.employeessubdomain.presentationlayer.employee.EmployeeController;
import com.example.employeessubdomainservice.employeessubdomain.presentationlayer.employee.EmployeeRequestModel;
import com.example.employeessubdomainservice.employeessubdomain.presentationlayer.employee.EmployeeResponseModel;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;

import org.mapstruct.MappingTarget;
import org.springframework.hateoas.Link;
import org.mapstruct.Mapping;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Mapper(componentModel = "spring")
public interface EmployeeRequestMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "employeeRequestModel.phoneNumbers", target = "phoneNumberList")
    @Mapping(source = "employeeRequestModel.title", target = "positionTitle")
    Employee requestModelToEntity(EmployeeRequestModel employeeRequestModel, EmployeeIdentifier employeeIdentifier,
                                  DepartmentIdentifier departmentIdentifier, Address address);


}


