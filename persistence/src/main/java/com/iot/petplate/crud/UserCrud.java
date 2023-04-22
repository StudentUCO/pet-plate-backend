package com.iot.petplate.crud;

import com.iot.petplate.dto.UserAndPetDTO;
import com.iot.petplate.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserCrud extends CrudRepository<UserEntity, Integer> {
    Optional<UserEntity> findUserEntityByEmail(String email);

    @Query(value = "SELECT users.full_name as fullName, " +
            "users.phone_number as phoneNumber, " +
            "pet.name as petName " +
            "FROM feeder " +
            "INNER JOIN pet " +
            "ON pet.feeder_id = feeder.id " +
            "INNER JOIN users " +
            "ON pet.user_id = users.id " +
            "WHERE feeder.serial = :serial", nativeQuery = true)
    UserAndPetDTO getUserAndPetByFeederSerial(@Param("serial") String serial);
}
