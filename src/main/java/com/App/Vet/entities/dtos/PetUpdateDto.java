package com.App.Vet.entities.dtos;

import com.App.Vet.entities.concretes.AnimalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetUpdateDto {
    private int id;
    private String petName;
    private String petAge;
    private String petDescription;
    private String petBreed;
    private AnimalType animalType;
}
