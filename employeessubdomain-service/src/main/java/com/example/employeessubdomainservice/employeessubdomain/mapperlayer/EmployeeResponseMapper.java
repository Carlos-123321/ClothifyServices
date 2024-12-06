package com.example.employeessubdomainservice.employeessubdomain.mapperlayer;


import com.example.employeessubdomainservice.employeessubdomain.dataaccesslayer.department.Department;
import com.example.employeessubdomainservice.employeessubdomain.dataaccesslayer.employee.Employee;
import com.example.employeessubdomainservice.employeessubdomain.presentationlayer.employee.EmployeeResponseModel;
import org.mapstruct.Mapper;

import org.mapstruct.Mapping;



@Mapper(componentModel = "spring")
public interface EmployeeResponseMapper {

    @Mapping(expression = "java(employee.getEmployeeIdentifier().getEmployeeId())", target = "employeeId")
    @Mapping(expression = "java(employee.getAddress().getStreetAddress())", target = "streetAddress")
    @Mapping(expression = "java(employee.getAddress().getCity())", target = "city")
    @Mapping(expression = "java(employee.getAddress().getProvince())", target = "province")
    @Mapping(expression = "java(employee.getAddress().getCountry())", target = "country")
    @Mapping(expression = "java(employee.getAddress().getPostalCode())", target = "postalCode")
    @Mapping(source = "employee.phoneNumberList", target = "phoneNumbers")
    @Mapping(source = "employee.positionTitle", target = "title")
    @Mapping(expression = "java(department.getDepartmentIdentifier().getDepartmentId())", target = "departmentId")
    @Mapping(expression = "java(department.getName())", target = "departmentName")
    EmployeeResponseModel entityToResponseModel(Employee employee, Department department);

}
