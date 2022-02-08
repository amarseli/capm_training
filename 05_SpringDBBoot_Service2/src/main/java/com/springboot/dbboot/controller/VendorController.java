package com.springboot.dbboot.controller;

import java.util.Date;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.dbboot.entities.Vendor;
import com.springboot.dbboot.service.VendorService;

@RestController
public class VendorController {
	
	@Autowired
	VendorService vendorService ;

	
	@RequestMapping("/vendor")
	public List<Vendor> getVendors() {
		
		return vendorService.readAllVendors();
	}
	
	//GET Operations getVendorbyid
	@RequestMapping("/vendor/{venderCode}")
	public Vendor getVendorById(@PathVariable("venderCode") String vendorId) {
		System.out.println("Vendor ID is "+vendorId);
		Optional<Vendor> searchResult = vendorService.findbyVendorId(vendorId);  
		if(!searchResult.isPresent()) 
		{
			return new Vendor("000","","","","","NA","vendor not found","");
		}
		return searchResult.get(); 
	}
	 
	
	@RequestMapping("/vendor/searchByCompanyName")
	public List<Vendor> searchByCompanyName(@RequestParam String company) {
		  
		return vendorService.searchByCompanyName(company);
		
	}
	
	@RequestMapping("/vendor/lookupGST")
	public List<Vendor> searchVendorByGST(@RequestParam String GSTNo){
		return vendorService.lookupVendorByGST(GSTNo);
	}
	
	@RequestMapping("/vendor/lookupGSTAndCompanyName")
	public List<Vendor> searchVendorByGST(@RequestParam String GSTNo, @RequestParam String CompanyName, String GSTFilter){
		return vendorService.lookupVendorByGSTAndCompanyName(GSTNo, CompanyName, GSTFilter);
	}
	
	@RequestMapping("/vendor/lookupGSTPathVar/{gstNo}")
	public List<Vendor> searchVendorByGSTPathVariable(@PathVariable("gstNo") String GSTNo){
		return vendorService.lookupVendorByGSTPathVariable(GSTNo);
	}
	
	@PostMapping("/vendor")
	public Vendor createVendor(@RequestBody Vendor myPostBody) {
		return vendorService.createNewVendor(myPostBody);
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "/upsertVendor") 
	public Vendor updateVendor(@RequestBody Vendor vendor) {
		
		return vendorService.changeVendor(vendor);
	}
	
	
	@RequestMapping(method=RequestMethod.DELETE, value = "/deleteVendor/{vendorId}") 
	public String deleteVendor(@PathVariable("vendorId") String VendID) {
//		System.out.println("VendorID :: "+VendID);
		return vendorService.deleteVendor(VendID);
	}
	
}
