package com.api.tests;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.api.pojos.Driver;
import com.api.pojos.GOT_Character;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class GOTshow {

	/*
	   * use this end point -- GET https://api.got.show/api/characters/
	   * get only the characters belong to house stark  tips -- use findAll method 
	   * and get the count of it 
	   * and print out as String 
	   * */
	@Test
	public void testGOT() {
	Response response = 
			given().relaxedHTTPSValidation()
			.accept(ContentType.JSON)
			.when()
			.get("https://api.got.show/api/characters/");
	
	String responseString = response.asString();
	System.out.println("Response--> "+responseString);
	
	JsonPath jp = JsonPath.from(responseString);
	System.out.println(jp.getString("house[0]"));
	
	List<String> starks = jp.getList("findAll{it.house=='House Stark'}.name", String.class);
	System.out.println("Starks--> "+starks);
	System.out.println(starks.size());
	}
	
	@Test
	public void GOT_Characters() throws Exception {
		 String people  = " [\n" + 
			      "    {\n" + 
			      "        \"_id\": \"56ffc5be043244081938576d\",\n" + 
			      "        \"male\": true,\n" + 
			      "        \"house\": \"House Hightower\",\n" + 
			      "        \"slug\": \"Abelar_Hightower\",\n" + 
			      "        \"name\": \"Abelar Hightower\",\n" + 
			      "        \"__v\": 0,\n" + 
			      "        \"pageRank\": 2.5,\n" + 
			      "        \"books\": [\n" + 
			      "            \"The Hedge Knight\"\n" + 
			      "        ],\n" + 
			      "        \"updatedAt\": \"2016-04-02T13:14:38.834Z\",\n" + 
			      "        \"createdAt\": \"2016-04-02T13:14:38.834Z\",\n" + 
			      "        \"titles\": [\n" + 
			      "            \"Ser\"\n" + 
			      "        ]\n" + 
			      "    },\n" + 
			      "    {\n" + 
			      "        \"_id\": \"56ffc5be043244081938576e\",\n" + 
			      "        \"male\": true,\n" + 
			      "        \"house\": \"House Frey\",\n" + 
			      "        \"slug\": \"Addam_Frey\",\n" + 
			      "        \"name\": \"Addam Frey\",\n" + 
			      "        \"__v\": 0,\n" + 
			      "        \"pageRank\": 4.5,\n" + 
			      "        \"books\": [\n" + 
			      "            \"The Mystery Knight\"\n" + 
			      "        ],\n" + 
			      "        \"updatedAt\": \"2016-04-02T13:14:38.875Z\",\n" + 
			      "        \"createdAt\": \"2016-04-02T13:14:38.875Z\",\n" + 
			      "        \"titles\": [\n" + 
			      "            \"Ser\"\n" + 
			      "        ]\n" + 
			      "    },\n" + 
			      "    {\n" + 
			      "        \"_id\": \"56ffc5be043244081938576f\",\n" + 
			      "        \"male\": true,\n" + 
			      "        \"slug\": \"Addam\",\n" + 
			      "        \"name\": \"Addam\",\n" + 
			      "        \"__v\": 0,\n" + 
			      "        \"pageRank\": 1.5,\n" + 
			      "        \"books\": [\n" + 
			      "            \"The Mystery Knight\"\n" + 
			      "        ],\n" + 
			      "        \"updatedAt\": \"2016-04-02T13:14:38.877Z\",\n" + 
			      "        \"createdAt\": \"2016-04-02T13:14:38.877Z\",\n" + 
			      "        \"titles\": [\n" + 
			      "            \"Ser\"\n" + 
			      "        ]\n" + 
			      "    } ] " ; 
			  
		ObjectMapper omapper = new ObjectMapper();
		GOT_Character[] per = omapper.readValue(people, GOT_Character[].class);
		System.out.println(per);
		String convertedString = omapper.writeValueAsString(per);
		System.out.println(convertedString);
		
	}
}
