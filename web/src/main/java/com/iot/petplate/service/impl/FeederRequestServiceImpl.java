package com.iot.petplate.service.impl;

import com.iot.petplate.client.http.BackendClient;
import com.iot.petplate.dto.FeederDTO;
import com.iot.petplate.dto.FeederRequestDTO;
import com.iot.petplate.dto.PetScheduleDTO;
import com.iot.petplate.dto.ScheduleDTO;
import com.iot.petplate.dto.UserDTO;
import com.iot.petplate.impl.FeederImpl;
import com.iot.petplate.service.FeederRequestService;
import com.project.exception.InvalidValueException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FeederRequestServiceImpl implements FeederRequestService {

    private final BackendClient backendClient;

    private final FeederImpl feederImpl;

    @Override
    public void sendDataFedeer(List<PetScheduleDTO> petScheduleDTOS) {
        try {
            backendClient.sendDataFeeder(buildFeederRequestDTOs(petScheduleDTOS));
        } catch (Exception e) {
            throw new InvalidValueException(
                    e.getMessage(),
                    "No hay comunicación hacia el backend II");
        }
    }

    private FeederRequestDTO buildFeederRequestDTOs(List<PetScheduleDTO> petScheduleDTOS) {
        UserDTO userDTO = (UserDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<FeederDTO> feederDTOS = feederImpl.getAllFeederListByUser(userDTO);
        List<LocalTime> schedules = new ArrayList<>();

        List<ScheduleDTO> schedules1 = petScheduleDTOS.stream().map(schedule ->
        new ScheduleDTO(schedule.getTime().toString(), schedule.getPortion())).toList();
        
    

        return FeederRequestDTO.builder()
                .serial(feederDTOS.get(0).getSerial())
                .schedules(schedules1).build();





                

        
    }

}
