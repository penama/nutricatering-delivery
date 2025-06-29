package com.service.catering.application.model.delivery;

import java.util.List;

import lombok.Data;

@Data
public class DeliveryStatusDto {

  public String id;
  public String status;
  public String comentario;
  public List<HistoryDelivery> hitoryDeliveries;
}
