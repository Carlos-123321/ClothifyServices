package com.example.clothingsubdomainservice.clothingsubdomain.dataaccesslayer;


import com.example.clothingsubdomainservice.designersubdomain.dataaccesslayer.Designer;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table( name = "clothing")
@Data
@NoArgsConstructor
public class Clothing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "clothing_id")
    private String clothingId;

    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "material")
    private String material;

    @Column(name = "image_url")
    private String imageURL;



    @ManyToOne
    @JoinColumn(name = "designer_id", referencedColumnName = "designer_id")

    private Designer designer;

}
