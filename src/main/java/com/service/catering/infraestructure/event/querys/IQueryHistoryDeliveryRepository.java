package com.service.catering.infraestructure.event.querys;

import com.service.catering.domain.model.HistoryDeliveryEntity;

import java.util.List;

public interface IQueryHistoryDeliveryRepository {

  public List<HistoryDeliveryEntity> queryHistoryDeliverys();
  public List<HistoryDeliveryEntity> queryHistoryDeliverysByDeliveryId(String deliveryId);

}
