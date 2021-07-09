package com.mutant.model;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity 
@Table(name = "statistics")
public class Statistics implements Serializable{


	@Id
	@NotNull
    @Size(min = 1, max = 255)	
	@Column(name = "property")
	private String property;
	
	@Column(name = "value")
	private int value;

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}


	



}