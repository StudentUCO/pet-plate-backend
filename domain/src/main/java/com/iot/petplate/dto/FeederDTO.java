package com.iot.petplate.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FeederDTO {
    private Integer id;
    private String serial;
    private String name;
    private UserDTO userDTO;

    public FeederDTO(Integer id) {
        setId(id);
    }
}
