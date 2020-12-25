import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_01 {
	
	
	@Test
	void getWeatherDetails()
	{
		RestAssured.baseURI="https://reqres.in/api/users";
		RequestSpecification httprequest = RestAssured.given();
		Response response = httprequest.request(Method.GET,"?page=2");
		String responseBody=response.toString();
		System.out.println("Response Body is " +responseBody);
		int status_code=response.getStatusCode();
		System.out.println("Status Code is"  +status_code);
		String status_line=response.getStatusLine();
		System.out.println("Status line is"  +status_line);
	    Assert.assertEquals(status_line, "HTTP/1.1 200 ok");
		Assert.assertEquals(status_code, 200);

		
	}
	@AfterMethod
	public void tearDown()
	{
		System.out.print("tear down");
	}

}
