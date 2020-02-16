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
	private Date createdDate=new Date();
	
	
	public BaseEntity(ID id) {
		this.setId(id);
	}


	/**
	 * @return the id
	 */
	public ID getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(ID id) {
		this.id = id;
	}


	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}


	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

    
}
