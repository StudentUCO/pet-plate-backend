package com.iot.petplate.entity;

import com.iot.petplate.domain.PetScheduleDomain;
import com.iot.petplate.dto.PetDTO;
import com.iot.petplate.dto.PetScheduleDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Entity
@Table(name = "pet_schedule")
@Getter
@Setter
@NoArgsConstructor
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

    public PetScheduleEntity(PetScheduleDomain petScheduleDomain) {
        setId(petScheduleDomain.getId());
        setPetId(petScheduleDomain.getPetId());
        setTime(petScheduleDomain.getTime());
        setPortion(petScheduleDomain.getPortion());
    }

    public PetScheduleDTO toDTO() {
        return PetScheduleDTO.builder()
                .id(getId())
                .pet(new PetDTO(getPetId()))
                .time(getTime())
                .portion(getPortion())
                .build();
    }

    public PetScheduleDomain toDomain() {
        return PetScheduleDomain.builder()
                .id(getId())
                .petId(getPetId())
                .time(getTime())
                .portion(getPortion())
                .build();
    }
}
