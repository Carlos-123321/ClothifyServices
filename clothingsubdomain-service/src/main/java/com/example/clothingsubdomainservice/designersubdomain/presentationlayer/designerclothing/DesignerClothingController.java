package com.example.clothingsubdomainservice.designersubdomain.presentationlayer.designerclothing;


import com.example.clothingsubdomainservice.designersubdomain.businesslayer.DesignerClothingService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/designers/{designerId}/clothing")
public class DesignerClothingController {

    private DesignerClothingService designerClothingService;

    public DesignerClothingController(DesignerClothingService designerClothingService) {
        this.designerClothingService = designerClothingService;
    }

    @GetMapping
    public DesignerClothingResponseDTO getAllClothingForADesigner(@PathVariable String designerId){

        return designerClothingService.getAllClothingByDesignerId(designerId);
    }





}
