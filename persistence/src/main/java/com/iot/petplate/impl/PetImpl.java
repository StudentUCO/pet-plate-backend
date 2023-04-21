package com.iot.petplate.impl;

import com.iot.petplate.domain.PetDomain;
import com.iot.petplate.dto.PetDTO;
import com.iot.petplate.dto.UserDTO;
import com.iot.petplate.repository.PetRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PetImpl implements PetRepository {
    @Override
    public List<PetDTO> getAllPetListByUser(UserDTO userDTO) {
        return null;
    }

    @Override
    public PetDomain create(PetDomain petDomain) {
        return null;
    }

    @Override
    public PetDomain update(PetDomain petDomain) {
        return null;
    }

    @Override
    public void delete(PetDomain petDomain) {

    }
}
