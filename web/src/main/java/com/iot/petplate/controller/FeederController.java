package com.iot.petplate.controller;

import com.iot.petplate.dto.FeederDTO;
import com.project.util.UtilList;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/api/feeder")
public class FeederController {
    @GetMapping("/get-all")
    public ResponseEntity<List<FeederDTO>> getAllFeederDTOList() {
        FeederDTO feederDTO = new FeederDTO();
        feederDTO.setId(1);
        feederDTO.setSerial("4164534232342");
        feederDTO.setName("Alimentador de Pol");
        List<FeederDTO> feederDTOList = UtilList.defaultFrom(feederDTO, 5);

        AtomicInteger cont = new AtomicInteger(0);
        feederDTOList.forEach(feeder -> feeder.setId(cont.incrementAndGet()));
        return ResponseEntity.ok(feederDTOList);
    }

    @PostMapping("/create")
    public ResponseEntity<FeederDTO> create(@RequestBody FeederDTO feederDTO) {
        feederDTO.setId(6);
        return ResponseEntity.ok(feederDTO);
    }

    @PutMapping("/update")
    public ResponseEntity<FeederDTO> update(@RequestBody FeederDTO feederDTO) {
        return ResponseEntity.ok(feederDTO);
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<FeederDTO> update(@PathVariable("id") Integer id) {
        FeederDTO feederDTO = new FeederDTO();
        feederDTO.setId(id);
        return ResponseEntity.ok(feederDTO);
    }
}
