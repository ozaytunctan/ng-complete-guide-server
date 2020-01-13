package com.ozaytunctan.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.ozaytunctan.helper.enums.ConversionType;
/**
 * 	Yemek Malzeme 
 * @author ubuntudev
 *
 */
@Entity
@Table
@SequenceGenerator(sequenceName ="sq_ingredient",initialValue = 1,allocationSize = 1,name = "idGenerator")
public class Igredient extends BaseEntity<Long>{
	
	
	private String name;
	
	private Double amount;
	
	private Integer value;
	
	@Enumerated(EnumType.ORDINAL)
	private ConversionType conversionType;
	


	public Igredient() {
		super(0L);
	}
	
	public Igredient(Long id) {
		super(id);
	}

	
	
	

}
