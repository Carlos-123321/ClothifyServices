package com.example.employeessubdomainservice.employeessubdomain.presentationlayer.department;


import com.example.employeessubdomainservice.employeessubdomain.businesslayer.department.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public ResponseEntity<List<DepartmentResponseModel>> getAllDepartments() {
        return ResponseEntity.ok().body(departmentService.getAllDepartments());
    }

    @GetMapping("{departmentId}")
    public ResponseEntity<DepartmentResponseModel> getDepartmentByDepartmentId(@PathVariable String departmentId) {
        return ResponseEntity.ok().body(departmentService.getDepartmentByDepartmentId(departmentId));
    }

    @PostMapping
    public ResponseEntity<DepartmentResponseModel> addDepartment(@RequestBody DepartmentRequestModel departmentRequestModel){
        return ResponseEntity.status(HttpStatus.CREATED).body(departmentService.addDepartment(departmentRequestModel));
    }

    @PutMapping("{departmentId}")
    public ResponseEntity<DepartmentResponseModel> updateDepartment(@RequestBody DepartmentRequestModel departmentRequestModel,
                                                                    @PathVariable String departmentId) {
        return ResponseEntity.ok().body(departmentService.updateDepartment(departmentRequestModel, departmentId));
    }

    @DeleteMapping("{departmentId}")
    public ResponseEntity<Void> removeDepartment(@PathVariable String departmentId) {
        departmentService.removeDepartmentByDepartmentId(departmentId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
