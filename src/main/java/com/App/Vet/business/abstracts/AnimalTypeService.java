package com.App.Vet.business.abstracts;

import com.App.Vet.entities.concretes.AnimalType;

import java.util.List;

public interface AnimalTypeService {
    List<AnimalType> getAll();
}
