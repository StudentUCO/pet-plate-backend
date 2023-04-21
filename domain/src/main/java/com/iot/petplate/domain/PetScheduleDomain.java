package com.iot.petplate.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
public class PetScheduleDomain {
    private Integer id;
    private LocalTime time;
    private Double portion;
    private Integer petId;
}
