package com.example.designersubdomainservice.clothingsubdomain.presentationlayer;

import com.example.designersubdomainservice.designersubdomain.presentationlayer.designers.DesignerResponseDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor

public class ClothingResponseDTO {

    private String clothingId;
    private String name;
    private BigDecimal price;
    private String material;
    private String imageURL;
    private DesignerResponseDTO designer;
}
