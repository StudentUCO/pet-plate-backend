package com.iot.petplate.controller;

import com.iot.petplate.dto.SignUpUserDTO;
import com.iot.petplate.dto.UserAndPetDTO;
import com.iot.petplate.dto.UserDTO;
import com.iot.petplate.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/default-list")
    public ResponseEntity<List<UserDTO>> getDefaultList() {
        return ResponseEntity.ok(userService.getAllUserDTOList());
    }

    @GetMapping("/public/get-by-feeder/{serial}")
    public ResponseEntity<UserAndPetDTO> getUserAndPetByFeederSerial(@PathVariable("serial") String serial) {
        return ResponseEntity.ok(userService.getUserAndPetByFeederSerial(serial));
    }

    @PostMapping("/public/sign-up")
    public ResponseEntity<UserDTO> signUp(@RequestBody SignUpUserDTO signUpUserDTO) {
        signUpUserDTO.setPassword(passwordEncoder.encode(signUpUserDTO.getPassword()));
        return ResponseEntity.ok(userService.signUpUser(signUpUserDTO));
    }

}
