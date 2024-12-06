package com.example.clothingsubdomainservice.clothingsubdomain.presentationlayer;


import com.example.clothingsubdomainservice.designersubdomain.presentationlayer.designers.DesignerResponseDTO;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)

public class ClothingResponseDTO extends RepresentationModel<ClothingResponseDTO>{

    private String clothingId;
    private String name;
    private BigDecimal price;
    private String material;
    private String imageURL;
    private DesignerResponseDTO designer;
}



