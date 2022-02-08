package com.App.Vet.business.concretes;

import com.App.Vet.business.abstracts.AdminService;
import com.App.Vet.core.dataAccess.UserDao;
import com.App.Vet.core.entities.User;
import com.App.Vet.dataAccess.abstracts.PetDao;
import com.App.Vet.entities.concretes.Pet;
import com.App.Vet.entities.dtos.UserDetailUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminManager implements AdminService {
    private final UserDao userDao;
    private final PetDao petDao;

    @Autowired
    public AdminManager(UserDao userDao, PetDao petDao) {
        this.userDao = userDao;
        this.petDao = petDao;
    }

    //User Management
    @Override
    public List<User> getAllUser() {
        return this.userDao.findAll();
    }

    @Override
    public List<User> findByUserKeyword(String keyword) {
        return this.userDao.findByKeyword(keyword);
    }

    @Override
    public User getByUserId(int id) {
        return this.userDao.getById(id);
    }

    @Override
    public User updateUser(UserDetailUpdateDto updateDto) {
        User user = this.userDao.findById(updateDto.getId());

        user.setUserName(updateDto.getUserName());
        user.setFirstName(updateDto.getFirstName());
        user.setLastName(updateDto.getLastName());
        user.setInformation(updateDto.getInformation());
        user.setRoles(updateDto.getRoles());
        return this.userDao.save(user);
    }

    @Override
    public void deleteUserById(int id) {
        this.userDao.deleteById(id);
    }

    //Pet Management
    @Override
    public List<Pet> getAllPet() {
        return this.petDao.findAll();
    }

    @Override
    public List<Pet> findByPetKeyword(String keyword) {
        return this.petDao.findByKeyword(keyword);
    }

    @Override
    public Pet getByPetId(int id) {
        return this.petDao.getById(id);
    }

    @Override
    public void deletePetById(int id) {
        this.petDao.deleteById(id);
    }


}
