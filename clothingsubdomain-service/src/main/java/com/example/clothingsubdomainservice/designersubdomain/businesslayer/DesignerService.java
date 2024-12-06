package com.example.clothingsubdomainservice.designersubdomain.businesslayer;


import com.example.clothingsubdomainservice.designersubdomain.presentationlayer.designers.DesignerRequestDTO;
import com.example.clothingsubdomainservice.designersubdomain.presentationlayer.designers.DesignerResponseDTO;

import java.util.List;

public interface DesignerService {

    List<DesignerResponseDTO> getAllDesigners();

    DesignerResponseDTO getOneDesigner(String designerId);

    DesignerResponseDTO addDesigner(DesignerRequestDTO designerRequestDTO);



    DesignerResponseDTO updateDesigner(DesignerRequestDTO designerRequestDTO, String designerId);

    void deleteDesignerByDesignerId(String designerId);

}