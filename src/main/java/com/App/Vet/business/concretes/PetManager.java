package com.App.Vet.business.concretes;

import com.App.Vet.business.abstracts.PetService;
import com.App.Vet.dataAccess.abstracts.PetDao;
import com.App.Vet.entities.concretes.Pet;
import com.App.Vet.entities.dtos.PetUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetManager implements PetService {
    private final PetDao petDao;

    @Autowired
    public PetManager(PetDao petDao) {
        this.petDao = petDao;
    }

    @Override
    public List<Pet> getByUser_UserName(String userName) {
        return this.petDao.getByUser_UserName(userName);
    }

    @Override
    public Pet addPet(Pet pet) {
        return this.petDao.save(pet);
    }

    @Override
    public Pet getById(int id) {
        return this.petDao.getById(id);
    }

    @Override
    public Pet updatePet(PetUpdateDto updatePet) {
        Pet pet = this.petDao.findById(updatePet.getId());

        pet.setPetName(updatePet.getPetName());
        pet.setPetAge(updatePet.getPetAge());
        pet.setPetDescription(updatePet.getPetDescription());
        pet.setPetBreed(updatePet.getPetBreed());
        pet.setAnimalType(updatePet.getAnimalType());

        return this.petDao.save(pet);
    }

    @Override
    public void deletePetById(int id) {
        this.petDao.deleteById(id);
    }
}
