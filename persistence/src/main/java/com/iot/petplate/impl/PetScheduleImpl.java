package com.iot.petplate.impl;

import com.iot.petplate.crud.PetScheduleCrud;
import com.iot.petplate.domain.PetScheduleDomain;
import com.iot.petplate.dto.PetDTO;
import com.iot.petplate.dto.PetScheduleDTO;
import com.iot.petplate.entity.PetScheduleEntity;
import com.iot.petplate.repository.PetScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class PetScheduleImpl implements PetScheduleRepository {

    private final PetScheduleCrud petScheduleCrud;

    @Override
    public List<PetScheduleDTO> getAllPetScheduleByPet(PetDTO petDTO) {
        return petScheduleCrud.findAllByPetId(petDTO.getId()).stream().map(PetScheduleEntity::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<PetScheduleDomain> createAll(List<PetScheduleDomain> petScheduleDomainList) {
        deleteAll(petScheduleDomainList);
        List<PetScheduleEntity> petScheduleEntities = new ArrayList<>();
        List<PetScheduleDomain> petScheduleDomains = new ArrayList<>();

        petScheduleDomainList.forEach(petSchedule -> {
            petScheduleEntities.add(new PetScheduleEntity(petSchedule));
        });

        petScheduleCrud.saveAll(petScheduleEntities).forEach(petEntity -> {
            petScheduleDomains.add(petEntity.toDomain());
        });

        return petScheduleDomains;
    }

    @Override
    public void deleteAll(List<PetScheduleDomain> petScheduleDomainList) {
        petScheduleCrud.deleteAllByPetId(petScheduleDomainList.get(0).getPetId());
    }
}