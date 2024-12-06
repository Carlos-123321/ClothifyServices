package com.example.clothingsubdomainservice;

import com.example.clothingsubdomainservice.clothingsubdomain.businesslayer.ClothingService;
import com.example.clothingsubdomainservice.clothingsubdomain.presentationlayer.ClothingController;
import com.example.clothingsubdomainservice.clothingsubdomain.presentationlayer.ClothingRequestDTO;
import com.example.clothingsubdomainservice.clothingsubdomain.presentationlayer.ClothingResponseDTO;
import com.example.clothingsubdomainservice.utils.exceptions.NotFoundException;
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


@SpringBootTest(classes = ClothingController.class)
class ClothingControllerUnitTest {

    @Autowired
    ClothingController clothingController;

    @MockBean
    ClothingService clothingService;

    private final String FOUND_PRODUCT_ID = "1";
    private final String NOT_FOUND_PRODUCT_ID = "100";


//    @Test
//    public void whenNoclothingExists_thenReturnEmptyList(){
//        //arrange
//        when(clothingService.getAllClothing()).thenReturn(Collections.EMPTY_LIST);
//
//        //act
//        ResponseEntity<List<ClothingResponseDTO>> responseEntity= (ResponseEntity<List<ClothingResponseDTO>>) clothingController.getClothing();
//
//        //assert
//        assertNotNull(responseEntity);
//        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
//        assertTrue(responseEntity.getBody().isEmpty());
//        verify(clothingService, times(1)).getAllClothing();
//    }

    @Test
    public void whenclothingExists_thenReturnproduct(){
        //arrange

        ClothingRequestDTO clothingRequestDTO= ClothingRequestDTO.builder().build();
        ClothingResponseDTO clothingResponseDTO= ClothingResponseDTO.builder().build();

        when(clothingService.addClothing(clothingRequestDTO)).thenReturn(clothingResponseDTO);

        //act
        ResponseEntity<ClothingResponseDTO> responseEntity= clothingController.addClothing(clothingRequestDTO);

        //assert
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertEquals(clothingResponseDTO, responseEntity.getBody());
        verify(clothingService, times(1)).addClothing(clothingRequestDTO);
    }

    @Test
    public void whenclothingExists_thenDeleteclothing() throws NotFoundException {
        // Arrange
        doNothing().when(clothingService).deleteClothing(FOUND_PRODUCT_ID);

        // Act
        ResponseEntity<Void> responseEntity = clothingController.deleteClothing(FOUND_PRODUCT_ID);

        // Assert
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
        verify(clothingService, times(1)).deleteClothing(FOUND_PRODUCT_ID);
    }

    @Test
    public void WhenclothingDoesNotExistOnDelete_thenReturnNotFoundException() throws NotFoundException {
        // Arrange
        String nonExistentClothingId = "non-existent-clothing-id";
        doThrow(NotFoundException.class).when(clothingService).deleteClothing(nonExistentClothingId);

        // Act and Assert
        try {
            clothingController.deleteClothing(nonExistentClothingId);
            fail("Expected NotFoundException");
        } catch (NotFoundException e) {
            // Verify that NotFoundException was thrown
            verify(clothingService, times(1)).deleteClothing(nonExistentClothingId);
        }
    }

    @Test
    public void whenclothingNotFoundOnGet_thenReturnNotFoundException() {
        // Arrange
        when(clothingService.getOneClothing(NOT_FOUND_PRODUCT_ID)).thenThrow(NotFoundException.class);

        // Act and Assert
        try {
            clothingController.getClothingByClothingId(NOT_FOUND_PRODUCT_ID);
            fail("Expected NotFoundException");
        } catch (NotFoundException e) {
            // Verify that NotFoundException was thrown
            verify(clothingService, times(1)).getOneClothing(NOT_FOUND_PRODUCT_ID);
        }
    }

    @Test
    public void whenclothingNotExistOnUpdate_thenReturnNotFoundException() throws NotFoundException {
        // Arrange
        ClothingRequestDTO updatedclothing = new ClothingRequestDTO();
        when(clothingService.updateClothing(updatedclothing, NOT_FOUND_PRODUCT_ID)).thenThrow(NotFoundException.class);

        // Act and Assert
        try {
            clothingController.updateClothing(updatedclothing, NOT_FOUND_PRODUCT_ID);
            fail("Expected NotFoundException");
        } catch (NotFoundException e) {
            // Verify that NotFoundException was thrown
            verify(clothingService, times(1)).updateClothing(updatedclothing, NOT_FOUND_PRODUCT_ID);
        }
    }


//    @Test
//    public void whenclothingExist_thenReturnUpdateclothing() throws NotFoundException {
//        // Arrange
//        String existingclothingId = "existing-clothing-id";
//        ClothingRequestDTO updatedclothing = new ClothingRequestDTO();
//        ClothingResponseDTO updatedResponse = ClothingResponseDTO.builder().clothingId(FOUND_PRODUCT_ID).build();
//
//        when(clothingService.updateClothing(updatedclothing, FOUND_PRODUCT_ID)).thenReturn(updatedResponse);
//
//        // Act
//        ResponseEntity<ClothingResponseDTO> responseEntity = clothingController.updateClothing(updatedclothing, FOUND_PRODUCT_ID);
//
//
//        // Assert
//        assertNotNull(responseEntity);
//        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
//        assertNotNull(responseEntity.getBody());
//        assertEquals(FOUND_PRODUCT_ID, responseEntity.getBody().getClothingId());
//        verify(clothingService, times(1)).updateClothing(updatedclothing, FOUND_PRODUCT_ID);
//    }

}