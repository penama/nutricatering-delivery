package com.service.catering.infraestructure.repositories.interfaces;

import java.util.List;

import com.service.catering.domain.model.DeliveryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends JpaRepository<DeliveryEntity, String> {

  @Query("SELECT u FROM Delivery u WHERE u.deliveryPersonId = ?1")
  public List<DeliveryEntity> findByPersonId(String personId );
}
