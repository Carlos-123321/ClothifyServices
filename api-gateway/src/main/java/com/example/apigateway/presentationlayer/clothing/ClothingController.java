package com.example.apigateway.presentationlayer.clothing;

import com.example.apigateway.businesslayer.clothing.ClothingService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/clothing")

public class ClothingController {
/*
    private ClothingService clothingService;

    public ClothingController(ClothingService clothingService) {

        this.clothingService = clothingService;
    }

/*
    @GetMapping()

    public List<ClothingResponseModel> getClothing(){

        return clothingService.getAllClothing();
    }
*/
/*
    @GetMapping("/{clothingId}")

    public ResponseEntity<ClothingResponseModel> getClothingByClothingId(@PathVariable String clothingId){

        return ResponseEntity.status(HttpStatus.OK).body(clothingService.getOneClothing(clothingId));
    }
*/
/*
    @PostMapping()

    public ResponseEntity<ClothingResponseModel> addClothing(@RequestBody ClothingRequestModel clothingRequestModel){

        return ResponseEntity.status(HttpStatus.CREATED).body(clothingService.addClothing(clothingRequestModel));
    }
*/
/*
    @PutMapping("/{clothingId}")

    public ClothingResponseModel updateClothing(@RequestBody ClothingRequestModel clothingRequestModel,
                                              @PathVariable String clothingId){

        return clothingService.updateClothing(clothingRequestModel, clothingId);
    }
*/
/*
    @DeleteMapping("/{clothingId}")

    public ResponseEntity<Void> deleteClothing(@PathVariable String clothingId){

        clothingService.deleteClothing(clothingId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
    */
}