package com.service.catering.application.service.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.catering.application.model.event.EventDto;
import com.service.catering.application.service.BaseService;
import com.service.catering.domain.model.CustomerAddressEntity;
import com.service.catering.infraestructure.event.update.ICreatedCustomerAddressRepository;
import com.service.catering.infraestructure.repositories.service.CustomerAddressServiceRepository;

@Service
public class ConsumerEventDeliveryDateUpdateService extends BaseService {

  public static final String ADDRESS_GUID = "addressGuid";
  public static final String CUSTOMER_ID = "clientGuid";
  public static final String NEW_DATE = "newDate";
  public static final String PREVIUS_DATE = "previousDate";

  @Autowired private ICreatedCustomerAddressRepository iCreatedCustomerAddressRepository;
  @Autowired private CustomerAddressServiceRepository customerAddressServiceRepository;

  public void deliveryDateUpdateUpdateEvent(EventDto eventDto) {
    CustomerAddressEntity customerAddressEntity =
        customerAddressServiceRepository.queryCustomerAddressByCustomer(
            eventDto.getBody().get(CUSTOMER_ID).toString());
    customerAddressEntity.setId(eventDto.getBody().get(ADDRESS_GUID).toString());
    customerAddressEntity.setDeliveryDate(eventDto.getBody().get(NEW_DATE).toString());
    log.info(
        this.getClass(),
        "Actualizando datos, previusDate: "
            + eventDto.getBody().get(PREVIUS_DATE)
            + ", newDate: "
            + customerAddressEntity.getDeliveryDate());
    iCreatedCustomerAddressRepository.eventCustomerDeliveryUpdate(customerAddressEntity);
    log.info(
        this.getClass(),
        "Evento customerCreatedEvent, customerAddressId = "
            + customerAddressEntity.getId()
            + ", actualizado");
  }
}
