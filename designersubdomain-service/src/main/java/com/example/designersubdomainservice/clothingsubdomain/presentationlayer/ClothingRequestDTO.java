package com.example.designersubdomainservice.clothingsubdomain.presentationlayer;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class ClothingRequestDTO {

    private String name;
    private BigDecimal price;
    private String material;
    private String imageURL;
    private String designerId;
}
