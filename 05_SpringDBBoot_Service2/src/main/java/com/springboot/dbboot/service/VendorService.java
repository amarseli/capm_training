package com.springboot.dbboot.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springboot.dbboot.entities.Vendor;

@Component
public class VendorService {

	@Autowired
	IVendorPersistance iVendor;
	
	public String getGSTFilter() {
		return "%?1%";
	}
	
	public List<Vendor> readAllVendors() {
		
		return iVendor.findAll();
		
	}
	 
	public Vendor createNewVendor(Vendor vendorObj) {
				
		return iVendor.save(vendorObj);
		
	}
	
	public List<Vendor> searchByCompanyName(String companyName) {
		return iVendor.findByCompanyName(companyName);
	}
	
	
	
	public List<Vendor> lookupVendorByGST(String GSTNo){
		return iVendor.lookupVendorByGST(GSTNo);
	} 
	
	public List<Vendor> lookupVendorByGSTPathVariable(String GSTNo){
		return iVendor.lookupVendorByGST(GSTNo);
	} 
	
	public List<Vendor> lookupVendorByGSTAndCompanyName(String GSTNo, String CompanyName, String GSTFilter) {
		return iVendor.lookupVendorByGSTAndCompanyName(GSTNo, CompanyName, GSTFilter);
	}

	public Optional<Vendor> findbyVendorId(String vendorId ) {
		
		return iVendor.findbyVendorId(vendorId);
	}
	
	
	public Vendor changeVendor	(Vendor payload) {
		Optional<Vendor> myVendor = iVendor.findById(payload.vendorId);
//		if(!myVendor.isPresent()) 
//		{
//			return new Vendor("000","","","","","NA","vendor not found",""); 
//		}
//		else
//		{
//			return iVendor.save(payload);
//		}
		return iVendor.save(payload);
	}
	
	public String deleteVendor(String vendorId) {
		
		String delmsg = "{ \"resp_msg\" : \"Vendor ID\""+vendorId+" has been deleted from the Vendor Table\"}";
//		System.out.println("DD VendorID :: "+vendorId);
		Optional<Vendor> myVendor = iVendor.findById(vendorId);
		 
		if(!myVendor.isPresent()) 
		{
			return "{ \"resp_msg\" : \"Vendor ID "+vendorId+" has not been found in the Vendor Table\"}";
		}
		else
		{
			iVendor.deleteById(vendorId);
			return delmsg;
		}
		
		
	}
	
}
