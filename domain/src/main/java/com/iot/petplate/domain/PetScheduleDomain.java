package com.iot.petplate.domain;

import com.iot.petplate.dto.PetDTO;
import com.iot.petplate.dto.PetScheduleDTO;
import lombok.*;

import java.time.LocalTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PetScheduleDomain {
    private Integer id;
    private LocalTime time;
    private Double portion;
    private Integer petId;

    public PetScheduleDomain(PetScheduleDTO petScheduleDTO){
        setId(petScheduleDTO.getId());
        setPetId(petScheduleDTO.getPet().getId());
        setTime(petScheduleDTO.getTime());
        setPortion(petScheduleDTO.getPortion());
    }

    public PetScheduleDTO toDTO(){
        return PetScheduleDTO.builder()
                .id(getId())
                .pet(new PetDTO(getPetId()))
                .portion(getPortion())
                .time(getTime())
                .build();
    }
}
