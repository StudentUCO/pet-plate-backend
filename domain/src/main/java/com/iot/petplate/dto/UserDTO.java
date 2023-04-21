package com.iot.petplate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable {
    private Integer id;
    private String fullName;
    private String phoneNumber;
    private String email;

    public UserDTO(Integer id) {
        this.id = id;
    }
}
