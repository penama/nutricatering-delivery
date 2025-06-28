package com.service.catering.application.utils;

import com.service.catering.application.model.delivery.DeliveryDto;
import com.service.catering.application.model.delivery.DeliveryPerson;
import com.service.catering.application.model.delivery.FoodPackage;
import com.service.catering.domain.model.DeliveryEntity;

public class DeliveryUtil {

  public static DeliveryEntity deliveryDtoToDeliveryEntity(DeliveryDto deliveryDto) {
    DeliveryEntity deliveryEntity = new DeliveryEntity();
    deliveryEntity.setId(deliveryDto.getId());
    deliveryEntity.setDeliveryPersonId(deliveryDto.getDeliveryPerson().getId());
    deliveryEntity.setComentary(deliveryDto.getComentary());
    deliveryEntity.setStatus(deliveryDto.getStatus());
    deliveryEntity.setCreatedDate(deliveryDto.getCreatedDate());
    deliveryEntity.setUpdateDate(deliveryDto.getUpdateDate());
    deliveryEntity.setFoodPackageId(deliveryDto.getFoodPackage().getId());
    return deliveryEntity;
  }

  public static DeliveryDto deliveryEntityToDeliveryDto(DeliveryEntity deliveryEntity) {
    DeliveryDto deliveryDto = new DeliveryDto();
    deliveryDto.setId(deliveryEntity.getId());
    DeliveryPerson deliveryPerson = new DeliveryPerson(deliveryEntity.getDeliveryPersonId());
    deliveryDto.setDeliveryPerson(deliveryPerson);
    deliveryDto.setComentary(deliveryEntity.getComentary());
    deliveryDto.setStatus(deliveryEntity.getStatus());
    deliveryDto.setCreatedDate(deliveryEntity.getCreatedDate());
    deliveryDto.setUpdateDate(deliveryEntity.getUpdateDate());
    FoodPackage foodPackage = new FoodPackage(deliveryEntity.getFoodPackageId());
    deliveryDto.setFoodPackage(foodPackage);
    return deliveryDto;
  }
}
