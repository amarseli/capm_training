package com.springboot.dbboot.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

//@ComponentScan({"com.amarseli.restservice.controller", "com.amarseli.restservice.entities", "com.springboot.restservice.demo"})


@Entity
@Table(name="VENDOR")
public class Vendor {
	
	//to generate guid 
	//@GeneratedValue(generator="uuid2")
	//@GenericGenerator(name="uuid2", strategy="org.hibernate.id.UUIDGenerator")
	
//	@Id
//	@Column(nullable=false, name="VENDOR_ID")
//	@GeneratedValue(strategy=GenerationType.SEQUENCE)	
//	public String vendorId;
	
	@Id
	@Column(nullable=false, name="VENDOR_ID",insertable = true)
	public String vendorId;

	@Column(nullable=false, name="COMP_NAME")
	public String companyName;
	
	@Column(nullable=false, name="FIRST_NAME")
	public String firstName;
	
	@Column(nullable=false, name="LAST_NAME")
	public String lastName;
	
	@Column(nullable=false, name="EMAIL")
	public String email;

	@Column(nullable=false, name="STATUS")
	public String status;

	@Column(nullable=false, name="WEBSITE")
	public String website;

	@Column(nullable=false, name="GST_NO")
	public String gstNo;

	
	public Vendor() {
		
	}
	
	public Vendor(String vendorId, String companyName, String firstName, String lastName, String email, String status,
			String website, String gstNo) {
		super();
		this.vendorId = vendorId;
		this.companyName = companyName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.status = status;
		this.website = website;
		this.gstNo = gstNo;
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getGstNo() {
		return gstNo;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}
	
	 
	
}
