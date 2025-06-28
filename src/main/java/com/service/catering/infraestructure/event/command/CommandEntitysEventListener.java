package com.service.catering.infraestructure.event.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.service.catering.domain.model.*;
import com.service.catering.infraestructure.repositories.service.*;

@Component
public class CommandEntitysEventListener implements ApplicationListener<CommandEntitysEvent> {

  @Autowired private DeliveryServiceRepository deliveryServiceRepository;
  @Autowired private DeliveryPersonServiceRepository deliveryPersonServiceRepository;
  @Autowired private CustomerServiceRepository customerServiceRepository;
  @Autowired private DeliveryServiceRepository contractServiceRepository;
  @Autowired private FoodPackageServiceRepository foodPackageServiceRepository;

  @Override
  public void onApplicationEvent(CommandEntitysEvent event) {
    if (event.getData() instanceof DeliveryEntity) {
      try {
        deliveryServiceRepository.newDelivery((DeliveryEntity) event.getData());
      } catch (Exception e) {
        e.printStackTrace();
        throw new RuntimeException(e);
      }
    }
    if (event.getData() instanceof DeliveryPersonEntity) {
      try {
        deliveryPersonServiceRepository.newDeliveryPerson((DeliveryPersonEntity) event.getData());
      } catch (Exception e) {
        e.printStackTrace();
        throw new RuntimeException(e);
      }
    }
    if (event.getData() instanceof CustomerEntity) {
      try {
        customerServiceRepository.newCustomer((CustomerEntity) event.getData());
      } catch (Exception e) {
        e.printStackTrace();
        throw new RuntimeException(e);
      }
    }
    if (event.getData() instanceof FoodPackageEntity) {
      try {
        foodPackageServiceRepository.newFoodPackage((FoodPackageEntity) event.getData());
      } catch (Exception e) {
        e.printStackTrace();
        throw new RuntimeException(e);
      }
    }
  }

  @Override
  public boolean supportsAsyncExecution() {
    return ApplicationListener.super.supportsAsyncExecution();
  }
}
