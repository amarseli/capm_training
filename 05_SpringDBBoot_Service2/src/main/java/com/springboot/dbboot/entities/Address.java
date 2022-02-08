package com.springboot.dbboot.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ADDRESS")
public class Address {

//	@GeneratedValue(strategy=GenerationType.AUTO)
	
	@Id
	@Column(nullable=false, name="ID")	
	public String addressId;
	
	@Column(name="ADDR_TYPE")
	public String addressType;
	
	@Column(name="CITY")
	public String city;
	

	@Column(name="STREET")
	public String street;
	
	@Column(name="REGION")
	public String region;

	@Column(name="COUNTRY")
	public String country;
	
	@Column(name="POSTAL_CODE")
	public String postalCode;
	
	public Address() {
			
		}

	
	public Address(String addressId, String addressType, String city, String street, String region, String country,
			String postalCode) {
		super();
		this.addressId = addressId;
		this.addressType = addressType;
		this.city = city;
		this.street = street;
		this.region = region;
		this.country = country;
		this.postalCode = postalCode;
	}
	
	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	
	
	
	
	
}
