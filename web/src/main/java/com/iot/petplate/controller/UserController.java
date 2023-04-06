package com.iot.petplate.controller;

import com.iot.petplate.dto.UserDTO;
import com.iot.petplate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/default-list")
    public ResponseEntity<List<UserDTO>> getDefaultList() {
        return ResponseEntity.ok(userService.getDefaultList());
    }

    @GetMapping("/get-by/{email}")
    public ResponseEntity<UserDTO> getBy(@PathVariable String email) {
        return ResponseEntity.of(userService.findBy(email));
    }

}
