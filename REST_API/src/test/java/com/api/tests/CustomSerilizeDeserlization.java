package com.api.tests;

	import org.testng.annotations.Test;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
	import com.fasterxml.jackson.databind.ObjectMapper;

	public class CustomSerilizeDeserlization {

	  
	  @Test
	  public void test() throws Exception{
	    
	    //String greeting = "{\"name\":\"Adam\" , \"message\":\"Hello\"}" ; 
	    
	    String greeting = "{\"name\":\"Adam\" , \"message\":\"Hello\" , \"extraMessage\":\"goodbye\"}" ; 
	    ObjectMapper mapper = new ObjectMapper(); 
	    
	    Greeting g1 = mapper.readValue(greeting , Greeting.class) ; 
	    System.out.println(g1);
	    
	    
	    
	  }

	}

	@JsonIgnoreProperties(ignoreUnknown = true )
	class Greeting{
	  
		@JsonIgnore
	  String name ; 
	  String message ; 
	  
	  public Greeting() {
	    // TODO Auto-generated constructor stub
	  }

	  @Override
	  public String toString() {
	    return "Greeting [name=" + name + ", message=" + message + "]";
	  }

	  public Greeting(String name, String message) {
	    super();
	    this.name = name;
	    this.message = message;
	  }

	  public String getName() {
	    return name;
	  }

	  public void setName(String name) {
	    this.name = name;
	  }

	  public String getMessage() {
	    return message;
	  }

	  public void setMessage(String message) {
	    this.message = message;
	  }

	  
	}

