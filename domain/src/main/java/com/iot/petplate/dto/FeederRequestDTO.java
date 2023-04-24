package com.iot.petplate.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FeederRequestDTO {

    private String serial;
    private Double cantidad;
    private LocalTime horario;

    public FeederRequestDTO(PetScheduleDTO petScheduleDTO){
        setSerial(petScheduleDTO.getPet().getFeeder().getSerial());
        setCantidad(petScheduleDTO.getPortion());
        setHorario(petScheduleDTO.getTime());
    }
}
