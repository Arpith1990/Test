import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class GetMethod {

	@Test
	public void GetweatherDetails() {
		
		
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		
		RequestSpecification httpRequest=RestAssured.given();
		
		Response response =httpRequest.request(Method.GET,"bangalore");
	
		String responsebody=response.getBody().asString();
		
		System.out.println(responsebody);
		
		int status=response.getStatusCode();
		
		
		
	}
	
	
	
}
