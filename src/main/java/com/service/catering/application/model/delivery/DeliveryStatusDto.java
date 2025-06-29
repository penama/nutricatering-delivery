package com.service.catering.application.model.delivery;

import lombok.Data;
import org.hibernate.dialect.identity.HANAIdentityColumnSupport;

import java.util.List;

@Data
public class DeliveryStatusDto {

  public String id;
  public String status;
  public String comentario;
  public List<HistoryDelivery> hitoryDeliveries;
}
