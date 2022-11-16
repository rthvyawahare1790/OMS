package com.warehouse.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.warehouse.model.ShipmentType;

public interface ShipmentTypeRepository extends JpaRepository<ShipmentType, Integer>
{

}
