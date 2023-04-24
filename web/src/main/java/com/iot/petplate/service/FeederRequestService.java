package com.iot.petplate.service;

import com.iot.petplate.dto.PetScheduleDTO;

import java.util.List;

public interface FeederRequestService {

    void sendDataFedeer(List<PetScheduleDTO> petScheduleDTOS);

}
