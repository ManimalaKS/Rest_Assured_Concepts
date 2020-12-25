import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_02 {
	@Test
	void creatingEmployees()
	{
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RequestSpecification httprequest = RestAssured.given();
		JSONObject requestparam=new JSONObject();
		requestparam.put("name", "mani");
		requestparam.put("salary", "24000");
		requestparam.put("age", "21");
		httprequest.headers("Content-Type","application/json");
		httprequest.body(requestparam.toJSONString());
		Response response = httprequest.request(Method.POST,"/create");
		String status=response.jsonPath().get("status");
		Assert.assertEquals(status, "success");
		int status_code=response.getStatusCode();
		System.out.println("Status Code is"  +status_code);
		Assert.assertEquals(status_code, 200);

		
	}

}
