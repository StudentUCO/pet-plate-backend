package com.iot.petplate.domain;

import com.iot.petplate.dto.UserDTO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserDomain {
    private String username;
    private String email;
    private String password;

    public UserDomain(UserDTO userDTO) {
        this.username = userDTO.getUsername();
        this.email = userDTO.getEmail();
        this.password = userDTO.getPassword();
    }

    public UserDTO toDTO() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(this.username);
        userDTO.setEmail(this.email);
        userDTO.setPassword(this.password);
        return userDTO;
    }
}
