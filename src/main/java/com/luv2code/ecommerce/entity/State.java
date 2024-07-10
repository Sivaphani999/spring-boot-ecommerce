package com.luv2code.ecommerce.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "state")
public class State {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
}
