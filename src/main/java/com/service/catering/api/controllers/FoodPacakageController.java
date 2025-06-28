package com.service.catering.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.service.catering.application.model.error.ErrorDto;
import com.service.catering.application.model.foodpackage.FoodPackageDto;
import com.service.catering.application.service.FoodPackageService;

@RestController
@RequestMapping("/api/v1/delivery")
public class FoodPacakageController extends BaseController {

  @Autowired private FoodPackageService foodPackageService;

  @PostMapping("/foodPackage")
  public ResponseEntity newFoodPackage(@RequestBody FoodPackageDto paymentDto) {
    FoodPackageDto foodPackageDto = null;
    try {
      foodPackageDto = foodPackageService.newFoodPackage(foodPackageDto);
    } catch (Exception e) {
      log.error(this.getClass(), e.getMessage(), e);
      return new ResponseEntity(new ErrorDto(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity(foodPackageDto, HttpStatus.OK);
  }

  @GetMapping("/foodPackages")
  public ResponseEntity<List<FoodPackageDto>> getFoodPackages() {
    List<FoodPackageDto> foodPackageDtos = null;
    try {
      foodPackageDtos = foodPackageService.getFoodPackages();
    } catch (Exception e) {
      log.error(this.getClass(), e.getMessage(), e);
      return new ResponseEntity(new ErrorDto(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity<List<FoodPackageDto>>(foodPackageDtos, HttpStatus.OK);
  }

  @GetMapping("/foodPackage/deliveryId/{deliveryId}")
  public ResponseEntity<FoodPackageDto> getFoodPackageById(@PathVariable String id) {
    FoodPackageDto foodPackageDto = null;
    try {
      foodPackageDto = foodPackageService.getFoodPackageById(id);
    } catch (Exception e) {
      log.error(this.getClass(), e.getMessage(), e);
      return new ResponseEntity(new ErrorDto(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity<FoodPackageDto>(foodPackageDto, HttpStatus.OK);
  }
}
