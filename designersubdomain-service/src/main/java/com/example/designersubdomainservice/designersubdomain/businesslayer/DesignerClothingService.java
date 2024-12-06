package com.example.designersubdomainservice.designersubdomain.businesslayer;


import com.example.designersubdomainservice.designersubdomain.presentationlayer.designerclothing.DesignerClothingResponseDTO;

public interface DesignerClothingService {

    DesignerClothingResponseDTO getAllClothingByDesignerId(String clothingId);


}
