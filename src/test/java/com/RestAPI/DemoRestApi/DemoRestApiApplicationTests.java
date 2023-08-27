package com.RestAPI.DemoRestApi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class DemoRestApiApplicationTests {

	@LocalServerPort
	private int port;

	@BeforeEach
	public void setUp() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = port;
	}

//	@Test
//	public void createCloudVendor_shouldReturnSuccess() {
//		given().contentType("application/json").body(
//				"{\"vendorName\": \"suba\", \"vendorAddress\": \"Ramnad\", \"vendorPhoneNumber\": \"9087654321\"}")
//				.when().post("/cloudvendor").then().statusCode(200).body(equalTo("Cloud Vendor Created Successfully"));
//	}
 
	@Test
	public void getAllCloudVendors_shouldReturnListOfVendors() {
		given().when().get("/cloudvendor").then().statusCode(200).body("size()", greaterThanOrEqualTo(0)); // Assuming
																											// at least
																											// one
																											// vendor
	}

	@Test
	public void getCloudVendorDetails_shouldReturnSingleVendor() {
		given().when().get("/cloudvendor/{vendorId}", 14) // Assuming vendor with ID 1 exists
				.then().statusCode(200).body("vendorName", equalTo("suba")).body("vendorAddress", equalTo("Ramnad"))
				.body("vendorPhoneNumber", equalTo("9087654321"));
	}

	@Test
	public void updateCloudVendorDetails_shouldReturnSuccess() {
		given().contentType("application/json")
				.body("{\"vendorName\": \"diyasriRaghu\", \"vendorAddress\": \"UK\", \"vendorPhoneNumber\": \"9871234210\"}")
				.when().put("/cloudvendor/{vendorId}", 15) // Assuming vendor with ID 1 exists
				.then().statusCode(200).body(equalTo("Cloud Vendor Updated Successfully"));
	}

	@Test
	public void deleteCloudVendorDetails_shouldReturnSuccess() {
		given().when().delete("/cloudvendor/{vendorId}", 18) // Assuming vendor with ID 1 exists
				.then().statusCode(200).body(equalTo("Cloud Vendor Deleted Successfully"));
	}
}
