package com.App.Vet.business.concretes;

import com.App.Vet.business.abstracts.AnimalTypeService;
import com.App.Vet.dataAccess.abstracts.AnimalTypeDao;
import com.App.Vet.entities.concretes.AnimalType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalTypeManager implements AnimalTypeService {
    private final AnimalTypeDao animalTypeDao;

    @Autowired
    public AnimalTypeManager(AnimalTypeDao animalTypeDao) {
        this.animalTypeDao = animalTypeDao;
    }

    @Override
    public List<AnimalType> getAll() {
        return this.animalTypeDao.findAll();
    }
}
