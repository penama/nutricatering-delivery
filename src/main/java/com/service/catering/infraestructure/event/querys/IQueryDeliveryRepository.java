package com.service.catering.infraestructure.event.querys;

import java.util.List;

import com.service.catering.domain.model.DeliveryEntity;

public interface IQueryDeliveryRepository {

  public List<DeliveryEntity> queryDeliverys();

  public List<DeliveryEntity> queryDeliverysByPersonId(String personId);

  public DeliveryEntity queryDeliveryId(String deliveryId);
}
