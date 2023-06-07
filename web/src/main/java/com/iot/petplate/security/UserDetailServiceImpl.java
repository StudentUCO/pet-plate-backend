package com.iot.petplate.security;

import com.iot.petplate.dto.SignUpUserDTO;
import com.iot.petplate.service.UserService;
import com.project.exception.AuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    private final UserService userService;

    @Autowired
    public UserDetailServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        SignUpUserDTO signUpUserDTO = userService.findBy(usernameOrEmail)
                .orElseThrow(() -> new AuthException("SignUpUserDTO no encontrado por usernameOrEmail.", "El usuario " + usernameOrEmail + " no existe."));

        return new UserDetailsImpl(signUpUserDTO);
    }
}
