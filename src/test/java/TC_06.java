import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_06 {
	@Test
	public void autherization()
	{
		
		PreemptiveBasicAuthScheme authschema=new PreemptiveBasicAuthScheme();
		authschema.setUserName("ToolsQA");
		authschema.setPassword("TestPassword");
		RestAssured.authentication=authschema;
		RestAssured.baseURI="https://postman-echo.com";
		RequestSpecification httprequest = RestAssured.given();
		Response response = httprequest.request(Method.GET,"/basic-auth");
		int status_code=response.getStatusCode();
		System.out.println("Status Code" +  status_code);
		String responseBody=response.getBody().asString();
		System.out.println("Response Body" + "is" +responseBody );
		
		
	}

}
