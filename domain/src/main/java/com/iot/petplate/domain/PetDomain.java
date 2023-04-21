package com.iot.petplate.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PetDomain {
    private Integer id;
    private String name;
    private Double weight;
    private String species;
    private Integer feederId;
    private Integer userId;
}
