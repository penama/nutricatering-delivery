package com.service.catering.application.service.events;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.service.catering.application.model.event.EventDto;
import com.service.catering.application.service.BaseService;
import com.service.catering.domain.model.*;
import com.service.catering.infraestructure.repositories.service.*;
import com.service.catering.infraestructure.utils.DateFormat;

@Service
public class ProducerEventDeliveryUpdateStatusFoodPackageService extends BaseService {

  public static final String EVENT_DELIVERY_UPDATE_STATUS = "DELIVERY_UPDATE_STATUS";
  EventDto eventDto = null;

  @Autowired ProducerServiceRepository producerServiceRepository;

  @Autowired private CustomerServiceRepository customerServiceRepository;
  @Autowired private CustomerAddressServiceRepository customerAddressServiceRepository;
  @Autowired private FoodPackageServiceRepository foodPackageServiceRepository;
  @Autowired private DeliveryPersonServiceRepository deliveryPersonServiceRepository;

  public void producerDeliveryUpdate(
      DeliveryEntity deliveryEntity, HistoryDeliveryEntity historyDeliveryEntity) {
    eventDto = new EventDto();
    eventDto.setEventType(EVENT_DELIVERY_UPDATE_STATUS);
    eventDto.setEventVersion("1.0");
    eventDto.setTimestamp(DateFormat.toDate());
    eventDto.setSource("delivery-service");

    FoodPackageEntity foodPackageEntity =
        foodPackageServiceRepository.queryFoodPackageById(deliveryEntity.getFoodPackageId());
    DeliveryPersonEntity deliveryPersonEntity =
        deliveryPersonServiceRepository.queryDeliveryPersonById(
            deliveryEntity.getDeliveryPersonId());

    Map<String, Object> body = new HashMap<>();
    body.put("deliveryId", deliveryEntity.getId());
    body.put("foodPackageId", deliveryEntity.getFoodPackageId());
    body.put("deliveryPersonId", deliveryEntity.getDeliveryPersonId());
    body.put("deliveryPersonName", deliveryPersonEntity.getName());
    body.put("deliveryPersonVehiculo", deliveryPersonEntity.getVehiculo());
    body.put("longitude", historyDeliveryEntity.getLongitude());
    body.put("latitude", historyDeliveryEntity.getLatitude());
    body.put("status", deliveryEntity.getStatus());

    eventDto.setBody(body);
    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(new JavaTimeModule());

    ProducerEntity producerEntity = new ProducerEntity();
    try {
      producerEntity.setBody(mapper.writeValueAsString(eventDto));
      producerEntity.setStatus("pendiente");
    } catch (JsonProcessingException e) {
      log.error(this.getClass(), e.getMessage(), e);
    }
    producerServiceRepository.newProducer(producerEntity);
    log.info(
        this.getClass(),
        "producerEvent "
            + EVENT_DELIVERY_UPDATE_STATUS
            + " registrado: "
            + producerEntity.getBody());
  }
}
