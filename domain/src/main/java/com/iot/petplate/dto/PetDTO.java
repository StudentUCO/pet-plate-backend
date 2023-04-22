package com.iot.petplate.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PetDTO {
    private Integer id;
    private String name;
    private Double weight;
    private String species;
    private FeederDTO feeder;
    private UserDTO user;

    public PetDTO(Integer petId) {
        this.id = petId;
    }
}
