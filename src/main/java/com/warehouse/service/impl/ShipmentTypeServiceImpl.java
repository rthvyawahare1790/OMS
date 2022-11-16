package com.warehouse.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.warehouse.model.ShipmentType;
import com.warehouse.repo.ShipmentTypeRepository;
import com.warehouse.service.IShipmentTypeService;


@Service
public class ShipmentTypeServiceImpl implements IShipmentTypeService{

	@Autowired
	private ShipmentTypeRepository repo;  //HAS-A 
	
	@Transactional
	public Integer saveShipmentType(ShipmentType st) {
				return repo.save(st).getId();
	}

	@Transactional
	public void updateShipmentType(ShipmentType st) {
		repo.save(st);
		
	}

	@Transactional
	public void deleteShipmentType(Integer id) {
		repo.deleteById(id);
		
	}

	@Transactional(readOnly = true)
	public Optional<ShipmentType> getOneShipmentType(Integer id) {
		Optional<ShipmentType> opt=repo.findById(id);
		/*
		 * if(opt.isPresent()) //to avoid NPE { return opt.get(); }
		 */
		return opt;
	}

	@Transactional(readOnly = true)
	public List<ShipmentType> getAllShipmentType() {
		List<ShipmentType>list=repo.findAll();
		return list;
	}

	@Transactional(readOnly = true)
	public boolean isShipmentTypeExist(Integer id) {
		boolean flag=repo.existsById(id);
		return flag;
	}
	

}
