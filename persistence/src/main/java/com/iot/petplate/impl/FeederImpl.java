package com.iot.petplate.impl;

import com.iot.petplate.crud.FeederCrud;
import com.iot.petplate.domain.FeederDomain;
import com.iot.petplate.dto.FeederDTO;
import com.iot.petplate.dto.UserDTO;
import com.iot.petplate.entity.FeederEntity;
import com.iot.petplate.repository.FeederRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class FeederImpl implements FeederRepository {
    private final FeederCrud feederCrud;

    @Override
    public Optional<FeederDomain> getById(Integer id) {
        return feederCrud.findById(id).map(FeederEntity::toDomain);
    }

    @Override
    public List<FeederDTO> getAllFeederListByUser(UserDTO userDTO) {
        return feederCrud.findAllByUserId(userDTO.getId()).stream().map(FeederEntity::toDTO).toList();
    }

    @Override
    public FeederDomain create(FeederDomain feederDomain) {
        feederDomain.setId(null);
        return feederCrud.save(new FeederEntity(feederDomain)).toDomain();
    }

    @Override
    public FeederDomain update(FeederDomain feederDomain) {
        return feederCrud.save(new FeederEntity(feederDomain)).toDomain();
    }

    @Override
    public void delete(FeederDomain feederDomain) {
        feederCrud.delete(new FeederEntity(feederDomain));
    }
}
