package com.service.catering.application.service.interfaces;

import jakarta.persistence.Id;

public interface IDeliveryPersonServiceUpdateData {

	@Id
	public String id;
	public String name;
	public String foodPackageId;
	public String vehiculo;
	public String createdDate;
	public String status;

  public void updateDeliveryPerson(String deliveryPersonId, String name, String nit, String email)
      throws Exception;
}
