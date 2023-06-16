package com.iot.petplate.repository;

import com.iot.petplate.domain.FeederDomain;
import com.iot.petplate.dto.FeederDTO;
import com.iot.petplate.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface FeederRepository {
    Optional<FeederDomain> getById(Integer id);
    List<FeederDTO> getAllFeederListByUser(UserDTO userDTO);
    FeederDomain create(FeederDomain feederDomain);
    FeederDomain update(FeederDomain feederDomain);
    void delete(FeederDomain feederDomain);
    int isFeederInUse(Integer id);
}
