package com.iot.petplate.controller;

import com.iot.petplate.dto.FeederDTO;
import com.iot.petplate.dto.UserDTO;
import com.iot.petplate.service.FeederService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feeder")
@RequiredArgsConstructor
public class FeederController {
    private final FeederService feederService;
    @GetMapping()
    public ResponseEntity<List<FeederDTO>> getAllFeederDTOListByUser() {
        UserDTO userDTO = (UserDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok(feederService.getAllFeederListByUser(userDTO));
    }

    @PostMapping()
    public ResponseEntity<FeederDTO> create(@RequestBody FeederDTO feederDTO) {
        UserDTO userDTO = (UserDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        feederDTO.setUserDTO(userDTO);
        return ResponseEntity.ok(feederService.create(feederDTO));
    }

    @PutMapping()
    public ResponseEntity<FeederDTO> update(@RequestBody FeederDTO feederDTO) {
        UserDTO userDTO = (UserDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        feederDTO.setUserDTO(userDTO);
        return ResponseEntity.ok(feederService.update(feederDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FeederDTO> delete(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(feederService.delete(id));
    }
}
