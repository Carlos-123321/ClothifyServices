package com.example.apigateway.presentationlayer.clothing;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)

public class ClothingResponseModel extends RepresentationModel<ClothingResponseModel>{

    private String clothingId;
    private String name;
    private BigDecimal price;
    private String material;
    private String imageURL;
    /*
    private DesignerResponseDTO designer;
    */
}



