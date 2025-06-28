package com.service.catering.infraestructure.repositories.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.service.catering.domain.model.FoodPackageEntity;

@Repository
public interface FoodPackageRepository extends JpaRepository<FoodPackageEntity, String> {

  @Query("SELECT u FROM FoodPackage u WHERE u.customerId = ?1")
  public List<FoodPackageEntity> findByCustomerId(String customerId);
}
