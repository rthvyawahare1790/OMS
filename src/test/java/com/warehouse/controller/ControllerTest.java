package com.warehouse.controller;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.ui.Model;

import com.warehouse.model.ShipmentType;
import com.warehouse.repo.ShipmentTypeRepository;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class ControllerTest {

	 @InjectMocks
	   private ShipmentTypeController controller;
	 
	 @Mock
	    private Model model;
	 
	  @Mock
	   private ShipmentTypeRepository repository;
	
	@Test
	public void shouldSaveAccountToDb() {
		ShipmentType shipmentType = new ShipmentType();
		shipmentType.setId(121);
		doReturn("Saved").when(repository).save(shipmentType);
         doThrow(newRuntimeException()).when(mock).someMethod();
		String save = controller.save(shipmentType,model);
		
	      Assert.assertEquals("Saved", save);
	}
}
