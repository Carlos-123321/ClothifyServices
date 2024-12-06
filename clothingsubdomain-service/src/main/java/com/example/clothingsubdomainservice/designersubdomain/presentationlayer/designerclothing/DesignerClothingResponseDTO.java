package com.example.clothingsubdomainservice.designersubdomain.presentationlayer.designerclothing;


import com.example.clothingsubdomainservice.clothingsubdomain.presentationlayer.ClothingResponseDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class DesignerClothingResponseDTO {

    private String designerId;
    private String name;
    private LocalDate dob;
    private String country;
    private String KimageURL;
    private List<ClothingResponseDTO> clothing;

}
