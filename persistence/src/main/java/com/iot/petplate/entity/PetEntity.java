package com.iot.petplate.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pet")
@Getter
@Setter
public class PetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    private Double weight;
    private String species;
    @Column(name = "feeder_id")
    private Integer feederId;
    @Column(name = "user_id", nullable = false)
    private Integer userId;
}
