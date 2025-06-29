package com.service.catering.application.model.delivery;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoryDelivery {
	public String id;
	public String deliveryId;
	public String status;
	public String longitude;
	public String latitude;
	public String comentario;
	public String createdDate;
}
