package com.api.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class JSONDataBind3 {

	 Faker faker = new Faker();
	  int newUserID ; 
	  
	@BeforeClass
	public void init() {
		RestAssured.baseURI = "http://www.vaso-sophie.dev.cc";
		RestAssured.basePath = "/wp-json/wp/v2";
	}

	@Test
	public void test() {
		Map<String, Object> map1 = new HashMap<>();
		map1.put("title", faker.book().title());
		map1.put("content", "super");
		map1.put("status", "publish");
		
		given().relaxedHTTPSValidation().auth().preemptive().basic("sofochka87", "kakdela123")
		.contentType(ContentType.JSON)
		.body(map1)
		.when().log().all()
		.post("/posts")
		.then()
		.statusCode(201)
		.header("Content-Type", containsString("application/json"));
		
	}
	/*
	   * use this end point -- GET https://api.got.show/api/characters/
	   * get only the characters belong to house stark  tips -- use findAll method 
	   * and get the count of it 
	   * and print out as String 
	   * */
}
