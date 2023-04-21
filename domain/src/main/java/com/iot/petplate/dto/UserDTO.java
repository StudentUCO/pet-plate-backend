package com.iot.petplate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDTO {
    private Integer id;
    private String fullName;
    private String phoneNumber;
    private String email;

    public UserDTO(Integer id) {
        this.id = id;
    }
}
