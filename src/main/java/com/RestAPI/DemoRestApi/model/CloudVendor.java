package com.RestAPI.DemoRestApi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CloudVendor {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long vendorID;
	private String vendorName;
	private String vendorAddress;
	private String vendorPhoneNumber;

	public CloudVendor() {
	}
//
//	/**
//	 * @param vendorID
//	 * @param vendorName
//	 * @param vendorAddress
//	 * @param vendorPhoneNumber
//	 */
	public CloudVendor( String vendorName, String vendorAddress, String vendorPhoneNumber) {
		
		this.vendorName = vendorName;
		this.vendorAddress = vendorAddress;
		this.vendorPhoneNumber = vendorPhoneNumber;
	}

	public Long getVendorID() {
		return vendorID;
	}

	public void setVendorID(Long vendorID) {
		this.vendorID = vendorID;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getVendorAddress() {
		return vendorAddress;
	}

	public void setVendorAddress(String vendorAddress) {
		this.vendorAddress = vendorAddress;
	}

	public String getVendorPhoneNumber() {
		return vendorPhoneNumber;
	}

	public void setVendorPhoneNumber(String vendorPhoneNumber) {
		this.vendorPhoneNumber = vendorPhoneNumber;
	}

}
