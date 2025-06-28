package com.service.catering.infraestructure.repositories.interfaces;

import com.service.catering.domain.model.HistoryDeliveryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryDeliveryRepository extends JpaRepository<HistoryDeliveryEntity, String> {

  @Query("SELECT u FROM HistoryDelivery u WHERE u.deliveryId = ?1")
  public List<HistoryDeliveryEntity> findByDeliveryId(String deliveryId );
}
