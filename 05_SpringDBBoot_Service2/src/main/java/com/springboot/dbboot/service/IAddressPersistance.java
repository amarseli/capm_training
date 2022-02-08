package com.springboot.dbboot.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.dbboot.entities.Address;

@Repository
public interface IAddressPersistance extends JpaRepository<Address, String>{
	
	AddressService as = new AddressService();

}
