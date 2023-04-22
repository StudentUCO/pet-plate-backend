package com.iot.petplate.repository;

import com.iot.petplate.domain.PetDomain;
import com.iot.petplate.dto.PetDTO;
import com.iot.petplate.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface PetRepository {
    Optional<PetDomain> getById(Integer id);
    List<PetDTO> getAllPetListByUser(UserDTO userDTO);
    PetDomain create(PetDomain petDomain);
    PetDomain update(PetDomain petDomain);
    void delete(Integer id);
}
