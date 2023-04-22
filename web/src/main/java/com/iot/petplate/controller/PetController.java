package com.iot.petplate.controller;

import com.iot.petplate.dto.PetDTO;
import com.iot.petplate.dto.UserDTO;
import com.iot.petplate.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pet")
@RequiredArgsConstructor
public class PetController {
    private final PetService petService;

    @GetMapping()
    public ResponseEntity<List<PetDTO>> getAllPetDTOListByUser() {
        UserDTO userDTO = (UserDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok(petService.getAllPetListByUser(userDTO));
    }

    @PostMapping()
    public ResponseEntity<PetDTO> create(@RequestBody PetDTO petDTO) {
        UserDTO userDTO = (UserDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        petDTO.setUser(userDTO);
        return ResponseEntity.ok(petService.create(petDTO));
    }

    @PutMapping()
    public ResponseEntity<PetDTO> update(@RequestBody PetDTO petDTO) {
        UserDTO userDTO = (UserDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        petDTO.setUser(userDTO);
        return ResponseEntity.ok(petService.update(petDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PetDTO> delete(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(petService.delete(id));
    }
}
