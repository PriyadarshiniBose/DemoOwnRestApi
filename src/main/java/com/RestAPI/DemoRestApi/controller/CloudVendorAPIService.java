package com.RestAPI.DemoRestApi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.RestAPI.DemoRestApi.model.CloudVendor;
import com.RestAPI.DemoRestApi.repo.CloudRepo;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorAPIService {

    @Autowired
    private CloudRepo cloudRepo; // Inject the repository

    @PostMapping
    public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
        cloudRepo.save(cloudVendor); // Save the entity to the database
        return "Cloud Vendor Created Successfully";
    }

    @GetMapping
    public List<CloudVendor> getAllCloudVendors() {
        return cloudRepo.findAll(); // Retrieve all vendors from the database
    }

    @GetMapping("/{vendorId}")
    public CloudVendor getCloudVendorDetails(@PathVariable Long vendorId) {
        return cloudRepo.findById(vendorId).orElse(null); // Retrieve a vendor by ID
    }

    @PutMapping("/{vendorId}")
    public String updateCloudVendorDetails(@PathVariable Long vendorId, @RequestBody CloudVendor cloudVendor) {
        if (cloudRepo.existsById(vendorId)) {
            cloudVendor.setVendorID(vendorId); // Set the ID for the entity
            cloudRepo.save(cloudVendor); // Update the entity in the database
            return "Cloud Vendor Updated Successfully";
        } else {
            return "Vendor not found";
        }
    }

    @DeleteMapping("/{vendorId}")
    public String deleteCloudVendorDetails(@PathVariable Long vendorId) {
        if (cloudRepo.existsById(vendorId)) {
            cloudRepo.deleteById(vendorId); // Delete the entity from the database
            return "Cloud Vendor Deleted Successfully";
        } else {
            return "Vendor not found";
        }
    }
}

	
//	CloudVendor cloudVendor;
//
//	@GetMapping("{vendorId}")
//	public CloudVendor getCloudVendorDetails(String vendorId) {
////		return new CloudVendor("C1","Priya","Abcd street",
////				"9876543210");
//		return cloudVendor;
//	}
//
//	@PostMapping
//	public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
//		this.cloudVendor = cloudVendor;
//		
//		 //cloudVendors.add(cloudVendor);
//		return "Cloud Vendor Created Successfully";
//	}
//
//	@PutMapping
//	public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
//		this.cloudVendor = cloudVendor;
//		return "Cloud Vendor Updated Successfully";
//	}
//
//	@DeleteMapping("{vendorId}")
//	public String deleteCloudVendorDetails(String vendorId) {
//		this.cloudVendor = null;
//		return "Cloud Vendor Deleted Successfully";
//	}
	

//}
