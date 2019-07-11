package org.api.RestAssured.RestAssuredTest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.api.RestAssured.Reusablemethods.ReusableMethods;

public class JiraTest {

	@Test
	
	public void jiraIssue() {
		
		
		RestAssured.baseURI="http://localhost:8080";
		
		Response res=	given().
		
			
			header("Content-Type", "application/json").
			header("Cookie","JSESSIONID="+ReusableMethods.jsession()).
			body("{\r\n" + 
					"    \"fields\": {\r\n" + 
					"       \"project\":\r\n" + 
					"       {\r\n" + 
					"          \"key\": \"TEST\"\r\n" + 
					"       },\r\n" + 
					"       \"summary\": \"REST ye merry gentlemen.\",\r\n" + 
					"       \"description\": \"Creating of an issue using project keys and issue type names using the REST API\",\r\n" + 
					"       \"issuetype\": {\r\n" + 
					"          \"name\": \"Task\"\r\n" + 
					"       }\r\n" + 
					"   }\r\n" + 
					"}").
		when().
		
		post("/rest/api/latest/issue").
		
		then().assertThat().statusCode(201).
		extract().response();
		
		String responseString=res.asString();
		
		System.out.println(responseString);
		
		JsonPath js= new JsonPath(responseString);
		
		js.get("id");
	}

}
