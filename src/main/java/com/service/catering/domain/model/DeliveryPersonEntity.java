package com.service.catering.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "DeliveryPerson")
@Data
public class DeliveryPersonEntity {

  @Id public String id;
  public String name;
  public String vehiculo;
	public String status;
  public String createdDate;
	public String updateDate;

}
