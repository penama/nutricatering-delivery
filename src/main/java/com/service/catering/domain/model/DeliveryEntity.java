package com.service.catering.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "Delivery")
@Data
public class DeliveryEntity {

  @Id public String id;
  public String foodPackageId;
  public String deliveryPersonId;
  public String status;
  public String comentary;
	public String createdDate;
	public String updateDate;
}
