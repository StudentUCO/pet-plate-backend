package com.iot.petplate.crud;

import com.iot.petplate.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserCrud extends CrudRepository<UserEntity, Integer> {
    Optional<UserEntity> findUserEntityByEmail(String email);
}
