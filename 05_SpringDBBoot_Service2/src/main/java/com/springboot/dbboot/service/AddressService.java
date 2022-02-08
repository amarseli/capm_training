package com.springboot.dbboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.dbboot.entities.Address; 

@Component
public class AddressService {

	@Autowired
	IAddressPersistance iAddress;
	
	
	public List<Address> getAddresses() {
		// TODO Auto-generated method stub
		return iAddress.findAll();
	}

	
	public  Address createAddress(Address payload) {
		// TODO Auto-generated method stub
		return iAddress.save(payload);
	}
	
	
}
