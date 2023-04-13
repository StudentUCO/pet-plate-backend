package com.iot.petplate.domain;

import com.iot.petplate.dto.SignUpUserDTO;
import com.iot.petplate.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UserDomain {
    private Integer id;
    private String fullName;
    private String phoneNumber;
    private String email;
    private String password;

    public UserDomain(SignUpUserDTO signUpUserDTO) {
        setFullName(signUpUserDTO.getFullName());
        setPhoneNumber(signUpUserDTO.getPhoneNumber());
        setEmail(signUpUserDTO.getEmail());
        setPassword(signUpUserDTO.getPassword());
    }

    public UserDTO toUserDTO() {
        return new UserDTO(
                getId(), getFullName(),
                getPhoneNumber(), getEmail()
        );
    }
}
