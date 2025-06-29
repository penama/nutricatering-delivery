package com.service.catering.application.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.catering.application.model.foodpackage.*;
import com.service.catering.application.utils.FoodPackageUtil;
import com.service.catering.domain.model.FoodPackageEntity;
import com.service.catering.infraestructure.event.querys.IQueryFoodPackageRepository;
import com.service.catering.infraestructure.utils.DateFormat;

@Service
public class FoodPackageService extends BaseCommandHandler {

  @Autowired private IQueryFoodPackageRepository iQueryFoodPackageRepository;

  public FoodPackageDto newFoodPackage(FoodPackageDto foodPackageDto) throws Exception {
    FoodPackageEntity foodPackageEntity =
        FoodPackageUtil.foodPackageDtoToFoodPackageEntity(foodPackageDto);
    commandHandler(this, foodPackageEntity);
    return FoodPackageUtil.foodPackageEntityToFoodPackageDto(foodPackageEntity);
  }

  public List<FoodPackageDto> getFoodPackages() throws Exception {
    List<FoodPackageEntity> foodPackageEntityList = iQueryFoodPackageRepository.queryFoodPackages();
    List<FoodPackageDto> foodPackageDtos = new ArrayList<>();
    for (FoodPackageEntity foodPackageEntity : foodPackageEntityList) {
      foodPackageDtos.add(FoodPackageUtil.foodPackageEntityToFoodPackageDto(foodPackageEntity));
    }
    return foodPackageDtos;
  }

  public FoodPackageDto getFoodPackageById(String id) throws Exception {
    FoodPackageEntity foodPackageEntity = iQueryFoodPackageRepository.queryFoodPackageById(id);
    return FoodPackageUtil.foodPackageEntityToFoodPackageDto(foodPackageEntity);
  }

  public void updateFoodPackage(FoodPackageEntity foodPackageEntity) throws Exception {
    foodPackageEntity.setUpdateDate(DateFormat.toDate());
  }
}
