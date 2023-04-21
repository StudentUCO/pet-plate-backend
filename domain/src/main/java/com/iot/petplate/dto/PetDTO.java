package com.iot.petplate.dto;

import lombok.Data;

@Data
public class PetDTO {
    private Integer id;
    private String name;
    private Double weight;
    private String species;
    private FeederDTO feeder;
    private UserDTO user;
}
