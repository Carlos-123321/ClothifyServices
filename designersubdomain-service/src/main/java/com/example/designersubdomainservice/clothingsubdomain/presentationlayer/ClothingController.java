package com.example.designersubdomainservice.clothingsubdomain.presentationlayer;


import com.example.designersubdomainservice.clothingsubdomain.businesslayer.ClothingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/clothing")

public class ClothingController {

    private ClothingService clothingService;

    public ClothingController(ClothingService clothingService) {

        this.clothingService = clothingService;
    }


    @GetMapping()

    public List<ClothingResponseDTO> getClothing(){

        return clothingService.getAllClothing();
    }


    @GetMapping("/{clothingId}")

    public ResponseEntity<ClothingResponseDTO> getClothingByClothingId(@PathVariable String clothingId){

        return ResponseEntity.status(HttpStatus.OK).body(clothingService.getOneClothing(clothingId));
    }


    @PostMapping()

    public ResponseEntity<ClothingResponseDTO> addClothing(@RequestBody ClothingRequestDTO clothingRequestDTO){

        return ResponseEntity.status(HttpStatus.CREATED).body(clothingService.addClothing(clothingRequestDTO));
    }


    @PutMapping("/{clothingId}")

    public ClothingResponseDTO updateClothing(@RequestBody ClothingRequestDTO clothingRequestDTO,
                                               @PathVariable String clothingId){

        return clothingService.updateClothing(clothingRequestDTO, clothingId);
    }


    @DeleteMapping("/{clothingId}")

    public ResponseEntity<Void> deleteClothing(@PathVariable String clothingId){

        clothingService.deleteClothing(clothingId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}