package com.service.catering.infraestructure.repositories.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.service.catering.domain.model.DeliveryPersonEntity;

@Repository
public interface DeliveryPersonRepository extends JpaRepository<DeliveryPersonEntity, String> {

  @Query("SELECT u FROM DeliveryPerson u WHERE u.id = ?1")
  public DeliveryPersonEntity findByDeliveryPersonId(String deliverPersonId);
}
