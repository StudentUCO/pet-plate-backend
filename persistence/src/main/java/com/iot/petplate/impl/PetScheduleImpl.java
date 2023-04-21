package com.iot.petplate.impl;

import com.iot.petplate.domain.PetScheduleDomain;
import com.iot.petplate.dto.PetDTO;
import com.iot.petplate.dto.PetScheduleDTO;
import com.iot.petplate.repository.PetScheduleRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PetScheduleImpl implements PetScheduleRepository {
    @Override
    public List<PetScheduleDTO> getAllPetScheduleByPet(PetDTO petDTO) {
        return null;
    }

    @Override
    public List<PetScheduleDomain> createAll(List<PetScheduleDomain> petScheduleDomainList) {
        return null;
    }

    @Override
    public void deleteAll(List<PetScheduleDomain> petScheduleDomainList) {

    }
}
