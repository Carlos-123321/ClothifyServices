package com.example.designersubdomainservice.designersubdomain.dataaccesslayer;


import com.example.designersubdomainservice.clothingsubdomain.dataaccesslayer.Clothing;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table( name = "designers")
@Data
@NoArgsConstructor
public class Designer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="designer_id")
    private String designerId;

    private String name;

    @Column(name = "dob")
    private LocalDate dob;


    @Column(name="country")
    private String country;

    @Column(name="Kimageurl")
    private String KimageURL;

    @OneToMany(mappedBy = "designer")
    private Set<Clothing> clothing;


}


