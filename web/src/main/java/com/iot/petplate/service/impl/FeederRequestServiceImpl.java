package com.iot.petplate.service.impl;

import com.iot.petplate.client.http.BackendClient;
import com.iot.petplate.dto.FeederDTO;
import com.iot.petplate.dto.FeederRequestDTO;
import com.iot.petplate.dto.PetScheduleDTO;
import com.iot.petplate.dto.UserDTO;
import com.iot.petplate.impl.FeederImpl;
import com.iot.petplate.service.FeederRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FeederRequestServiceImpl implements FeederRequestService {

    private final BackendClient backendClient;

    private final FeederImpl feederImpl;

    @Override
    public void sendDataFedeer(List<PetScheduleDTO> petScheduleDTOS) {
        backendClient.sendDataFeeder(buildFeederRequestDTOs(petScheduleDTOS));
    }

    private List<FeederRequestDTO> buildFeederRequestDTOs(List<PetScheduleDTO> petScheduleDTOS) {
        UserDTO userDTO = (UserDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<FeederDTO> feederDTOS = feederImpl.getAllFeederListByUser(userDTO);
        String serial = feederDTOS.get(0).getSerial();
        return petScheduleDTOS.stream().map(schedule -> {
                    FeederRequestDTO feederRequestDTO = new FeederRequestDTO(schedule);
                    feederRequestDTO.setSerial(serial);
                    return feederRequestDTO;
                })
                .collect(Collectors.toList());
    }

}
