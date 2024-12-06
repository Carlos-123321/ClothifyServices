package com.example.designersubdomainservice.designersubdomain.dataaccesslayer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DesignerRepository extends JpaRepository<Designer, Integer> {

    Designer findDesignerByDesignerId(String designer_id);
}
