package com.service.catering.infraestructure.event.update;

import com.service.catering.domain.model.FoodPackageEntity;

public interface IUpdateFoodPackageRepository {

  public void updateFoodPackage(FoodPackageEntity foodPackageEntity);
}
