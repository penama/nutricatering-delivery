package com.service.catering.application.model.delivery;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FoodPackage {
  @NotBlank(message = "FoodPackageId es mandatorio")
  public String id;
}
