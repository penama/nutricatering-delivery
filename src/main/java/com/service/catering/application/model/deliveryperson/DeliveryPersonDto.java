package com.service.catering.application.model.deliveryperson;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryPersonDto {

  public String id;

  @NotBlank(message = "Name es mandatorio")
  public String name;

  @NotBlank(message = "Vehículo es mandatorio")
  public String vehiculo;

  public String status;
  public String createdDate;
}
