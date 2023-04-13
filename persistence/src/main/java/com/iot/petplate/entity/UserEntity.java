package com.iot.petplate.entity;

import com.iot.petplate.domain.UserDomain;
import com.iot.petplate.dto.LoginUserDTO;
import com.iot.petplate.dto.SignUpUserDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String email;
    private String password;

    public UserEntity(UserDomain userDomain) {
        setFullName(userDomain.getFullName());
        setPhoneNumber(userDomain.getPhoneNumber());
        setEmail(userDomain.getEmail());
        setPassword(userDomain.getPassword());
    }

    public UserEntity() {

    }

    public UserDomain toDomain() {
        return new UserDomain(
                getId(), getFullName(), getPhoneNumber(),
                getEmail(), getPassword()
        );
    }

    public SignUpUserDTO toSignUpUserDTO() {
        return new SignUpUserDTO(
                getId(), getFullName(), getPhoneNumber(), getEmail(), getPassword()
        );
    }
}
