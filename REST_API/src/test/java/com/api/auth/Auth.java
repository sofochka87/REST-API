package com.api.auth;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Auth {

	Faker faker = new Faker();
	int newUserID;
	String token;

	@BeforeClass
	public void init() {
		RestAssured.baseURI = "http://www.qa-sophie.dev.cc";
		// RestAssured.basePath = "/wp-json/wp/v2";
		RestAssured.useRelaxedHTTPSValidation();

		token = getToken();

	}

	// TOKEN: http://www.qa-sophie.dev.cc/wp-json/jwt-auth/v1/token

	public String getToken() {
		RestAssured.basePath = "/wp-json/jwt-auth/v1";
		Response res = given().accept(ContentType.JSON)
				.contentType(ContentType.URLENC)
				.formParam("username", "admin")
				.formParam("password", "admin123")
				.log().all()
				.when().log().all()
				.post("/token");

		token = res.jsonPath().getString("token");
		return token;
	}

	// @Ignore
	@Test
	public void test() {
		    RestAssured.basePath = "/wp-json/wp/v2" ; 

		    Map<String,Object> mp = new HashMap<>() ; 
		    mp.put("title", faker.book().title());
		    mp.put("content", "super");
		    mp.put("status", "publish");

		  given()
		    .header("Authorization", "Bearer " + token)
		    .contentType(ContentType.JSON)
		    .body(mp).

		  when()
		    .log().all()
		    .post("/posts").
		  then()
		    .statusCode(201)
		    .header("Content-Type" , containsString("application/json"));
 
		    
		  }

}
