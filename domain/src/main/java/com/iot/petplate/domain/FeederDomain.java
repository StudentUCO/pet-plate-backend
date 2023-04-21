package com.iot.petplate.domain;

import com.iot.petplate.dto.FeederDTO;
import com.iot.petplate.dto.UserDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeederDomain {
    private Integer id;
    private String serial;
    private String name;
    private Integer userId;

    public FeederDomain(FeederDTO feederDTO) {
        setId(feederDTO.getId());
        setSerial(feederDTO.getSerial());
        setName(feederDTO.getName());
        setUserId(feederDTO.getUserDTO().getId());
    }

    public FeederDomain() {
    }

    public FeederDTO toDTO() {
        FeederDTO feederDTO = new FeederDTO();
        feederDTO.setId(getId());
        feederDTO.setSerial(getSerial());
        feederDTO.setName(getName());
        feederDTO.setUserDTO(new UserDTO(getId()));
        return feederDTO;
    }
}
