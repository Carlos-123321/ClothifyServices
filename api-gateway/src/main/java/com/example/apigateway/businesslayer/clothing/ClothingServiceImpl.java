package com.example.apigateway.businesslayer.clothing;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;



public class ClothingServiceImpl implements ClothingService {
/*
    private ClothingRepository clothingRepository;
    private DesignerRepository designerRepository;

    public ClothingServiceImpl(ClothingRepository clothingRepository, DesignerRepository designerRepository) {

        this.clothingRepository = clothingRepository;
        this.designerRepository = designerRepository;
    }

    @Override
    public List<ClothingResponseDTO> getAllClothing() {

        List<Clothing> clothingEntities = clothingRepository.findAll();
        //convert list of movie entities to list of MovieResponseDTO

        List<ClothingResponseDTO> clothingResponseDTOList = new ArrayList<>();

        for (Clothing clothing : clothingEntities) {
            ClothingResponseDTO clothingResponseDTO = new ClothingResponseDTO();
            BeanUtils.copyProperties(clothing, clothingResponseDTO);

            DesignerResponseDTO designerResponseDTO = new DesignerResponseDTO();
            BeanUtils.copyProperties(clothing.getDesigner(), designerResponseDTO);
            clothingResponseDTO.setDesigner(designerResponseDTO);

            clothingResponseDTOList.add(clothingResponseDTO);
        }

        return clothingResponseDTOList;
    }

    @Override
    public ClothingResponseDTO getOneClothing(String clothingId) {

        Clothing clothing = clothingRepository.findClothingByClothingId(clothingId);

        if (clothing == null) {
            throw new NotFoundException("Unknown clothingId: " + clothingId);
        }

        ClothingResponseDTO clothingResponseDTO = new ClothingResponseDTO();
        BeanUtils.copyProperties(clothing, clothingResponseDTO);

        DesignerResponseDTO designerResponseDTO = new DesignerResponseDTO();
        BeanUtils.copyProperties(clothing.getDesigner(), designerResponseDTO);
        clothingResponseDTO.setDesigner(designerResponseDTO);

        return clothingResponseDTO;
    }

    @Override
    public ClothingResponseDTO addClothing(ClothingRequestDTO clothingRequestDTO) {

        Designer foundDesigner = designerRepository.findDesignerByDesignerId(clothingRequestDTO.getDesignerId());

        if (foundDesigner == null) {
            throw new NotFoundException("Unknown designerId: " + clothingRequestDTO.getDesignerId());
        }

        Clothing clothing = new Clothing();
        BeanUtils.copyProperties(clothingRequestDTO, clothing);
        clothing.setClothingId(UUID.randomUUID().toString());

        clothing.setDesigner(foundDesigner);

        Clothing savedClothing = clothingRepository.save(clothing);

        ClothingResponseDTO clothingResponseDTO = new ClothingResponseDTO();
        BeanUtils.copyProperties(savedClothing, clothingResponseDTO);
        DesignerResponseDTO designerResponseDTO = new DesignerResponseDTO();
        BeanUtils.copyProperties(savedClothing.getDesigner(), designerResponseDTO);

        clothingResponseDTO.setDesigner(designerResponseDTO);

        return clothingResponseDTO;
    }

    @Override
    public ClothingResponseDTO updateClothing(ClothingRequestModel clothingRequestDTO, String clothingId) {

        Clothing foundClothing = clothingRepository.findClothingByClothingId(clothingId);

        if (foundClothing == null) {
            throw new NotFoundException("Unknown clothingId: " + clothingId);
        }

        Designer foundDesigner = designerRepository.findDesignerByDesignerId(clothingRequestDTO.getDesignerId());

        if (foundDesigner == null) {
            throw new NotFoundException("Unknown designerId: " + clothingRequestDTO.getDesignerId());
        }

        Clothing clothing = new Clothing();
        BeanUtils.copyProperties(clothingRequestDTO, clothing);


        clothing.setClothingId(foundClothing.getClothingId());
        clothing.setId(foundClothing.getId());

        clothing.setDesigner(foundDesigner);

        Clothing savedClothing = clothingRepository.save(clothing);


        ClothingResponseDTO clothingResponseDTO = new ClothingResponseDTO();
        BeanUtils.copyProperties(savedClothing, clothingResponseDTO);

        DesignerResponseDTO designerResponseDTO = new DesignerResponseDTO();
        BeanUtils.copyProperties(savedClothing.getDesigner(), designerResponseDTO);

        clothingResponseDTO.setDesigner(designerResponseDTO);


        return clothingResponseDTO;
    }

    @Override
    public void deleteClothing(String clothingId) {
        Clothing foundClothing = clothingRepository.findClothingByClothingId(clothingId);

        if (foundClothing == null) {
            throw new NotFoundException("Unknown clothingId: " + clothingId);
        }
        clothingRepository.delete(foundClothing);
    }
    */
}
