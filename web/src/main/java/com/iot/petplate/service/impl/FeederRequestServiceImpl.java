package com.iot.petplate.service.impl;

import com.iot.petplate.client.http.BackendClient;
import com.iot.petplate.dto.*;
import com.iot.petplate.service.FeederRequestService;
import com.iot.petplate.service.FeederService;
import com.iot.petplate.service.PetService;
import com.project.exception.InvalidValueException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FeederRequestServiceImpl implements FeederRequestService {

    private final BackendClient backendClient;
    private final PetService petService;
    private final FeederService feederService;

    @Override
    public void sendDataFeeder(List<PetScheduleDTO> petScheduleDTOS) {
        try {
            backendClient.sendDataFeeder(buildFeederRequestDTO(petScheduleDTOS));
        } catch (Exception e) {
            throw new InvalidValueException(
                    e.getMessage(),
                    "No hay comunicación hacia el backend II");
        }
    }

    @Override
    public void sendEmptyDataFeederByPetId(Integer petId) {
        try {
            backendClient.sendDataFeeder(buildEmptyFeederRequestDTOByPetId(petId));
        } catch (Exception e) {
            throw new InvalidValueException(
                    e.getMessage(),
                    "No hay comunicación hacia el backend II");
        }
    }

    private FeederRequestDTO buildFeederRequestDTO(List<PetScheduleDTO> petScheduleDTOS) {
        PetDTO petDTO = petService.getById(petScheduleDTOS.get(0).getPet().getId());
        FeederDTO feederDTO = feederService.getById(petDTO.getFeeder().getId());
        List<ScheduleDTO> schedules = petScheduleDTOS.stream().map(schedule ->
                new ScheduleDTO(schedule.getTime().toString(), schedule.getPortion())).toList();

        return FeederRequestDTO.builder().serial(feederDTO.getSerial()).schedules(schedules).build();
    }

    private FeederRequestDTO buildEmptyFeederRequestDTOByPetId(Integer petId) {
        PetDTO petDTO = petService.getById(petId);
        FeederDTO feederDTO = feederService.getById(petDTO.getFeeder().getId());
        return FeederRequestDTO.builder().serial(feederDTO.getSerial()).schedules(Collections.emptyList()).build();
    }

}
