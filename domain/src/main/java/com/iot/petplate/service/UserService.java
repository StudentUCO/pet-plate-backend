package com.iot.petplate.service;

import com.iot.petplate.domain.UserDomain;
import com.iot.petplate.dto.UserDTO;
import com.project.UtilList;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    public List<UserDTO> getDefaultList() {
        UserDomain userDomain = new UserDomain("Vive100", "test@test", "$2a$10$VovJ2UWNRg84u1QPppILb.lEuGkt7Imye8oNji72Rie39PZu1E2bW");
        List<UserDomain> userDomainList = UtilList.defaultFrom(userDomain, 10);
        return userDomainList.stream().map(UserDomain::toDTO).toList();
    }

    public Optional<UserDTO> findBy(String usernameOrEmail) {
        return getDefaultList().stream().filter(userDTO ->
                userDTO.getUsername().equals(usernameOrEmail) ||
                        userDTO.getEmail().equals(usernameOrEmail))
                .findFirst();
    }
}
