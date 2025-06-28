package com.service.catering.infraestructure.event.querys;

import java.util.List;

import com.service.catering.domain.model.DeliveryPersonEntity;
import com.service.catering.domain.model.FoodPackageEntity;

public interface IQueryDeliveryPersonRepository {

  public List<DeliveryPersonEntity> queryDeliveryPersons();

  public DeliveryPersonEntity queryDeliveryPersonById(String deliveryPersonId);
}
