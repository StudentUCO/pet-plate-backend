package com.iot.petplate.service;

import com.iot.petplate.domain.FeederDomain;
import com.iot.petplate.dto.FeederDTO;
import com.iot.petplate.dto.UserDTO;
import com.iot.petplate.repository.FeederRepository;
import com.project.exception.InvalidValueException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FeederService {
    private final FeederRepository feederRepository;

    public FeederDTO getById(Integer id) {
        return feederRepository.getById(id).orElse(new FeederDomain()).toDTO();
    }

    public List<FeederDTO> getAllFeederListByUser(UserDTO userDTO) {
        return feederRepository.getAllFeederListByUser(userDTO);
    }

    public FeederDTO create(FeederDTO feederDTO) {
        return feederRepository.create(new FeederDomain(feederDTO)).toDTO();
    }

    public FeederDTO update(FeederDTO feederDTO) {

        return feederRepository.update(new FeederDomain(feederDTO)).toDTO();
    }

    public FeederDTO delete(Integer id) {
        FeederDomain feederDomain = feederRepository.getById(id)
                .orElseThrow(() -> new InvalidValueException(
                        "FeederDomain no existe en DB",
                        "No existe el alimentador que quiere eliminar"));
        if (feederRepository.isFeederInUse(id) > 0) {
            throw new InvalidValueException("Al intentar eliminar el id se violaria una restriccion de " +
                    "clave foranea que se tiene con la tabla pet",
                    "No es posible eliminar el alimentador debido a que esta siendo utilizado por una mascota");
        }
        feederRepository.delete(feederDomain);
        return feederDomain.toDTO();
    }
}
