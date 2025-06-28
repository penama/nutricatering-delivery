package com.service.catering.infraestructure.repositories.service;

import com.service.catering.domain.model.DeliveryEntity;
import com.service.catering.domain.model.HistoryDeliveryEntity;
import com.service.catering.infraestructure.event.querys.IQueryDeliveryRepository;
import com.service.catering.infraestructure.repositories.interfaces.DeliveryRepository;
import com.service.catering.infraestructure.repositories.interfaces.HistoryDeliveryRepository;
import com.service.catering.infraestructure.utils.DateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HistoryDeliveryServiceRepository {

  @Autowired public HistoryDeliveryRepository repository;

  public void newHistoryDelivery(HistoryDeliveryEntity historyDeliveryEntity) throws Exception {
	  historyDeliveryEntity.id = UUID.randomUUID().toString();
	  historyDeliveryEntity.createdDate = DateFormat.toDate();
    repository.save(historyDeliveryEntity);
  }

  public List<HistoryDeliveryEntity> getHistoryDeliveryByDeliveryId( String deliveryId ) throws  Exception {
	  return repository.findByDeliveryId( deliveryId );
  }

}
