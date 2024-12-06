package com.example.employeessubdomainservice.employeessubdomain.mapperlayer;


import com.example.employeessubdomainservice.employeessubdomain.dataaccesslayer.department.Department;
import com.example.employeessubdomainservice.employeessubdomain.dataaccesslayer.department.DepartmentIdentifier;
import com.example.employeessubdomainservice.employeessubdomain.presentationlayer.department.DepartmentRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;



@Mapper(componentModel = "spring")
public interface DepartmentRequestMapper {

    @Mapping(target = "id", ignore = true)

    Department requestModelToEntity(DepartmentRequestModel departmentRequestModel, DepartmentIdentifier departmentIdentifier);

}
