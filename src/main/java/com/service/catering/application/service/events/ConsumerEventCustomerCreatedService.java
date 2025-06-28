package com.service.catering.application.service.events;

import com.service.catering.application.model.customer.CustomerStatus;
import com.service.catering.application.model.event.EventDto;
import com.service.catering.application.service.BaseService;
import com.service.catering.domain.model.CustomerEntity;
import com.service.catering.infraestructure.repositories.service.CustomerServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsumerEventCustomerCreatedService extends BaseService {

  public static final String ID = "id";
  public static final String USERNAME = "username";
  public static final String EMAIL = "email";
  public static final String FULLNAME = "fullName";
  public static final String CREATEDAT = "createdAt";

  @Autowired private CustomerServiceRepository customerServiceRepository;

  public void customerCreatedEvent(EventDto eventDto) throws Exception {
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setId(eventDto.getBody().get(ID).toString());
    customerEntity.setUserName(eventDto.getBody().get(USERNAME).toString());
    customerEntity.setEmail(eventDto.getBody().get(EMAIL).toString());
    customerEntity.setFullName(eventDto.getBody().get(FULLNAME).toString());
    customerEntity.setCreatedAt(eventDto.getBody().get(CREATEDAT).toString());

	  CustomerEntity customerEntityBd = customerServiceRepository.queryCustomer( customerEntity.getId() );
	  if ( customerEntityBd != null ){
		  log.error( this.getClass(), "Evento customerCreatedEvent, customerEntityId = " + customerEntity.getId() + ", ya existe en la base" );
		  return;
	  }
    customerEntity.setStatus(CustomerStatus.ACTIVE.name());
	customerServiceRepository.eventCustomerCreated( customerEntity );
	  log.info( this.getClass(), "Evento customerCreatedEvent, customerEntityId = " + customerEntity.getId() + ", registrado" );
  }
}
