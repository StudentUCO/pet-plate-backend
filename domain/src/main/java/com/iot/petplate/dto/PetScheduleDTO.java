package com.iot.petplate.dto;

import com.iot.petplate.domain.PetScheduleDomain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PetScheduleDTO {
    private Integer id;
    private LocalTime time;
    private Double portion;
    private PetDTO pet;

    public PetScheduleDTO(PetScheduleDomain petScheduleDomain){
        setId(petScheduleDomain.getId());
        setPet(new PetDTO(petScheduleDomain.getPetId()));
        setTime(petScheduleDomain.getTime());
        setPortion(petScheduleDomain.getPortion());
    }

    public PetScheduleDomain toDomain(){
        return PetScheduleDomain.builder()
                .id(getId())
                .petId(getPet().getId())
                .time(getTime())
                .portion(getPortion())
                .build();
    }
}
