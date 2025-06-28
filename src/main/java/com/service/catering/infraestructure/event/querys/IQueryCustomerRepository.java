package com.service.catering.infraestructure.event.querys;

import java.util.List;

import com.service.catering.domain.model.CustomerEntity;

public interface IQueryCustomerRepository {

  public List<CustomerEntity> queryCustomers() throws Exception;

  public CustomerEntity queryCustomer(String id) throws Exception;
}
