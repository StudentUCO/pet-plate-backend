package com.iot.petplate.repository;

import com.iot.petplate.domain.UserDomain;
import com.iot.petplate.dto.SignUpUserDTO;
import com.iot.petplate.dto.UserAndPetDTO;
import com.iot.petplate.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<UserDTO> getAllUserDTOList();
    Optional<SignUpUserDTO> findBy(String usernameOrEmail);
    UserAndPetDTO getUserAndPetByFeederSerial(String serial);
    UserDTO signUpUser(UserDomain userDomain);
}
