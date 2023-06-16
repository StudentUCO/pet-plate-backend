package com.iot.petplate.crud;

import com.iot.petplate.entity.FeederEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FeederCrud extends CrudRepository<FeederEntity, Integer> {
    List<FeederEntity> findAllByUserId(Integer userId);

    @Query(value = "SELECT COUNT(*) " +
            "FROM pet " +
            "WHERE feeder_id = :feederId", nativeQuery = true)
    int isFeederInUse(@Param("feederId") int feederId);
}
