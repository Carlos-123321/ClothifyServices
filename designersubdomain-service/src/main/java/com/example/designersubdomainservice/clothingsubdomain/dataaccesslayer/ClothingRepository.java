package com.example.designersubdomainservice.clothingsubdomain.dataaccesslayer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClothingRepository extends JpaRepository<Clothing, Integer>{

    Clothing findClothingByClothingId(String clothingId);

    List<Clothing> findClothingByDesigner_DesignerId(String designer_id);




}










