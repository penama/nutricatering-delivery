package com.service.catering.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "HistoryDelivery")
@Data
public class HistoryDeliveryEntity {

  @Id public String id;
  public String deliveryId;
  public String status;
  public String longitude;
  public String latitude;
  public String comentario;
  public String createdDate;
}
