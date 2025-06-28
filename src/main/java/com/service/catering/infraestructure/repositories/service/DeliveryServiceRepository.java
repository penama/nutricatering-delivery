package com.service.catering.infraestructure.repositories.service;

import java.util.List;
import java.util.UUID;

import com.service.catering.domain.model.DeliveryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.catering.infraestructure.event.querys.IQueryDeliveryRepository;
import com.service.catering.infraestructure.repositories.interfaces.DeliveryRepository;
import com.service.catering.infraestructure.utils.DateFormat;

@Service
public class DeliveryServiceRepository implements IQueryDeliveryRepository {

  @Autowired public DeliveryRepository repository;

  public void newDelivery(DeliveryEntity deliveryEntity) throws Exception {
	  deliveryEntity.id = UUID.randomUUID().toString();
	  deliveryEntity.createdDate = DateFormat.toDate();
    repository.save(deliveryEntity);
  }

  @Override
  public List<DeliveryEntity> queryDeliverys() {
    return repository.findAll();
  }

  @Override
  public List<DeliveryEntity> queryDeliverysByPersonId(String personId) {
    return repository.findByPersonId(personId);
  }

  @Override
  public DeliveryEntity queryDeliveryId(String deliveryId ) {
    return repository.findById(deliveryId).get();
  }

  public void updateDelivery(DeliveryEntity deliveryEntity) {
    repository.save(deliveryEntity);
  }
}
