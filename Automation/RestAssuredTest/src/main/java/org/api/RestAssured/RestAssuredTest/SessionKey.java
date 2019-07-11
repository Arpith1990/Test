package org.api.RestAssured.RestAssuredTest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class SessionKey {

	@Test
	
		public void cookieId() {
			
			
			
			RestAssured.baseURI="http://localhost:8080";
			
		Response res=	given().
			
			header("Content-Type","application/json").
			
			body("{ \"username\": \"admin\", \"password\": \"admin\" }").
			
			when().
			
			post("/rest/auth/1/session").
			then().assertThat().statusCode(200).
			
			extract().response();
			
		String responseString= res.asString();
		
		JsonPath js= new JsonPath(responseString);
		
	System.out.println(js.get("session.value"));	
			
			
			
			
			
		}
}
