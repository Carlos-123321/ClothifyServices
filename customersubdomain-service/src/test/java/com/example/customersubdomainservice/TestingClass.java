package com.example.customersubdomainservice;

import com.example.customersubdomainservice.customersubdomain.businesslayer.CustomerService;
import com.example.customersubdomainservice.customersubdomain.presentationlayer.CustomerController;
import com.example.customersubdomainservice.customersubdomain.presentationlayer.CustomerRequestModel;
import com.example.customersubdomainservice.customersubdomain.presentationlayer.CustomerResponseModel;
import com.example.customersubdomainservice.utils.GlobalControllerExceptionHandler;
import com.example.customersubdomainservice.utils.exceptions.CustomerNotFoundException;
import com.example.customersubdomainservice.utils.exceptions.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;


import java.util.Collections;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;




@SpringBootTest(classes = CustomerController.class)
class ProductControllerUnitTest {

    private final GlobalControllerExceptionHandler handler = new GlobalControllerExceptionHandler();

    @Autowired
    CustomerController customerController;

    @MockBean
    CustomerService customerService;

    private final String FOUND_PRODUCT_ID = "1";
    private final String NOT_FOUND_PRODUCT_ID = "100";


//    @Test
//    public void whenNocustomerExists_thenReturnEmptyList(){
//        //arrange
//        when(customerService.getCustomers()).thenReturn(Collections.EMPTY_LIST);
//
//        //act
//        ResponseEntity<List<CustomerResponseModel>> responseEntity= customerController.getCustomers();
//
//        //assert
//        assertNotNull(responseEntity);
//        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
//        assertTrue(responseEntity.getBody().isEmpty());
//        verify(customerService, times(1)).getCustomers();
//    }



    @Test
    public void whencustomerExists_thenReturnproduct(){
        //arrange

        CustomerRequestModel customerRequestModel= CustomerRequestModel.builder().build();
        CustomerResponseModel customerResponseModel= CustomerResponseModel.builder().build();

        when(customerService.addCustomer(customerRequestModel)).thenReturn(customerResponseModel);

        //act
        ResponseEntity<CustomerResponseModel> responseEntity= customerController.addCustomer(customerRequestModel);

        //assert
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertEquals(customerResponseModel, responseEntity.getBody());
        verify(customerService, times(1)).addCustomer(customerRequestModel);
    }

    @Test
    public void whencustomerExists_thenDeletecustomer() throws NotFoundException {
        // Arrange
        doNothing().when(customerService).deleteCustomer(FOUND_PRODUCT_ID);

        // Act
        ResponseEntity<Void> responseEntity = customerController.deleteCustomer(FOUND_PRODUCT_ID);

        // Assert
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
        verify(customerService, times(1)).deleteCustomer(FOUND_PRODUCT_ID);
    }

    @Test
    public void WhencustomerDoesNotExistOnDelete_thenReturnNotFoundException() throws NotFoundException {
        // Arrange
        String nonExistentCustomerId = "non-existent-custumer-id";
        doThrow(NotFoundException.class).when(customerService).deleteCustomer(nonExistentCustomerId);

        // Act and Assert
        try {
            customerController.deleteCustomer(nonExistentCustomerId);
            fail("Expected NotFoundException");
        } catch (NotFoundException e) {
            // Verify that NotFoundException was thrown
            verify(customerService, times(1)).deleteCustomer(nonExistentCustomerId);
        }
    }

    @Test
    public void whencustomerNotFoundOnGet_thenReturnNotFoundException() {
        // Arrange
        when(customerService.getCustomerByCustomerId(NOT_FOUND_PRODUCT_ID)).thenThrow(NotFoundException.class);

        // Act and Assert
        try {
            customerController.getCustomerByCustomerId(NOT_FOUND_PRODUCT_ID);
            fail("Expected NotFoundException");
        } catch (NotFoundException e) {
            // Verify that NotFoundException was thrown
            verify(customerService, times(1)).getCustomerByCustomerId(NOT_FOUND_PRODUCT_ID);
        }
    }

    @Test
    public void whencustomerNotExistOnUpdate_thenReturnNotFoundException() throws NotFoundException {
        // Arrange
        CustomerRequestModel updatedcustomer = new CustomerRequestModel();
        when(customerService.updateCustomer(updatedcustomer, NOT_FOUND_PRODUCT_ID)).thenThrow(NotFoundException.class);

        // Act and Assert
        try {
            customerController.updateCostumer(updatedcustomer, NOT_FOUND_PRODUCT_ID);
            fail("Expected NotFoundException");
        } catch (NotFoundException e) {
            // Verify that NotFoundException was thrown
            verify(customerService, times(1)).updateCustomer(updatedcustomer, NOT_FOUND_PRODUCT_ID);
        }
    }


    @Test
    public void whencustomerExist_thenReturnUpdateproduct() throws NotFoundException {
        // Arrange
        String existingcustomerId = "existing-customer-id";
        CustomerRequestModel updatedcustomer = new CustomerRequestModel();
        CustomerResponseModel updatedResponse = CustomerResponseModel.builder().customerId(FOUND_PRODUCT_ID).build();

        when(customerService.updateCustomer(updatedcustomer, FOUND_PRODUCT_ID)).thenReturn(updatedResponse);

        // Act
        ResponseEntity<CustomerResponseModel> responseEntity = customerController.updateCostumer(updatedcustomer, FOUND_PRODUCT_ID);

        // Assert
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertEquals(FOUND_PRODUCT_ID, responseEntity.getBody().getCustomerId());
        verify(customerService, times(1)).updateCustomer(updatedcustomer, FOUND_PRODUCT_ID);
    }

    @Test
    void handleCustomerNotFoundException() {
        CustomerNotFoundException ex = new CustomerNotFoundException("Not found");
        WebRequest request = mock(WebRequest.class);
        HttpStatus expectedStatus = HttpStatus.NOT_FOUND;

        assertEquals(expectedStatus, handler.handleNotFoundException(request, ex).getHttpStatus());
        assertNotNull(handler.handleNotFoundException(request, ex).getMessage());
    }

}