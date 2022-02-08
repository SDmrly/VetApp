package com.App.Vet.business.abstracts;

import com.App.Vet.entities.concretes.Pet;
import com.App.Vet.entities.dtos.PetUpdateDto;

import java.util.List;

public interface PetService {
    List<Pet> getByUser_UserName(String userName);
    Pet addPet(Pet pet);
    Pet getById(int id);
    Pet updatePet(PetUpdateDto updatePet);
    void deletePetById(int id);
}
