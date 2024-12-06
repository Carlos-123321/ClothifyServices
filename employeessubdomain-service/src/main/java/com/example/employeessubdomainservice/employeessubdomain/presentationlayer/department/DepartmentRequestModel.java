package com.example.employeessubdomainservice.employeessubdomain.presentationlayer.department;


import com.example.employeessubdomainservice.employeessubdomain.dataaccesslayer.department.Position;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentRequestModel {

    String name;
    Integer headCount;

    List<Position> positions;
}
