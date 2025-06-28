package com.service.catering.infraestructure.repositories.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.service.catering.domain.model.HistoryDeliveryEntity;

@Repository
public interface HistoryDeliveryRepository extends JpaRepository<HistoryDeliveryEntity, String> {

  @Query("SELECT u FROM HistoryDelivery u WHERE u.deliveryId = ?1")
  public List<HistoryDeliveryEntity> findByDeliveryId(String deliveryId);
}
