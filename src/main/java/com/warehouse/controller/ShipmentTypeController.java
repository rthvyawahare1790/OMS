package com.warehouse.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.warehouse.model.ShipmentType;
import com.warehouse.service.IShipmentTypeService;

@Controller
@RequestMapping("/shipmenttype")
public class ShipmentTypeController {
	//display register page on enter /register on browser
	@Autowired
	private IShipmentTypeService service;
	
	
	@GetMapping("/register")
	public String showRegister(Model model)
	{
		//form backing objects
		model.addAttribute("shipmentType", new ShipmentType());
		return "ShipmentTypeRegister";
	}
	
	
	//on click on submit button read form data and save
	@PostMapping("/save")
	public String save(@ModelAttribute ShipmentType shipmentType,Model model)
	//read form data from UI(given by container)-MA              //to send data to UI-Model
	{
		//perform save operation
		Integer id = service.saveShipmentType(shipmentType);
		//construct one message
		String msg="Shipment Type Saved"+id+" THANK-YOU!";
		//send message to UI
		model.addAttribute("message2",msg);
		//form backing objects
		  model.addAttribute("shipmentType", new ShipmentType());
		//go to page
		return "shipmentTypeRegister";
	}
	
	
	//Display all records to UI
	@GetMapping("/all")
	public String showAll(Model model)
	{
		List<ShipmentType> list=service.getAllShipmentType();
		model.addAttribute("list",list);
		return "ShipmentTypeData";
	}
	
	
	//show edit page with data
	@GetMapping("/edit/{id}")
	public String showEdit(@PathVariable Integer id,Model model)
	{
		String page=null;
		Optional<ShipmentType> opt=service.getOneShipmentType(id);
		if (opt.isPresent()) {
			ShipmentType st=opt.get();
			model.addAttribute("shipmentType", st);
			page="ShipmentTypeEdit";
		}else {
		    page="redirect:../all";
		}
		       
		return page;
		
	}
	
	
	//update: on click update
	@PostMapping("/update")
	public String update(@ModelAttribute  ShipmentType shipmentType,Model model)
	{
		service.updateShipmentType(shipmentType);
		
		 String msg="ShipmentType"+shipmentType.getId()+"Updated!";
		 model.addAttribute("message1",msg);
			
		//form backing objects
	  model.addAttribute("shipmentType", new ShipmentType());
		
	     //new data from DB
		//show other rows
	  	List<ShipmentType> list=service.getAllShipmentType();
		model.addAttribute("list",list);
		
		return "ShipmentTypeData";
	}
	
	
	
	//delete:on click delete
	
	
	@GetMapping("/delete/{id}")
	public String deleteById(@PathVariable Integer id,Model model)
	{
		String page=null;
	
		if(service.isShipmentTypeExist(id))
		{
	     service.deleteShipmentType(id);
		
		 String msg="ShipmentTypeDeleted!"+id+"deleted";
		 model.addAttribute("message1",msg);
	
	  	List<ShipmentType> list=service.getAllShipmentType();
		model.addAttribute("list",list);
		page="ShipmentTypeData";
		}
		else {
			page= "../all";
			model.addAttribute("message1", id+"REcord not exit");
		}
		
		return page;
		}
	
	}
	
	
	
	
	
	

