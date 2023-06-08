package com.iot.petplate.service;

import com.iot.petplate.domain.PetScheduleDomain;
import com.iot.petplate.dto.PetScheduleDTO;
import com.iot.petplate.repository.PetScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PetScheduleService {

    private final PetScheduleRepository petScheduleRepository;

    public List<PetScheduleDTO> getAllPetScheduleByPet(Integer petId) {
        return petScheduleRepository.getAllPetScheduleByPet(petId);
    }

    public List<PetScheduleDTO> createPetSchedule(List<PetScheduleDTO> petScheduleDTOS) {
        List<PetScheduleDomain> petScheduleDomains = new ArrayList<>();
        petScheduleDTOS.forEach(petScheduleDTO -> {
            petScheduleDomains.add(petScheduleDTO.toDomain());
        });

        List<PetScheduleDomain> petScheduleDomainsResponse = petScheduleRepository.createAll(petScheduleDomains);
        List<PetScheduleDTO> petScheduleDTOList = new ArrayList<>();

        petScheduleDomainsResponse.forEach(petScheduleDomain ->
                petScheduleDTOList.add(petScheduleDomain.toDTO()));

        return petScheduleDTOList;
    }

    public void deleteAllPetSchedule(Integer petId) {
        petScheduleRepository.deleteAll(petId);
    }
}