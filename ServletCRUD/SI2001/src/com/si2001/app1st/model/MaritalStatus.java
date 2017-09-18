package com.si2001.app1st.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "MARITALSTATUS")


public class MaritalStatus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="marital_status_id", nullable=false, unique=true)
	private Integer maritalId;
	
	
	@Column(name = "status", length = 45, nullable = false)
    private String status;
	
	 public MaritalStatus(String status) {
		 this.status = status;
	 }
	 
	 public MaritalStatus(){}
	 
	 public Integer getMaritalId() {
	        return maritalId;
	    }

	    public void setMaritalId(Integer maritalId) {
	        this.maritalId = maritalId;
	    }

	    public String getStatus() {
	        return status;
	    }

	    public void setStatus(String status) {
	        this.status = status;
	    }    
}
