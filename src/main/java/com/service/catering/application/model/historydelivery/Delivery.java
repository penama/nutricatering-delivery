package com.service.catering.application.model.historydelivery;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Delivery {
  @NotBlank(message = "Delivery es mandatorio")
  public String id;
}
