package com.example.designersubdomainservice.clothingsubdomain.businesslayer;


import com.example.designersubdomainservice.clothingsubdomain.presentationlayer.ClothingRequestDTO;
import com.example.designersubdomainservice.clothingsubdomain.presentationlayer.ClothingResponseDTO;

import java.util.List;

public interface ClothingService {

    List<ClothingResponseDTO> getAllClothing();

    ClothingResponseDTO getOneClothing(String clothingId);

    ClothingResponseDTO addClothing(ClothingRequestDTO clothingRequestDTO);

    ClothingResponseDTO updateClothing(ClothingRequestDTO clothingRequestDTO, String clothingId);

    void deleteClothing(String clothingId);

}
