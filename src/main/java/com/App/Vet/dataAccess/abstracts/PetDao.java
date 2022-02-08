package com.App.Vet.dataAccess.abstracts;

import com.App.Vet.entities.concretes.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetDao extends JpaRepository<Pet, Integer> {
    List<Pet> getByUser_UserName(String userName);
    Pet findById(int id);

    @Query("select p from Pet p where p.petName like %:keyword% or p.user.firstName like %:keyword% or p.user.lastName like %:keyword%")
    List<Pet> findByKeyword(@Param("keyword") String keyword);
}
