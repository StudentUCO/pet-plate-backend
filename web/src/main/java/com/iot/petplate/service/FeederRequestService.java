package com.iot.petplate.service;

import com.iot.petplate.dto.PetScheduleDTO;

import java.util.List;

public interface FeederRequestService {

    void sendDataFeeder(List<PetScheduleDTO> petScheduleDTOS);
    void sendEmptyDataFeederByPetId(Integer petId);

}
