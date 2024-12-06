package com.example.clothingsubdomainservice.clothingsubdomain.businesslayer;


import com.example.clothingsubdomainservice.clothingsubdomain.presentationlayer.ClothingRequestDTO;
import com.example.clothingsubdomainservice.clothingsubdomain.presentationlayer.ClothingResponseDTO;

import java.util.List;

public interface ClothingService {

    List<ClothingResponseDTO> getAllClothing();

    ClothingResponseDTO getOneClothing(String clothingId);

    ClothingResponseDTO addClothing(ClothingRequestDTO clothingRequestDTO);

    ClothingResponseDTO updateClothing(ClothingRequestDTO clothingRequestDTO, String clothingId);

    void deleteClothing(String clothingId);

}
