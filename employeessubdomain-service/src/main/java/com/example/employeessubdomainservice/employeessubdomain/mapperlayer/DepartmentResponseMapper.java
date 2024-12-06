package com.example.employeessubdomainservice.employeessubdomain.mapperlayer;


import com.example.employeessubdomainservice.employeessubdomain.dataaccesslayer.department.Department;
import com.example.employeessubdomainservice.employeessubdomain.presentationlayer.department.DepartmentResponseModel;

import org.mapstruct.Mapping;
import org.mapstruct.Mapper;
import java.util.List;


@Mapper(componentModel = "spring")
public interface DepartmentResponseMapper {

    @Mapping(expression = "java(department.getDepartmentIdentifier().getDepartmentId())", target = "departmentId")
    DepartmentResponseModel entityToResponseModel(Department department);

    List<DepartmentResponseModel> entityListToResponseModelList(List<Department> departments);
}
