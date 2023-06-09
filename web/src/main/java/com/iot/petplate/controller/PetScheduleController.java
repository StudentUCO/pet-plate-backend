package com.iot.petplate.controller;

import com.iot.petplate.dto.PetScheduleDTO;
import com.iot.petplate.service.FeederRequestService;
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

    private final FeederRequestService feederRequestService;

    @GetMapping("/{petId}")
    public ResponseEntity<List<PetScheduleDTO>> getAllPetScheduleByPet(@PathVariable Integer petId) {
        return ResponseEntity.ok(petScheduleService.getAllPetScheduleByPet(petId));
    }

    @PostMapping()
    public ResponseEntity<List<PetScheduleDTO>> createPetSchedule(@RequestBody List<PetScheduleDTO> petScheduleDTOS) {
        List<PetScheduleDTO> scheduleDTOList = petScheduleService.createPetSchedule(petScheduleDTOS);
        feederRequestService.sendDataFedeer(scheduleDTOList);
        return ResponseEntity.ok(scheduleDTOList);
    }
}
