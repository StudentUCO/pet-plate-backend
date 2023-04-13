package com.iot.petplate.dto;

import lombok.Data;

@Data
public class SignUpUserDTO {
    private Integer id;
    private String fullName;
    private String phoneNumber;
    private String email;
    private String password;
}
