package org.api.RestAssured.Reusablemethods;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ReusableMethods {

	
	
	public static String jsession() {
		
		

		RestAssured.baseURI="http://localhost:8080";
		
	Response res=	given().
		
		header("Content-Type","application/json").
		
		body("{ \"username\": \"arpith\", \"password\": \"arpith\" }").
		
		when().
		
		post("/rest/auth/1/session").
		then().assertThat().statusCode(200).
		
		extract().response();
		
	String responseString= res.asString();
	
	JsonPath js= new JsonPath(responseString);
	
String sessionId=(js.get("session.value"));	
		
		System.out.println(sessionId);
		
		return sessionId;
		
		
	}
	}
	
	

