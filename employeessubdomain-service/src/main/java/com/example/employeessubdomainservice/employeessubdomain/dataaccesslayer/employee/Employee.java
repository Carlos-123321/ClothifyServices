package com.example.employeessubdomainservice.employeessubdomain.dataaccesslayer.employee;



import com.example.employeessubdomainservice.common.EmployeeIdentifier;
import com.example.employeessubdomainservice.employeessubdomain.dataaccesslayer.department.DepartmentIdentifier;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;


@Entity
@Table(name="employees")
@Data
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Embedded
    private EmployeeIdentifier employeeIdentifier;

    @Embedded
    private Address address;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "employee_phonenumbers", joinColumns = @JoinColumn(name="employee_id"))
    private List<PhoneNumber> phoneNumberList;

    private String firstName;
    private String lastName;
    private String emailAddress;


    @Embedded
    private DepartmentIdentifier departmentIdentifier;

    private String positionTitle;

    public Employee(@NotNull Address address, @NotNull List<PhoneNumber> phoneNumberList, @NotNull String firstName,
                    @NotNull String lastName, @NotNull String email,
                    @NotNull DepartmentIdentifier departmentIdentifier, @NotNull String title) {
        this.employeeIdentifier = new EmployeeIdentifier();
        this.address = address;
        this.phoneNumberList = phoneNumberList;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = email;
        this.departmentIdentifier = departmentIdentifier;
        this.positionTitle = title;
    }
}
