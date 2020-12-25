import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_03 {
	@Test
	void getAllHeaders()
	{
		RestAssured.baseURI="https://reqres.in/api/users";
		RequestSpecification httprequest = RestAssured.given();
		Response response = httprequest.request(Method.GET,"?page=2");
		String responseBody=response.getBody().asString();
		System.out.println("Response Body" + "is" +responseBody );
		Headers allheads=response.headers();
		for(Header headers : allheads)
		{
			 System.out.println(headers.getName() + headers.getValue());
		}
	}

}
