package com.warehouse.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name="shipment_type_tab")
public class ShipmentType {
	
	
	@Id
	@GeneratedValue(generator="shipment_type_seq_name")
	//@SequenceGenerator(name="shipment_type_seq_name",sequenceName="shipment_type_seq")
  //	@GenericGenerator(name="shipment_type_seq_name",strategy="com.warehouse.generator.ShipmentTypeGen")
	@Column(name="ship_id_col")
	private Integer id;
	
	@Column(name="ship_mode_col")
	private String shipmentMode;
	
	@Column(name="ship_code_col")
	private String shipmentCode;
	
	@Column(name="enab_ship_col")
	private String enableShipment;
	
	@Column(name="ship_grade_col")
	private String shipmentGrade;
	
	@Column(name="desc_col")
	private String description;
	

}
