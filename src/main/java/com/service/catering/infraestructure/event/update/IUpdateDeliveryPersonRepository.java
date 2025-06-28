package com.service.catering.infraestructure.event.update;

import com.service.catering.domain.model.DeliveryPersonEntity;

public interface IUpdateDeliveryPersonRepository {

  public void updateDeliveryPerson(DeliveryPersonEntity deliveryPersonEntity);
}
