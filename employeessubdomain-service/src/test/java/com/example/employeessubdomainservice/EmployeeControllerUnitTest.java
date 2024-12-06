package com.example.employeessubdomainservice;


import com.example.employeessubdomainservice.employeessubdomain.businesslayer.employee.EmployeeService;
import com.example.employeessubdomainservice.employeessubdomain.presentationlayer.employee.EmployeeController;
import com.example.employeessubdomainservice.employeessubdomain.presentationlayer.employee.EmployeeRequestModel;
import com.example.employeessubdomainservice.employeessubdomain.presentationlayer.employee.EmployeeResponseModel;
import com.example.employeessubdomainservice.utils.exceptions.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@SpringBootTest(classes = EmployeeController.class)
class EmployeeControllerUnitTest {

    @Autowired
    EmployeeController employeeController;

    @MockBean
    EmployeeService employeeService;

    private final String FOUND_PRODUCT_ID = "1";
    private final String NOT_FOUND_PRODUCT_ID = "100";


    @Test
    public void whenNoemployeeExists_thenReturnEmptyList(){
        //arrange
        when(employeeService.getAllEmployees()).thenReturn(Collections.EMPTY_LIST);

        //act
        ResponseEntity<List<EmployeeResponseModel>> responseEntity= employeeController.getAllEmployees();

        //assert
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertTrue(responseEntity.getBody().isEmpty());
        verify(employeeService, times(1)).getAllEmployees();
    }

    @Test
    public void whenemployeeExists_thenReturnemployee(){
        //arrange

        EmployeeRequestModel employeeRequestModel= EmployeeRequestModel.builder().build();
        EmployeeResponseModel employeeResponseModel= EmployeeResponseModel.builder().build();

        when(employeeService.addEmployee(employeeRequestModel)).thenReturn(employeeResponseModel);

        //act
        ResponseEntity<EmployeeResponseModel> responseEntity= employeeController.addEmployee(employeeRequestModel);

        //assert
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertEquals(employeeResponseModel, responseEntity.getBody());
        verify(employeeService, times(1)).addEmployee(employeeRequestModel);
    }

    @Test
    public void whenemployeeExists_thenDeleteemployee() throws NotFoundException {
        // Arrange
        doNothing().when(employeeService).removeEmployee(FOUND_PRODUCT_ID);

        // Act
        ResponseEntity<Void> responseEntity = employeeController.removeEmployee(FOUND_PRODUCT_ID);

        // Assert
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
        verify(employeeService, times(1)).removeEmployee(FOUND_PRODUCT_ID);
    }

    @Test
    public void WhenemployeeDoesNotExistOnDelete_thenReturnNotFoundException() throws NotFoundException {
        // Arrange
        String nonExistentEmployeeId = "non-existent-employee-id";
        doThrow(NotFoundException.class).when(employeeService).removeEmployee(nonExistentEmployeeId);

        // Act and Assert
        try {
            employeeController.removeEmployee(nonExistentEmployeeId);
            fail("Expected NotFoundException");
        } catch (NotFoundException e) {
            // Verify that NotFoundException was thrown
            verify(employeeService, times(1)).removeEmployee(nonExistentEmployeeId);
        }
    }

    @Test
    public void whenemployeeNotFoundOnGet_thenReturnNotFoundException() {
        // Arrange
        when(employeeService.getEmployeeByEmployeeId(NOT_FOUND_PRODUCT_ID)).thenThrow(NotFoundException.class);

        // Act and Assert
        try {
            employeeController.getEmployeeByEmployeeId(NOT_FOUND_PRODUCT_ID);
            fail("Expected NotFoundException");
        } catch (NotFoundException e) {
            // Verify that NotFoundException was thrown
            verify(employeeService, times(1)).getEmployeeByEmployeeId(NOT_FOUND_PRODUCT_ID);
        }
    }

    @Test
    public void whenemployeeNotExistOnUpdate_thenReturnNotFoundException() throws NotFoundException {
        // Arrange
        EmployeeRequestModel updatedemployee = new EmployeeRequestModel();
        when(employeeService.updateEmployee(updatedemployee, NOT_FOUND_PRODUCT_ID)).thenThrow(NotFoundException.class);

        // Act and Assert
        try {
            employeeController.updateEmployee(updatedemployee, NOT_FOUND_PRODUCT_ID);
            fail("Expected NotFoundException");
        } catch (NotFoundException e) {
            // Verify that NotFoundException was thrown
            verify(employeeService, times(1)).updateEmployee(updatedemployee, NOT_FOUND_PRODUCT_ID);
        }
    }


    @Test
    public void whenemployeeExist_thenReturnUpdateproduct() throws NotFoundException {
        // Arrange
        String existingemployeeId = "existing-employee-id";
        EmployeeRequestModel updatedemployee = new EmployeeRequestModel();
        EmployeeResponseModel updatedResponse = EmployeeResponseModel.builder().employeeId(FOUND_PRODUCT_ID).build();

        when(employeeService.updateEmployee(updatedemployee, FOUND_PRODUCT_ID)).thenReturn(updatedResponse);

        // Act
        ResponseEntity<EmployeeResponseModel> responseEntity = employeeController.updateEmployee(updatedemployee, FOUND_PRODUCT_ID);

        // Assert
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertEquals(FOUND_PRODUCT_ID, responseEntity.getBody().getEmployeeId());
        verify(employeeService, times(1)).updateEmployee(updatedemployee, FOUND_PRODUCT_ID);
    }

}