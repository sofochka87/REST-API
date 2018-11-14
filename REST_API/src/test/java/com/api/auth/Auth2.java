package com.api.auth;

	import static io.restassured.RestAssured.given;
	import static org.hamcrest.Matchers.*;

	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;

	import com.github.javafaker.Faker;

	import io.restassured.RestAssured;
	import io.restassured.http.ContentType;

	public class Auth2 {

		Faker faker = new Faker();
		int newUserID;
		String token =  
				"10960~GWx2JO98d7k67N6ksz4FzOcLLLlsix0g2e8VoEYYvB6lUdoYpG5Fjjq2UyiQlsLc";

		@BeforeClass
		public void init() {
			RestAssured.baseURI = "https://learn.cybertekschool.com";
			RestAssured.basePath = "/api/v1";
			RestAssured.useRelaxedHTTPSValidation();

		}
		@Test
		public void getAllModule() {
			given()
			.accept(ContentType.JSON)
			.auth().oauth2(token)
			.when().log().all()
			.get("/courses/73/modules")
			.then().statusCode(200)
			.body("$",hasSize(9) );
		}
}
