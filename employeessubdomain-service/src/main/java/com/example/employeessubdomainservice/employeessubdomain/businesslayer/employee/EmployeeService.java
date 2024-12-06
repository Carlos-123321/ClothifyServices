package com.example.employeessubdomainservice.employeessubdomain.businesslayer.employee;


import com.example.employeessubdomainservice.employeessubdomain.presentationlayer.employee.EmployeeRequestModel;
import com.example.employeessubdomainservice.employeessubdomain.presentationlayer.employee.EmployeeResponseModel;

import java.util.List;

public interface EmployeeService {

    List<EmployeeResponseModel> getAllEmployees();
    EmployeeResponseModel getEmployeeByEmployeeId(String employeeId);
    EmployeeResponseModel addEmployee(EmployeeRequestModel employeeRequestModel);
    EmployeeResponseModel updateEmployee(EmployeeRequestModel employeeRequestModel, String employeeId);
    void removeEmployee(String employeeId);
}
