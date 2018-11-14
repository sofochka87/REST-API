package com.api.tests;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Test2_BaseURI {

	//Base URI Test
		@BeforeMethod
		   public void setUp() {
		    RestAssured.baseURI = "https://www.vaso-sophie.dev.cc/wp-json";
		    RestAssured.basePath = "/wp/v2";
		}
		@Test(priority=8)
		public void nineth_test() {			
			given().relaxedHTTPSValidation()
			.when().log().all()
			.get("/posts/21")
			.then().log().all()
			.statusCode(200);
		}
}
