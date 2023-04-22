package com.iot.petplate.entity;

import com.iot.petplate.domain.PetDomain;
import com.iot.petplate.dto.FeederDTO;
import com.iot.petplate.dto.PetDTO;
import com.iot.petplate.dto.UserDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pet")
@Getter
@Setter
@NoArgsConstructor
public class PetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    private Double weight;
    private String species;
    @Column(name = "feeder_id")
    private Integer feederId;
    @Column(name = "user_id", nullable = false)
    private Integer userId;

    public PetEntity(PetDomain petDomain) {
        setId(petDomain.getId());
        setName(petDomain.getName());
        setWeight(petDomain.getWeight());
        setSpecies(petDomain.getSpecies());
        setFeederId(petDomain.getFeederId());
        setUserId(petDomain.getUserId());
    }

    public PetDomain toDomain() {
        PetDomain petDomain = new PetDomain();
        petDomain.setId(getId());
        petDomain.setName(getName());
        petDomain.setWeight(getWeight());
        petDomain.setSpecies(getSpecies());
        petDomain.setFeederId(getFeederId());
        petDomain.setUserId(getUserId());
        return petDomain;
    }

    public PetDTO toDTO() {
        // TODO: 22/04/2023 como eliminar fragmento de codigo repetido en domain 
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
