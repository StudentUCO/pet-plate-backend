package com.iot.petplate.repository;

import com.iot.petplate.domain.PetDomain;
import com.iot.petplate.dto.PetDTO;
import com.iot.petplate.dto.UserDTO;

import java.util.List;

public interface PetRepository {
    List<PetDTO> getAllPetListByUser(UserDTO userDTO);
    PetDomain create(PetDomain petDomain);
    PetDomain update(PetDomain petDomain);
    void delete(PetDomain petDomain);
}
