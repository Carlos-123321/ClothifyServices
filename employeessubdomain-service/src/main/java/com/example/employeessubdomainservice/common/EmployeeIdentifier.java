package com.example.employeessubdomainservice.common;

import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.util.UUID;

@Embeddable
@Getter
public class EmployeeIdentifier {

    private String employeeId;

    public EmployeeIdentifier() {

        this.employeeId = UUID.randomUUID().toString();
    }

    public EmployeeIdentifier(String employeeId) {
        this.employeeId = employeeId;
    }

}
