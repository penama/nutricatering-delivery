package com.service.catering.application.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.service.catering.application.model.delivery.DeliveryDto;
import com.service.catering.application.model.delivery.DeliveryUpdateStatusDto;
import com.service.catering.domain.model.DeliveryEntity;
import com.service.catering.domain.model.HistoryDeliveryEntity;
import com.service.catering.domain.model.common.HistoryDeliveryStatus;
import com.service.catering.infraestructure.repositories.service.DeliveryServiceRepository;
import com.service.catering.infraestructure.repositories.service.HistoryDeliveryServiceRepository;
import com.service.catering.infraestructure.utils.DateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.catering.application.model.deliveryperson.DeliveryPersonStatus;
import com.service.catering.application.utils.DeliveryUtil;
import com.service.catering.infraestructure.event.querys.IQueryDeliveryRepository;

@Service
public class DeliveryService extends BaseCommandHandler {

//  @Autowired private IQueryDeliveryRepository iQueryDeliveryRepository;
  @Autowired private DeliveryServiceRepository deliveryServiceRepository;
  @Autowired private HistoryDeliveryServiceRepository historyDeliveryServiceRepository;

  public DeliveryDto newDelivery(DeliveryDto deliveryDto) throws Exception {
	 DeliveryEntity deliveryEntity = DeliveryUtil.deliveryDtoToDeliveryEntity(deliveryDto);
	  deliveryEntity.setStatus(DeliveryPersonStatus.ACTIVE.name());
    commandHandler(this, deliveryEntity);

	  HistoryDeliveryEntity historyDeliveryEntity = new HistoryDeliveryEntity();
	  historyDeliveryEntity.setDeliveryId(  deliveryEntity.getId() );
	  historyDeliveryEntity.setStatus( deliveryEntity.getStatus() );
	  historyDeliveryEntity.setComentario( deliveryEntity.getComentary() );
	  historyDeliveryEntity.setLatitude( "0" );
	  historyDeliveryEntity.setLongitude( "0" );
	  historyDeliveryServiceRepository.newHistoryDelivery( historyDeliveryEntity );

    return DeliveryUtil.deliveryEntityToDeliveryDto(deliveryEntity);
  }

  public void updateDeliveryStatus(DeliveryUpdateStatusDto deliveryUpdateStatusDto ) throws  Exception {
	  DeliveryEntity deliveryEntity = deliveryServiceRepository.queryDeliveryId( deliveryUpdateStatusDto.getDeliveryId() );
	  if ( deliveryEntity == null ){
		  throw new Exception( "Delivery no existe" );
	  }
	  //if (Arrays.stream(HistoryDeliveryStatus.values()). )
	  deliveryEntity.setStatus( deliveryUpdateStatusDto.getStatus() );
	  deliveryEntity.setUpdateDate(DateFormat.toDate());
	  deliveryServiceRepository.updateDelivery( deliveryEntity );

	  HistoryDeliveryEntity historyDeliveryEntity = new HistoryDeliveryEntity();
	  historyDeliveryEntity.setDeliveryId( deliveryEntity.getId() );
	  historyDeliveryEntity.setStatus( deliveryUpdateStatusDto.getStatus() );
	  historyDeliveryEntity.setComentario(deliveryUpdateStatusDto.getComentario() );
	  historyDeliveryEntity.setLatitude(deliveryUpdateStatusDto.getLatitude() );
	  historyDeliveryEntity.setLongitude(deliveryUpdateStatusDto.getLongitude() );

	  historyDeliveryServiceRepository.newHistoryDelivery( historyDeliveryEntity );
  }

  public List<DeliveryDto> getDeliverys() throws Exception {
    List<DeliveryEntity> deliveryEntities = deliveryServiceRepository.queryDeliverys();
    List<DeliveryDto> deliveryDtos = new ArrayList<>();
    for (DeliveryEntity deliveryEntity : deliveryEntities) {
		deliveryDtos.add(DeliveryUtil.deliveryEntityToDeliveryDto(deliveryEntity));
    }
    return deliveryDtos;
  }

  public List<DeliveryDto> getDeliveryByPersonId(String personId) throws Exception {
    List<DeliveryEntity> deliveryEntities = deliveryServiceRepository.queryDeliverysByPersonId(personId);
    List<DeliveryDto> deliveryDtos = new ArrayList<>();
    for (DeliveryEntity deliveryEntity : deliveryEntities) {
		deliveryDtos.add(DeliveryUtil.deliveryEntityToDeliveryDto(deliveryEntity));
    }
    return deliveryDtos;
  }

  public DeliveryDto getDelivery(String deliveryId) throws Exception {
    DeliveryEntity deliveryEntity = deliveryServiceRepository.queryDeliveryId( deliveryId );
    if (deliveryEntity == null) {
      throw new Exception(deliveryEntity + " Delivery Not Found..");
    }
    return DeliveryUtil.deliveryEntityToDeliveryDto(deliveryEntity);
  }

}
