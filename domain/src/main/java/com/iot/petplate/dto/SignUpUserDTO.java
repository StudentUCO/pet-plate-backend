package com.iot.petplate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SignUpUserDTO {
    private Integer id;
    private String fullName;
    private String phoneNumber;
    private String email;
    private String password;

    public UserDTO toUserDTO() {
        return new UserDTO(
                getId(), getFullName(),
                getPhoneNumber(), getEmail()
        );
    }
}
