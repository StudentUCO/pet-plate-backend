package com.iot.petplate.repository;

import com.iot.petplate.domain.PetScheduleDomain;
import com.iot.petplate.dto.PetDTO;
import com.iot.petplate.dto.PetScheduleDTO;

import java.util.List;

public interface PetScheduleRepository {
    List<PetScheduleDTO> getAllPetScheduleByPet(Integer petId);
    List<PetScheduleDomain> createAll(List<PetScheduleDomain> petScheduleDomainList);
    void deleteAll(List<PetScheduleDomain> petScheduleDomainList);
}
