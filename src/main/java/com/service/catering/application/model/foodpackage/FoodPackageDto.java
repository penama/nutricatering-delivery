package com.service.catering.application.model.foodpackage;

import lombok.Data;

@Data
public class FoodPackageDto {

	public String id;
	public String status;
	public String foods;
	public Customer customer;
	public String statusEntrega;
	public String createdDate;
	public String updateDate;

}
