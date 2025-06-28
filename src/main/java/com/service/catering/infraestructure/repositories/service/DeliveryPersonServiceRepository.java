package com.service.catering.infraestructure.repositories.service;

import java.util.List;
import java.util.UUID;

import com.service.catering.domain.model.DeliveryPersonEntity;
import com.service.catering.infraestructure.event.querys.IQueryDeliveryPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.catering.infraestructure.repositories.interfaces.DeliveryPersonRepository;
import com.service.catering.infraestructure.utils.DateFormat;

@Service
public class DeliveryPersonServiceRepository implements IQueryDeliveryPersonRepository {

  @Autowired public DeliveryPersonRepository repository;

  public void newDeliveryPerson(DeliveryPersonEntity deliveryPersonEntity) throws Exception {
	  deliveryPersonEntity.id = UUID.randomUUID().toString();
	  deliveryPersonEntity.createdDate = DateFormat.toDate();
    repository.save(deliveryPersonEntity);
  }

	@Override
	public List<DeliveryPersonEntity> queryDeliveryPersons() {
		return repository.findAll();
	}

	@Override
	public DeliveryPersonEntity queryDeliveryPersonById(String deliveryPersonId) {
		return repository.findByDeliveryPersonId( deliveryPersonId );
	}
}
