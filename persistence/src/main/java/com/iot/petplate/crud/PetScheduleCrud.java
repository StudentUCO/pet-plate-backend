package com.iot.petplate.crud;

import com.iot.petplate.entity.PetScheduleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PetScheduleCrud extends CrudRepository<PetScheduleEntity, Integer> {
    List<PetScheduleEntity> findAllByPetId(Integer petId);

    @Transactional
    void deleteAllByPetId(@Param("petId") Integer petId);

}
