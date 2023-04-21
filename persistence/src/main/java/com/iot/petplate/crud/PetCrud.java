package com.iot.petplate.crud;

import com.iot.petplate.entity.PetEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PetCrud extends CrudRepository<PetEntity, Integer> {
    List<PetEntity> findAllByUserId(Integer userId);
}
