package com.iot.petplate.dto;

import lombok.Data;

import java.time.LocalTime;

@Data
public class PetScheduleDTO {
    private Integer id;
    private LocalTime time;
    private Double portion;
    private PetDTO pet;
}
