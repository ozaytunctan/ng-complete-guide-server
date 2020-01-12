package com.ozaytunctan.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity<ID> {
	
	@Id
	@GeneratedValue(generator="idGenerator",strategy=GenerationType.SEQUENCE)
	private ID id;
	
	@Column(name="cretedDate")
	private Date createdDate;
	
	
	public BaseEntity(ID id) {
		this.setId(id);
	}





	public ID getId() {
		return id;
	}





	public void setId(ID id) {
		this.id = id;
	}





	public Date getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	

}
