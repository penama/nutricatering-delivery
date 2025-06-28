package com.service.catering.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "FoodPackage")
@Data
public class FoodPackageEntity {

  @Id public String id;
  public String status;
  public String foods;
  public String customerId;
  public String customerAddressId;
  public String statusDelivery;
  public String createdDate;
  public String updateDate;
}
