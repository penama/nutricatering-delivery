package com.service.catering.application.model.delivery;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DeliveryDto {

	public String id;
	@NotBlank(message = "FoodPackage es mandatorio" )
	public FoodPackage foodPackage;
	@NotBlank(message = "Delivery es mandatorio" )
	public DeliveryPerson deliveryPerson;
	public String status;
	public String comentary;
	public String createdDate;
	public String updateDate;

}
