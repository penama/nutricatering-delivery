package com.service.catering.infraestructure.repositories.interfaces;

import java.util.List;

import com.service.catering.domain.model.DeliveryPersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryPersonRepository extends JpaRepository<DeliveryPersonEntity, String> {

  @Query("SELECT u FROM DeliveryPerson u WHERE u.deliveryId = ?1")
  public DeliveryPersonEntity findByDeliveryPersonId(String deliverPersonId);
}
