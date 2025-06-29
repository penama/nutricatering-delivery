package com.service.catering.application.utils;

import com.service.catering.application.model.delivery.HistoryDelivery;
import com.service.catering.domain.model.HistoryDeliveryEntity;

public class HistoryDeliveryUtil {

  public static HistoryDelivery historyDeliveryEntityToHistoryDeliveryDto(
      HistoryDeliveryEntity historyDeliveryEntity) {
    HistoryDelivery historyDelivery = new HistoryDelivery();
    historyDelivery.setId(historyDeliveryEntity.getId());
    historyDelivery.setCreatedDate(historyDeliveryEntity.getCreatedDate());
    historyDelivery.setDeliveryId(historyDeliveryEntity.getDeliveryId());
    historyDelivery.setStatus(historyDeliveryEntity.getStatus());
    historyDelivery.setComentario(historyDeliveryEntity.getComentario());
    historyDelivery.setLatitude(historyDeliveryEntity.getLatitude());
    historyDelivery.setLongitude(historyDeliveryEntity.getLongitude());
    return historyDelivery;
  }
}
