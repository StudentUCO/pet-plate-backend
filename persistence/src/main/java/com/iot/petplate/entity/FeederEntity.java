package com.iot.petplate.entity;

import com.iot.petplate.domain.FeederDomain;
import com.iot.petplate.dto.FeederDTO;
import com.iot.petplate.dto.UserDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "feeder")
@Getter
@Setter
public class FeederEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true, nullable = false)
    private String serial;
    @Column(nullable = false)
    private String name;
    @Column(name = "user_id", nullable = false)
    private Integer userId;

    public FeederEntity(FeederDomain feederDomain) {
        setId(feederDomain.getId());
        setSerial(feederDomain.getSerial());
        setName(feederDomain.getName());
        setUserId(feederDomain.getUserId());
    }

    public FeederEntity() {
    }

    public FeederDTO toDTO() {
        FeederDTO feederDTO = new FeederDTO();
        feederDTO.setId(getId());
        feederDTO.setSerial(getSerial());
        feederDTO.setName(getName());
        feederDTO.setUserDTO(new UserDTO(getId()));
        return feederDTO;
    }

    public FeederDomain toDomain() {
        FeederDomain feederDomain = new FeederDomain();
        feederDomain.setId(getId());
        feederDomain.setSerial(getSerial());
        feederDomain.setName(getName());
        feederDomain.setUserId(getUserId());
        return feederDomain;
    }
}
