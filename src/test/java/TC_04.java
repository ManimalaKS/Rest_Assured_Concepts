import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_04 {
	@Test
	void verifyJsonBody()
	{   
		
		RestAssured.baseURI="https://reqres.in/api/users";
		RequestSpecification httprequest = RestAssured.given();
		Response response = httprequest.request(Method.GET,"?page=2");
		String responseBody=response.getBody().asString();
		System.out.println("Response Body" + "is" +responseBody );
		Assert.assertEquals(responseBody.contains("Michael"), true);
		
	}

}
