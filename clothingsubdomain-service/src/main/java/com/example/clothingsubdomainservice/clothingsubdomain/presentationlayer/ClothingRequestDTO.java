package com.example.clothingsubdomainservice.clothingsubdomain.presentationlayer;

import lombok.*;

import java.math.BigDecimal;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)


public class ClothingRequestDTO {

    private String name;
    private BigDecimal price;
    private String material;
    private String imageURL;
    private String designerId;

    public ClothingRequestDTO() {

    }
}
