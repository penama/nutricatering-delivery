package com.service.catering.application.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.catering.application.model.deliveryperson.DeliveryPersonDto;
import com.service.catering.application.utils.DeliveryPersonUtil;
import com.service.catering.domain.model.DeliveryPersonEntity;
import com.service.catering.infraestructure.event.querys.IQueryDeliveryPersonRepository;
import com.service.catering.infraestructure.event.update.IUpdateDeliveryPersonRepository;

@Service
public class DeliveryPersonService extends BaseCommandHandler {

  @Autowired private IQueryDeliveryPersonRepository iQueryDeliveryPersonRepository;

  @Autowired private IUpdateDeliveryPersonRepository iUpdateDeliveryPersonRepository;

  public DeliveryPersonDto newDeliveryPerson(DeliveryPersonDto deliveryPersonDto) throws Exception {
    DeliveryPersonEntity deliveryPersonEntity =
        DeliveryPersonUtil.DeliberyPersonDtoToDeliveryPersonEntity(deliveryPersonDto);
    commandHandler(this, deliveryPersonEntity);
    DeliveryPersonDto deliveryPersonDtoNew =
        DeliveryPersonUtil.DeliveryPersonEntityToDeliberyPersonDto(deliveryPersonEntity);
    return deliveryPersonDtoNew;
  }

  public List<DeliveryPersonDto> getDeliveryPersons() throws Exception {
    List<DeliveryPersonEntity> deliveryPersonEntities =
        iQueryDeliveryPersonRepository.queryDeliveryPersons();
    List<DeliveryPersonDto> deliveryPersonDtos = new ArrayList<>();
    for (DeliveryPersonEntity deliveryPersonEntity : deliveryPersonEntities) {
      deliveryPersonDtos.add(
          DeliveryPersonUtil.DeliveryPersonEntityToDeliberyPersonDto(deliveryPersonEntity));
    }
    return deliveryPersonDtos;
  }

  public DeliveryPersonDto getDeliveryPersonById(String deliveryPersonId) throws Exception {
    DeliveryPersonEntity deliveryPersonEntity =
        iQueryDeliveryPersonRepository.queryDeliveryPersonById(deliveryPersonId);
    DeliveryPersonDto deliveryPersonDto =
        DeliveryPersonUtil.DeliveryPersonEntityToDeliberyPersonDto(deliveryPersonEntity);
    return deliveryPersonDto;
  }
}
