package com.example.employeessubdomainservice.employeessubdomain.businesslayer.department;


import com.example.employeessubdomainservice.employeessubdomain.presentationlayer.department.DepartmentRequestModel;
import com.example.employeessubdomainservice.employeessubdomain.presentationlayer.department.DepartmentResponseModel;

import java.util.List;

public interface DepartmentService {

    List<DepartmentResponseModel> getAllDepartments();
    DepartmentResponseModel getDepartmentByDepartmentId(String departmentId);
    DepartmentResponseModel addDepartment(DepartmentRequestModel departmentRequestModel);
    DepartmentResponseModel updateDepartment(DepartmentRequestModel departmentRequestModel, String departmentId);
    void removeDepartmentByDepartmentId(String departmentId);
}
