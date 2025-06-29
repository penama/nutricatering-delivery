package com.service.catering.application.model.delivery;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DeliveryDto {

  public String id;
  public FoodPackage foodPackage;
  public DeliveryPerson deliveryPerson;
  public String status;
  public String comentary;
  public String createdDate;
  public String updateDate;
}
