package com.springboot.dbboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.springboot.dbboot.service.VendorService;
import com.springboot.dbboot.entities.Vendor;

@Repository
public interface IVendorPersistance extends JpaRepository<Vendor, String>{

	
	VendorService vs = new VendorService();
	
	String gstNoFilter = "%?1%"; 
	
	
	@Query(nativeQuery = true, value="SELECT * FROM public.vendor where VENDOR_ID = :vendorId")
	Optional<Vendor> findbyVendorId(String vendorId);
	
	List <Vendor> findByCompanyName(String companyName);
	
	@Query(nativeQuery=true, 
			value="SELECT * FROM public.vendor where lower(GST_NO) like %?1%")	
	List<Vendor> lookupVendorByGST(String GSTNo);	
	
	@Query(nativeQuery=true, 
			value="SELECT * FROM public.vendor where lower(GST_NO) like "+gstNoFilter+"  and (COMP_NAME) ~ 'IBM'" )	
	List<Vendor> lookupVendorByGSTAndCompanyName(@Param("GSTNo") String GSTNo, String CompanyName, @Param("GSTNoFilter") String gstNoFilter);	
	
//	@Query(nativeQuery=true, value="SELECT * FROM public.vendor where lower(GST_NO) like"+gst_filter)
	
}
