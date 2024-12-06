package com.example.customersubdomainservice.customersubdomain.datalayer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;
@Entity
@Table(name="customers")
@Getter
@Setter
@NoArgsConstructor
public class Customer extends RepresentationModel<Customer>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Embedded
    private CustomerIdentifier customerIdentifier;

    private String firstName;
    private String lastName;
    private String emailAddress;

    @Embedded
    private Address address;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "customer_phonenumbers", joinColumns = @JoinColumn(name="customer_id"))
    private List<PhoneNumber> phoneNumbers;

    @JsonCreator
    public Customer(@JsonProperty("firstName")String firstName, @JsonProperty("lastName")String lastName, @JsonProperty("emailAddress")String emailAddress, @JsonProperty("address") Address address,
                    @JsonProperty("phoneNumbers") List<PhoneNumber> phoneNumberList) {
        this.customerIdentifier = new CustomerIdentifier();
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.address = address;
        this.phoneNumbers = phoneNumberList;
    }
}
