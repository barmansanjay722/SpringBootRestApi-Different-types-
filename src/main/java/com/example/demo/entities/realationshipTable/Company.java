package com.example.demo.entities.realationshipTable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Company {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int companyId;
	
	private String name;
	
	private String originCountry;
	
	

	public Company(int companyId, String name, String originCountry) {
		super();
		this.companyId = companyId;
		this.name = name;
		this.originCountry = originCountry;
	}
	
	

	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOriginCountry() {
		return originCountry;
	}

	public void setOriginCountry(String originCountry) {
		this.originCountry = originCountry;
	}
	
	
}
