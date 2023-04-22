package com.iot.petplate.service;

import com.iot.petplate.domain.PetDomain;
import com.iot.petplate.dto.PetDTO;
import com.iot.petplate.dto.UserDTO;
import com.iot.petplate.repository.PetRepository;
import com.project.exception.InvalidValueException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PetService {
    private final PetRepository petRepository;

    public List<PetDTO> getAllPetListByUser(UserDTO userDTO) {
        return petRepository.getAllPetListByUser(userDTO);
    }

    public PetDTO create(PetDTO petDTO) {
        return petRepository.create(new PetDomain(petDTO)).toDTO();
    }

    public PetDTO update(PetDTO petDTO) {
        return petRepository.update(new PetDomain(petDTO)).toDTO();
    }

    public PetDTO delete(Integer id) {
        PetDomain petDomain = petRepository.getById(id)
                .orElseThrow(() -> new InvalidValueException(
                        "PetDomain no existe en DB",
                        "No existe la mascota que quiere eliminar"));
        petRepository.delete(id);
        return petDomain.toDTO();
    }
}
