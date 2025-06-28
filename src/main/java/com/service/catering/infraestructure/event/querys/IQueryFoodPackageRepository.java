package com.service.catering.infraestructure.event.querys;

import com.service.catering.domain.model.FoodPackageEntity;

import java.util.List;

public interface IQueryFoodPackageRepository {

  public List<FoodPackageEntity> queryFoodPackages();

  public FoodPackageEntity queryFoodPackageById(String foodPackageId);
}
