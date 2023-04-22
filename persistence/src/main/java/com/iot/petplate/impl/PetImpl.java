package com.iot.petplate.impl;

import com.iot.petplate.crud.PetCrud;
import com.iot.petplate.domain.PetDomain;
import com.iot.petplate.dto.PetDTO;
import com.iot.petplate.dto.UserDTO;
import com.iot.petplate.entity.PetEntity;
import com.iot.petplate.repository.PetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class PetImpl implements PetRepository {
    private final PetCrud petCrud;

    @Override
    public Optional<PetDomain> getById(Integer id) {
        return petCrud.findById(id).map(PetEntity::toDomain);
    }

    @Override
    public List<PetDTO> getAllPetListByUser(UserDTO userDTO) {
        return petCrud.findAllByUserId(userDTO.getId()).stream()
                .map(PetEntity::toDTO).toList();
    }

    @Override
    public PetDomain create(PetDomain petDomain) {
        petDomain.setId(null);
        return petCrud.save(new PetEntity(petDomain)).toDomain();
    }

    @Override
    public PetDomain update(PetDomain petDomain) {
        return petCrud.save(new PetEntity(petDomain)).toDomain();
    }

    @Override
    public void delete(Integer id) {
        petCrud.deleteById(id);
    }
}
