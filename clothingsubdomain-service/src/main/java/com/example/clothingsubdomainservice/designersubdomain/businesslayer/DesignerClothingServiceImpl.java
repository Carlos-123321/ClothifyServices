package com.example.clothingsubdomainservice.designersubdomain.businesslayer;


import com.example.clothingsubdomainservice.clothingsubdomain.dataaccesslayer.Clothing;
import com.example.clothingsubdomainservice.clothingsubdomain.dataaccesslayer.ClothingRepository;
import com.example.clothingsubdomainservice.clothingsubdomain.presentationlayer.ClothingResponseDTO;
import com.example.clothingsubdomainservice.designersubdomain.dataaccesslayer.Designer;
import com.example.clothingsubdomainservice.designersubdomain.dataaccesslayer.DesignerRepository;
import com.example.clothingsubdomainservice.designersubdomain.presentationlayer.designerclothing.DesignerClothingResponseDTO;
import com.example.clothingsubdomainservice.designersubdomain.presentationlayer.designers.DesignerResponseDTO;
import com.example.clothingsubdomainservice.utils.exceptions.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DesignerClothingServiceImpl implements DesignerClothingService {


    private DesignerRepository designerRepository;
    private ClothingRepository clothingRepository;

    public DesignerClothingServiceImpl(DesignerRepository designerRepository, ClothingRepository clothingRepository) {
        this.designerRepository = designerRepository;
        this.clothingRepository = clothingRepository;
    }

    @Override
    public DesignerClothingResponseDTO getAllClothingByDesignerId(String clothingId) {
        Designer foundDesigner = designerRepository.findDesignerByDesignerId(clothingId);

        if(foundDesigner == null){
            throw new NotFoundException("Unknown designer id: " + clothingId);

        }

        DesignerClothingResponseDTO designerClothingResponseDTO = new DesignerClothingResponseDTO();
        BeanUtils.copyProperties(foundDesigner, designerClothingResponseDTO);

        List<Clothing> clothingList = clothingRepository.findClothingByDesigner_DesignerId(clothingId);

        List<ClothingResponseDTO> clothingResponseDTOList = new ArrayList<>();

        for(Clothing clothing : clothingList){

            ClothingResponseDTO clothingResponseDTO = new ClothingResponseDTO();
            BeanUtils.copyProperties(clothing, clothingResponseDTO);

            DesignerResponseDTO designerResponseDTO = new DesignerResponseDTO();
            BeanUtils.copyProperties(clothing.getDesigner(), designerResponseDTO);
            clothingResponseDTO.setDesigner(designerResponseDTO);
            clothingResponseDTOList.add(clothingResponseDTO);
        }

            designerClothingResponseDTO.setClothing(clothingResponseDTOList);


        return designerClothingResponseDTO;
    }
}

