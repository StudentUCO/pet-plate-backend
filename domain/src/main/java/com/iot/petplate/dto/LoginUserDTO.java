package com.iot.petplate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginUserDTO {
    private Integer id;
    private String username;
    private String email;
    private String password;
}
