package com.iot.petplate.controller;

import com.iot.petplate.dto.PetDTO;
import com.iot.petplate.dto.PetScheduleDTO;
import com.iot.petplate.service.PetScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pet-schedule")
@RequiredArgsConstructor
public class PetScheduleController {

    private final PetScheduleService petScheduleService;

    @GetMapping("/get-all")
    public ResponseEntity<List<PetScheduleDTO>> getAllPetScheduleByPet(@RequestBody PetDTO petDTO) {
        return ResponseEntity.ok(petScheduleService.getAllPetScheduleByPet(petDTO));
    }

    @PostMapping("/create")
    public ResponseEntity<List<PetScheduleDTO>> createPetSchedule(@RequestBody List<PetScheduleDTO> petScheduleDTOS) {
        return ResponseEntity.ok(petScheduleService.createPetSchedule(petScheduleDTOS));
    }
}
