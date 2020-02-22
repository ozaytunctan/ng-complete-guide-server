package com.ozaytunctan.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity<ID> {
	
	@Id
	@GeneratedValue(generator="idGenerator",strategy=GenerationType.SEQUENCE)
	private ID id;
	
	@Column(name="cretedDate")
	private Date createdDate=new Date();
	

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(columnDefinition = "user_id", referencedColumnName = "id")
    private User user;
	
	
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


	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}


	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

    
}
