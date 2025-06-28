package com.service.catering.infraestructure.event.querys;

import java.util.List;

import com.service.catering.domain.model.FoodPackageEntity;

public interface IQueryFoodPackageRepository {

  public List<FoodPackageEntity> queryFoodPackages();

  public FoodPackageEntity queryFoodPackageById(String foodPackageId);
}
