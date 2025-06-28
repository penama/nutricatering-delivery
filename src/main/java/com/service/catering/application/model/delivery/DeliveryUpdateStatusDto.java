package com.service.catering.application.model.delivery;

import lombok.Data;

@Data
public class DeliveryUpdateStatusDto {

	public String deliveryId;
	public String status;
	public String longitude;
	public String latitude;
	public String comentario;


}
