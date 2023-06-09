package com.iot.petplate.impl;

import com.iot.petplate.crud.UserCrud;
import com.iot.petplate.domain.UserDomain;
import com.iot.petplate.dto.SignUpUserDTO;
import com.iot.petplate.dto.UserAndPetDTO;
import com.iot.petplate.dto.UserDTO;
import com.iot.petplate.entity.UserEntity;
import com.iot.petplate.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class UserImpl implements UserRepository {
    private final UserCrud userCrud;
    @Override
    public List<UserDTO> getAllUserDTOList() {
        List<UserEntity> userEntityList = (List<UserEntity>) userCrud.findAll();
        return userEntityList.stream().map(userEntity -> userEntity.toDomain().toUserDTO()).toList();
    }

    @Override
    public Optional<SignUpUserDTO> findBy(String usernameOrEmail) {
        return userCrud.findUserEntityByEmail(usernameOrEmail).map(UserEntity::toSignUpUserDTO);
    }

    @Override
    public UserAndPetDTO getUserAndPetByFeederSerial(String serial) {
        return userCrud.getUserAndPetByFeederSerial(serial);
    }

    @Override
    public UserDTO signUpUser(UserDomain userDomain) {
        return userCrud.save(new UserEntity(userDomain)).toDomain().toUserDTO();
    }
}
