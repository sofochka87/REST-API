package com.api.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.* ;
import static io.restassured.matcher.RestAssuredMatchers.* ;
import static org.hamcrest.Matchers.* ;

public class Test1 {

	/*
	 * Given end-point http://postman-echo.com/time/leap?timestamp=2016-10-10
	 * When i send a HTTP GET request to the server
	 * Then I should get 200 OK stetus code 
	 */ 
	@Test(priority=1)
	public void first_Test() {
		 when()
		.get("http://73.166.37.2:1000/ords/hr/employees/100")
		.then()
		.statusCode(200);
	}
	
	@Test(priority=2)
	public void second_test() {
		 when()
		.get("http://www.vaso-sophie.dev.cc/wp-json/wp/v2/posts")
		.then()
		.statusCode(200);
	}
	@Test(priority=3)
	public void third_test() {
		 when()
		.get("http://73.166.37.2:1000/ords/hr/employees/101")
		.then()
		.statusCode(200);
	}
	/* 
	 *  Given end-point http://www.vaso-sophie.dev.cc/wp-json/wp/v2/posts/21
	 * When i send a HTTP GET request to the server
	 * Then I should get 200 OK stetus code */
	@Test(priority=4)
	public void fourth_test() {
		 given()
		.relaxedHTTPSValidation()
		.when()
		.get("https://www.vaso-sophie.dev.cc/wp-json/wp/v2/posts/21")
		.then()
		.statusCode(200);
	}
	/* 
	 *  Given end-point http://www.vaso-sophie.dev.cc/wp-json/wp/v2/posts/21
	 * When i send a HTTP GET request to the server
	 * Then I should get 200 OK stetus code
	 */
	@Test(priority=5)
	public void fifth_test() {
		given().relaxedHTTPSValidation()
		.when()
		     .get("https://www.vaso-sophie.dev.cc/wp-json/wp/v2/posts/26")
		.then()
		     .statusCode(200)
		.and()
		     .body("id", equalTo(26));
	}
	
	@Test(priority=6)
	public void sixth_test() {
		given().relaxedHTTPSValidation()
		.when()
		     .get("https://www.vaso-sophie.dev.cc/wp-json/wp/v2/posts/26")
		.then()
		     .statusCode(200)
		.and()
		     .body("id", equalTo(26))
		     .body("title.rendered", equalTo("From my collection PUT request test"))
		     .body("status", equalTo("publish"));
	}
	//
	@Test(priority=7)
	public void seventh_test() {
		given().relaxedHTTPSValidation()
		.when().log().all()
		.get("http://73.166.37.2:1000/ords/hr/jobs/ACXZ_DEV")
		.then().log().all()
		.statusCode(200)
		.body("min_salary", equalTo(9200))
		.body("job_title", equalTo("Tester"));
	}
	@Test(priority=8)
	public void eightth_test() {
		given().relaxedHTTPSValidation()
		.when().log().all()
		.get("http://73.166.37.2:1000/ords/hr/jobs/{id}", "ST_MAN")
		.then().log().all()
		.statusCode(200)
		.and().body("max_salary", equalTo(8500));
	}
	
	
}
