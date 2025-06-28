package com.service.catering.application.service.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.catering.application.model.event.EventDto;
import com.service.catering.application.service.BaseService;
import com.service.catering.domain.model.FoodPackageEntity;
import com.service.catering.domain.model.common.FoodPackageStatusDelivery;
import com.service.catering.infraestructure.repositories.service.FoodPackageServiceRepository;

@Service
public class ConsumerEventFoodPackageService extends BaseService {

  public static final String ID = "id";
  public static final String STATUS = "status";
  public static final String USERID = "userId";
  public static final String ADDRESSID = "addressId";
  public static final String FOODS = "foods";

  @Autowired private FoodPackageServiceRepository foodPackageServiceRepository;

  public void foodPackageNewEvent(EventDto eventDto) throws Exception {
    FoodPackageEntity foodPackageEntity = eventDtoToFoodPackageEntity(eventDto);
    FoodPackageEntity foodPackageEntityBd =
        foodPackageServiceRepository.queryFoodPackageById(foodPackageEntity.getId());
    if (foodPackageEntityBd != null) {
      log.error(
          this.getClass(),
          "Evento foodPackageCookingEvent, FoodPackageId = "
              + foodPackageEntity.getId()
              + ", ya existe en la base");
      return;
    }
    foodPackageEntity.setStatusDelivery(FoodPackageStatusDelivery.PENDIENTE.name());
    foodPackageServiceRepository.newFoodPackage(foodPackageEntity);
    log.info(
        this.getClass(),
        "Evento foodPackageNewEvent, FoodPackageId = "
            + foodPackageEntity.getId()
            + ", registrado");
  }

  public void foodPackageCookingEvent(EventDto eventDto) throws Exception {
    FoodPackageEntity foodPackageEntity = eventDtoToFoodPackageEntity(eventDto);
    FoodPackageEntity foodPackageEntityBd =
        foodPackageServiceRepository.queryFoodPackageById(foodPackageEntity.getId());
    if (foodPackageEntityBd == null) {
      log.error(
          this.getClass(),
          "Evento foodPackageCookingEvent, FoodPackageId = "
              + foodPackageEntity.getId()
              + ", no existe en la base");
      return;
    }
    foodPackageEntity.setStatusDelivery(foodPackageEntityBd.getStatusDelivery());
    foodPackageServiceRepository.newFoodPackage(foodPackageEntity);
    log.info(
        this.getClass(),
        "Evento foodPackageNewEvent, FoodPackageId = "
            + foodPackageEntity.getId()
            + ", actualizado");
  }

  public void foodPackageCookedEvent(EventDto eventDto) throws Exception {
    FoodPackageEntity foodPackageEntity = eventDtoToFoodPackageEntity(eventDto);
    FoodPackageEntity foodPackageEntityBd =
        foodPackageServiceRepository.queryFoodPackageById(foodPackageEntity.getId());
    if (foodPackageEntityBd == null) {
      log.error(
          this.getClass(),
          "Evento foodPackageCookedEvent, FoodPackageId = "
              + foodPackageEntity.getId()
              + ", no existe en la base");
      return;
    }
    foodPackageEntity.setStatusDelivery(foodPackageEntityBd.getStatusDelivery());
    foodPackageServiceRepository.newFoodPackage(foodPackageEntity);
    log.info(
        this.getClass(),
        "Evento foodPackageCookedEvent, FoodPackageId = "
            + foodPackageEntity.getId()
            + ", actualizado");
  }

  public void foodPackagePackedEvent(EventDto eventDto) throws Exception {
    FoodPackageEntity foodPackageEntity = eventDtoToFoodPackageEntity(eventDto);
    FoodPackageEntity foodPackageEntityBd =
        foodPackageServiceRepository.queryFoodPackageById(foodPackageEntity.getId());
    if (foodPackageEntityBd == null) {
      log.error(
          this.getClass(),
          "Evento foodPackagePackedEvent, FoodPackageId = "
              + foodPackageEntity.getId()
              + ", no existe en la base");
      return;
    }
    foodPackageEntity.setStatusDelivery(foodPackageEntityBd.getStatusDelivery());
    foodPackageServiceRepository.newFoodPackage(foodPackageEntity);
    log.info(
        this.getClass(),
        "Evento foodPackagePackedEvent, FoodPackageId = "
            + foodPackageEntity.getId()
            + ", actualizado");
  }

  public void foodPackageDispatchedEvent(EventDto eventDto) throws Exception {
    FoodPackageEntity foodPackageEntity = eventDtoToFoodPackageEntity(eventDto);
    FoodPackageEntity foodPackageEntityBd =
        foodPackageServiceRepository.queryFoodPackageById(foodPackageEntity.getId());
    if (foodPackageEntityBd == null) {
      log.error(
          this.getClass(),
          "Evento foodPackageDispatchedEvent, FoodPackageId = "
              + foodPackageEntity.getId()
              + ", no existe en la base");
      return;
    }
    foodPackageEntity.setStatusDelivery(foodPackageEntityBd.getStatusDelivery());
    foodPackageServiceRepository.newFoodPackage(foodPackageEntity);
    log.info(
        this.getClass(),
        "Evento foodPackageDispatchedEvent, FoodPackageId = "
            + foodPackageEntity.getId()
            + ", actualizado");
  }

  private boolean existFoodPackageId(String id) throws Exception {
    FoodPackageEntity foodPackageEntity = foodPackageServiceRepository.queryFoodPackageById(id);
    return foodPackageEntity != null;
  }

  private FoodPackageEntity eventDtoToFoodPackageEntity(EventDto eventDto) throws Exception {
    FoodPackageEntity foodPackageEntity = new FoodPackageEntity();
    foodPackageEntity.setId(eventDto.getBody().get(ID).toString());
    foodPackageEntity.setStatus(eventDto.getBody().get(STATUS).toString());
    foodPackageEntity.setCustomerId(eventDto.getBody().get(USERID).toString());
    foodPackageEntity.setCustomerAddressId(eventDto.getBody().get(ADDRESSID).toString());
    foodPackageEntity.setFoods(eventDto.getBody().get(FOODS).toString());
    return foodPackageEntity;
  }
}
