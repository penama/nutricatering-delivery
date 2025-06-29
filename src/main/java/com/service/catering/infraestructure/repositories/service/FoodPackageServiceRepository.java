package com.service.catering.infraestructure.repositories.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.catering.domain.model.FoodPackageEntity;
import com.service.catering.infraestructure.event.querys.IQueryFoodPackageRepository;
import com.service.catering.infraestructure.event.update.IUpdateFoodPackageRepository;
import com.service.catering.infraestructure.repositories.interfaces.FoodPackageRepository;
import com.service.catering.infraestructure.utils.DateFormat;

@Service
public class FoodPackageServiceRepository
    implements IQueryFoodPackageRepository, IUpdateFoodPackageRepository {

  @Autowired public FoodPackageRepository repository;

  public void newFoodPackage(FoodPackageEntity foodPackageEntity) throws Exception {
//    foodPackageEntity.id = UUID.randomUUID().toString();
    foodPackageEntity.createdDate = DateFormat.toDate();
    repository.save(foodPackageEntity);
  }

  @Override
  public List<FoodPackageEntity> queryFoodPackages() {
    return repository.findAll();
  }

  @Override
  public FoodPackageEntity queryFoodPackageById(String foodPackageId) {
    return repository.findById(foodPackageId).orElse(null);
  }

  @Override
  public void updateFoodPackage(FoodPackageEntity foodPackageEntity) {
    foodPackageEntity.setUpdateDate(DateFormat.toDate());
    repository.save(foodPackageEntity);
  }
}
