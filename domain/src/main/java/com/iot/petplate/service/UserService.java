package com.iot.petplate.service;

import com.iot.petplate.domain.UserDomain;
import com.iot.petplate.dto.LoginUserDTO;
import com.iot.petplate.dto.SignUpUserDTO;
import com.iot.petplate.dto.UserDTO;
import com.iot.petplate.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Optional<LoginUserDTO> findBy(String usernameOrEmail) {
        return userRepository.findBy(usernameOrEmail);
    }

    public List<UserDTO> getAllUserDTOList() {
        return userRepository.getAllUserDTOList();
    }

    public UserDTO signUpUser(SignUpUserDTO signUpUserDTO) {
        return userRepository.signUpUser(new UserDomain(signUpUserDTO));
    }
}
