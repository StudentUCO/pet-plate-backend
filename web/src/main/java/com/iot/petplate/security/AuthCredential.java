package com.iot.petplate.security;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthCredential {
    private String username;
    private String email;
    private String password;
}
