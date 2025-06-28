package com.service.catering.application.utils;

import com.service.catering.application.model.deliveryperson.DeliveryPersonDto;
import com.service.catering.domain.model.DeliveryPersonEntity;

public class DeliveryPersonUtil {

  public static DeliveryPersonEntity DeliberyPersonDtoToDeliveryPersonEntity(
      DeliveryPersonDto deliveryPersonDto) {
    DeliveryPersonEntity deliveryPersonEntity = new DeliveryPersonEntity();
    deliveryPersonEntity.setId(deliveryPersonDto.getId());
    deliveryPersonEntity.setStatus(deliveryPersonDto.getStatus());
    deliveryPersonEntity.setName(deliveryPersonDto.getName());
    deliveryPersonEntity.setVehiculo(deliveryPersonDto.getVehiculo());
    deliveryPersonEntity.setCreatedDate(deliveryPersonDto.getCreatedDate());
    return deliveryPersonEntity;
  }

  public static DeliveryPersonDto DeliveryPersonEntityToDeliberyPersonDto(
      DeliveryPersonEntity deliveryPersonEntity) {
    DeliveryPersonDto deliveryPersonDto = new DeliveryPersonDto();
    deliveryPersonDto.setId(deliveryPersonEntity.getId());
    deliveryPersonDto.setStatus(deliveryPersonEntity.getStatus());
    deliveryPersonDto.setName(deliveryPersonEntity.getName());
    deliveryPersonDto.setVehiculo(deliveryPersonEntity.getVehiculo());
    deliveryPersonDto.setCreatedDate(deliveryPersonEntity.getCreatedDate());
    return deliveryPersonDto;
  }
}
