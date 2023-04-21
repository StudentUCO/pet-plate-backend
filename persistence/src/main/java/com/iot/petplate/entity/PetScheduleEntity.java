package com.iot.petplate.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Entity
@Table(name = "pet_schedule")
@Getter
@Setter
public class PetScheduleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private LocalTime time;
    @Column(nullable = false)
    private Double portion;
    @Column(name = "pet_id", nullable = false)
    private Integer petId;
}
