package com.App.Vet.business.abstracts;

import com.App.Vet.core.entities.User;
import com.App.Vet.entities.concretes.Pet;
import com.App.Vet.entities.dtos.UserDetailUpdateDto;

import java.util.List;

public interface AdminService {
    //User Management
    List<User> getAllUser();
    List<User> findByUserKeyword(String keyword);
    User getByUserId(int id);
    User updateUser(UserDetailUpdateDto updateDto);
    void deleteUserById(int id);

    //Pet Management
    List<Pet> getAllPet();
    List<Pet> findByPetKeyword(String keyword);
    Pet getByPetId(int id);
    void deletePetById(int id);


}
