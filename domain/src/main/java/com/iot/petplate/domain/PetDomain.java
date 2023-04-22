package com.iot.petplate.domain;

import com.iot.petplate.dto.FeederDTO;
import com.iot.petplate.dto.PetDTO;
import com.iot.petplate.dto.UserDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PetDomain {
    private Integer id;
    private String name;
    private Double weight;
    private String species;
    private Integer feederId;
    private Integer userId;

    public PetDomain(PetDTO petDTO) {
        setId(petDTO.getId());
        setName(petDTO.getName());
        setWeight(petDTO.getWeight());
        setSpecies(petDTO.getSpecies());
        setFeederId(petDTO.getFeeder() != null ? petDTO.getFeeder().getId() : null);
        setUserId(petDTO.getUser() != null ? petDTO.getUser().getId() : null);
    }

    public PetDTO toDTO() {
        PetDTO petDTO = new PetDTO();
        petDTO.setId(getId());
        petDTO.setName(getName());
        petDTO.setWeight(getWeight());
        petDTO.setSpecies(getSpecies());
        petDTO.setFeeder(new FeederDTO(getFeederId()));
        petDTO.setUser(new UserDTO(getUserId()));
        return petDTO;
    }
}
