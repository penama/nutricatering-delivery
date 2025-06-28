package com.service.catering.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.service.catering.application.model.deliveryperson.DeliveryPersonDto;
import com.service.catering.application.model.error.ErrorDto;
import com.service.catering.application.service.DeliveryPersonService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/delivery")
public class DeliveryPersonController extends BaseController {

  @Autowired private DeliveryPersonService deliveryPersonService;

  @PostMapping("/person")
  public ResponseEntity newDeliveryPerson(@Valid @RequestBody DeliveryPersonDto deliveryPersonDto) {
    DeliveryPersonDto deliveryPersonDtoNew = null;
    try {
      deliveryPersonDtoNew = deliveryPersonService.newDeliveryPerson(deliveryPersonDto);
    } catch (Exception e) {
      ErrorDto errorDto = new ErrorDto(e.getMessage());
      log.error(this.getClass(), e.getMessage(), e);
      return ResponseEntity.internalServerError().body(errorDto);
    }
    return new ResponseEntity(deliveryPersonDtoNew, HttpStatus.OK);
  }

  @GetMapping("/persons")
  public ResponseEntity<List<DeliveryPersonDto>> getDeliveryPersons() {
    List<DeliveryPersonDto> deliveryPersonDtos = null;
    try {
      deliveryPersonDtos = deliveryPersonService.getDeliveryPersons();
    } catch (Exception e) {
      log.error(this.getClass(), e.getMessage(), e);
      return new ResponseEntity(new ErrorDto(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity<List<DeliveryPersonDto>>(deliveryPersonDtos, HttpStatus.OK);
  }

  @GetMapping("/person/deliveryId/{deliveryId}")
  public ResponseEntity<DeliveryPersonDto> getDeliveryPerson(@PathVariable String id) {
    DeliveryPersonDto deliveryPersonDto = null;
    try {
      deliveryPersonDto = deliveryPersonService.getDeliveryPersonById(id);
    } catch (Exception e) {
      log.error(this.getClass(), e.getMessage(), e);
      return new ResponseEntity(new ErrorDto(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity<DeliveryPersonDto>(deliveryPersonDto, HttpStatus.OK);
  }
}
