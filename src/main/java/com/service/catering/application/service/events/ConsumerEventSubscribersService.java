package com.service.catering.application.service.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.service.catering.application.model.event.EventDto;
import com.service.catering.application.service.BaseService;

@Service
public class ConsumerEventSubscribersService extends BaseService {

  public static final String EVENT_FOOD_PACKAGE_NEW = "FOOD_PACKAGE_NEW";
  public static final String EVENT_FOOD_PACKAGE_COOKING = "FOOD_PACKAGE_COOKING";
  public static final String EVENT_FOOD_PACKAGE_COOKED = "FOOD_PACKAGE_COOKED";
  public static final String EVENT_FOOD_PACKAGE_PACKED = "FOOD_PACKAGE_PACKED";
  public static final String EVENT_FOOD_PACKAGE_DISPATCHED = "FOOD_PACKAGE_DISPATCHED";

  public static final String EVENT_USER_CREATED = "USER_CREATED";
  public static final String EVENT_USER_ADRESS_UPDATED = "USER_ADDRESS_UPDATE";
  public static final String EVENT_DELIVERY_DATE_UPDATED = "DELIVERY_DATE_UPDATE";

  @Autowired private ConsumerEventCustomerCreatedService consumerEventCustomerCreatedService;
  @Autowired private ConsumerEventFoodPackageService foodPackageEventService;

  @Autowired
  private ConsumerEventCustomerAddressUpdateService consumerEventCustomerAddressUpdateService;

  @Autowired private ConsumerEventDeliveryDateUpdateService consumerEventDeliveryDateUpdateService;

  public void procesarMensaje(String mensaje) throws Exception {

    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(new JavaTimeModule());
    EventDto eventDto = null;
    try {
      eventDto = mapper.readValue(mensaje, EventDto.class);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }

    if (eventDto.getEventType().equalsIgnoreCase(EVENT_USER_CREATED))
      consumerEventCustomerCreatedService.customerCreatedEvent(eventDto);
    else if (eventDto.getEventType().equalsIgnoreCase(EVENT_USER_ADRESS_UPDATED))
      consumerEventCustomerAddressUpdateService.customerAddressUpdatedEvent(eventDto);
    else if (eventDto.getEventType().equalsIgnoreCase(EVENT_DELIVERY_DATE_UPDATED))
      consumerEventDeliveryDateUpdateService.deliveryDateUpdateUpdateEvent(eventDto);
    else if (eventDto.getEventType().equalsIgnoreCase(EVENT_FOOD_PACKAGE_NEW))
      foodPackageEventService.foodPackageNewEvent(eventDto);
    else if (eventDto.getEventType().equalsIgnoreCase(EVENT_FOOD_PACKAGE_COOKING))
      foodPackageEventService.foodPackageCookingEvent(eventDto);
    else if (eventDto.getEventType().equalsIgnoreCase(EVENT_FOOD_PACKAGE_COOKED))
      foodPackageEventService.foodPackageCookedEvent(eventDto);
    else if (eventDto.getEventType().equalsIgnoreCase(EVENT_FOOD_PACKAGE_PACKED))
      foodPackageEventService.foodPackagePackedEvent(eventDto);
    else if (eventDto.getEventType().equalsIgnoreCase(EVENT_FOOD_PACKAGE_DISPATCHED))
      foodPackageEventService.foodPackageDispatchedEvent(eventDto);
    else {
      log.warn(this.getClass(), "Evento " + eventDto.getEventType() + " no mapeado:  " + mensaje);
    }
  }
}
