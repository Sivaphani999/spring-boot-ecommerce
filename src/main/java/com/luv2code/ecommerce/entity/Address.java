package com.luv2code.ecommerce.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "address")
public class Address {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "state")
    private String state;

    @Column(name = "street")
    private String street;

    @Column(name = "zip_code")
    private String zipCode;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Orders order;

}
