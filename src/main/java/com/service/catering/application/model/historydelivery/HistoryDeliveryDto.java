package com.service.catering.application.model.historydelivery;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HistoryDeliveryDto {

  public String id;

  @NotBlank(message = "Delivery es mandatorio")
  public Delivery delivery;

  public String status;
  public String longitude;
  public String latitude;
  public String comentario;
  public String createdDate;
}
