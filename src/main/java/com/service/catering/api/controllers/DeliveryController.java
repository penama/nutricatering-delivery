package com.service.catering.api.controllers;

import java.util.List;

import com.service.catering.application.model.delivery.DeliveryDto;
import com.service.catering.application.model.delivery.DeliveryUpdateStatusDto;
import com.service.catering.application.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.service.catering.application.model.error.ErrorDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/delivery")
public class DeliveryController extends BaseController {

  @Autowired private DeliveryService deliveryService;

  @PostMapping("/delivery")
  public ResponseEntity newDelivery(@Valid @RequestBody DeliveryDto deliveryDto) {
	  DeliveryDto deliveryDtoNew = null;
    try {
		deliveryDtoNew = deliveryService.newDelivery(deliveryDto);
    } catch (Exception e) {
      log.error(this.getClass(), e.getMessage(), e);
      return new ResponseEntity(new ErrorDto(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity(deliveryDtoNew, HttpStatus.OK);
  }

	@PutMapping("/deliveryStatus")
	public ResponseEntity updateDeliveryStatus(@Valid @RequestBody DeliveryUpdateStatusDto deliveryUpdateStatusDto) {
		DeliveryUpdateStatusDto deliveryUpdateStatusDtoNew = null;
		try {
			deliveryService.updateDeliveryStatus(deliveryUpdateStatusDto);
		} catch (Exception e) {
			log.error(this.getClass(), e.getMessage(), e);
			return new ResponseEntity(new ErrorDto(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity(HttpStatus.OK);
	}

  @GetMapping("/deliverys")
  public ResponseEntity<List<DeliveryDto>> getDeliverys() {
    List<DeliveryDto> deliveryDtos = null;
    try {
		deliveryDtos = deliveryService.getDeliverys();
    } catch (Exception e) {
      log.error(this.getClass(), e.getMessage(), e);
      return new ResponseEntity(new ErrorDto(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity<List<DeliveryDto>>(deliveryDtos, HttpStatus.OK);
  }

  @GetMapping("/delivery/deliveryId/{deliveryId}")
  public ResponseEntity<DeliveryDto> getDeliveryId(@PathVariable String deliveryId) {
	  DeliveryDto deliveryDto = null;
    try {
		deliveryDto = deliveryService.getDelivery(deliveryId);
    } catch (Exception e) {
      log.error(this.getClass(), e.getMessage(), e);
      return new ResponseEntity(new ErrorDto(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity<DeliveryDto>(deliveryDto, HttpStatus.OK);
  }

  @GetMapping("/delivery/person/{personId}/deliverys")
  public ResponseEntity<List<DeliveryDto>> getDeliverysByPersonId( @PathVariable String personId) {
    List<DeliveryDto> deliveryDtos = null;
    try {
      deliveryDtos = deliveryService.getDeliveryByPersonId(personId);
    } catch (Exception e) {
      log.error(this.getClass(), e.getMessage(), e);
      return new ResponseEntity(new ErrorDto(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity<List<DeliveryDto>>(deliveryDtos, HttpStatus.OK);
  }
}
