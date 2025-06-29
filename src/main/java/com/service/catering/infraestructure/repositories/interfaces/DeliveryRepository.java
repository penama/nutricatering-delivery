package com.service.catering.infraestructure.repositories.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.service.catering.domain.model.DeliveryEntity;

@Repository
public interface DeliveryRepository extends JpaRepository<DeliveryEntity, String> {

  @Query("SELECT u FROM Delivery u WHERE u.id = ?1")
  public List<DeliveryEntity> findByPersonId(String id);

	@Query("SELECT u FROM Delivery u WHERE u.foodPackageId = ?1")
	public DeliveryEntity findByFoodPackageId(String foodPackageId);
}
