package com.App.Vet.dataAccess.abstracts;

import com.App.Vet.entities.concretes.AnimalType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalTypeDao extends JpaRepository<AnimalType, Integer> {
}
