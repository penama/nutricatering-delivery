package com.service.catering.infraestructure.event.querys;

import java.util.List;

import com.service.catering.domain.model.HistoryDeliveryEntity;

public interface IQueryHistoryDeliveryRepository {

  public List<HistoryDeliveryEntity> queryHistoryDeliverys();

  public List<HistoryDeliveryEntity> queryHistoryDeliverysByDeliveryId(String deliveryId);
}
