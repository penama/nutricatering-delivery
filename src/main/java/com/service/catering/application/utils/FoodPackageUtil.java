package com.service.catering.application.utils;

import com.service.catering.application.model.foodpackage.FoodPackageDto;
import com.service.catering.application.model.foodpackage.Customer;
import com.service.catering.domain.model.FoodPackageEntity;

public class FoodPackageUtil {

  public static FoodPackageEntity paymentDtoToPaymentEntity(FoodPackageDto foodPackageDto) {
    FoodPackageEntity foodPackageEntity = new FoodPackageEntity();
    foodPackageEntity.setId(foodPackageDto.getId());
    foodPackageEntity.setCreatedDate(foodPackageDto.getCreatedDate());
	foodPackageEntity.setFoods( foodPackageDto.getFoods() );
	foodPackageEntity.setStatus( foodPackageDto.getStatus() );
	foodPackageEntity.setCustomerId( foodPackageDto.getCustomer().getId() );
	foodPackageEntity.setUpdateDate( foodPackageDto.getUpdateDate() );
	foodPackageEntity.setStatusDelivery( foodPackageDto.getStatusEntrega() );
    return foodPackageEntity;
  }

  public static FoodPackageDto paymentEntityToPaymentDto(FoodPackageEntity foodPackageEntity) {
	  FoodPackageDto foodPackageDto = new FoodPackageDto();
	  foodPackageDto.setId(foodPackageEntity.getId());
	  foodPackageDto.setCreatedDate(foodPackageEntity.getCreatedDate());
	  foodPackageDto.setFoods( foodPackageEntity.getFoods() );
	  foodPackageDto.setStatus( foodPackageEntity.getStatus() );
	  Customer customer = new Customer( foodPackageEntity.getCustomerId() );
	  foodPackageDto.setCustomer( customer );
	  foodPackageDto.setUpdateDate( foodPackageEntity.getUpdateDate() );
	  foodPackageDto.setStatusEntrega( foodPackageEntity.getStatusDelivery() );
	  return foodPackageDto;
  }
}
