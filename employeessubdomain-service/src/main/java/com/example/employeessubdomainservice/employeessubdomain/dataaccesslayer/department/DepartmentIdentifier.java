package com.example.employeessubdomainservice.employeessubdomain.dataaccesslayer.department;

import jakarta.persistence.Embeddable;

import java.util.UUID;


@Embeddable
public class DepartmentIdentifier {

    private String departmentId;

    public DepartmentIdentifier() {
        this.departmentId = UUID.randomUUID().toString();
    }

    public String getDepartmentId() {
        return departmentId;
    }
}
