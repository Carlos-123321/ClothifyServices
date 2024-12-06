package com.example.clothingsubdomainservice.designersubdomain.businesslayer;

import com.example.clothingsubdomainservice.designersubdomain.presentationlayer.designerclothing.DesignerClothingResponseDTO;

public interface DesignerClothingService {

    DesignerClothingResponseDTO getAllClothingByDesignerId(String clothingId);


}
