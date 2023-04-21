package com.iot.petplate.crud;

import com.iot.petplate.entity.FeederEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FeederCrud extends CrudRepository<FeederEntity, Integer> {
    List<FeederEntity> findAllByUserId(Integer userId);
}
