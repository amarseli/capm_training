package com.springboot.dbboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.dbboot.entities.Address;
import com.springboot.dbboot.entities.Vendor;
import com.springboot.dbboot.service.AddressService;

@RestController
public class AddressController {

	@Autowired
	AddressService addressService;
	
	@RequestMapping("/addresses")
	public List<Address> getAddresses() {
		return 	addressService.getAddresses();
	}
	
	@PostMapping("/createAddresses")
	public Address createAddress(@RequestBody Address Payload) {
		return addressService.createAddress(Payload);
	}
}
