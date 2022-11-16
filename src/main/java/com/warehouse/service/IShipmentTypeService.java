package com.warehouse.service;

import java.util.List;
import java.util.Optional;

import com.warehouse.model.ShipmentType;

public interface IShipmentTypeService {
	
	
	Integer saveShipmentType(ShipmentType st);
	
	void updateShipmentType(ShipmentType st);

	void deleteShipmentType(Integer id);
	
	Optional<ShipmentType> getOneShipmentType(Integer id);
	
	
	List<ShipmentType> getAllShipmentType();

	
	boolean isShipmentTypeExist(Integer id);
	
}
