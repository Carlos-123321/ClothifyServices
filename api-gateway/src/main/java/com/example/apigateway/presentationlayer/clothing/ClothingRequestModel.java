package com.example.apigateway.presentationlayer.clothing;

import lombok.*;

import java.math.BigDecimal;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)


public class ClothingRequestModel {

    private String name;
    private BigDecimal price;
    private String material;
    private String imageURL;
    private String designerId;
    /*
    private DesignerResponseDTO designer;
*/
    public ClothingRequestModel() {

    }
}
