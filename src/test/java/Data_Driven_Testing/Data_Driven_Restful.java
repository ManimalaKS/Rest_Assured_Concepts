package Data_Driven_Testing;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class Data_Driven_Restful {
	//POST Method Demo
	@Test(dataProvider="empdata")
	void addNewEmployees(String ename,String esalary,String eage)
	{
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RequestSpecification httprequest = RestAssured.given();
		JSONObject requestparam=new JSONObject();
		// Passing the body
		requestparam.put("name", ename);
		requestparam.put("salary",esalary);
		requestparam.put("age", eage);
		//add the header stating that the request body is json format
		httprequest.headers("Content-Type","application/json");
		//add the json to the body of the request
        httprequest.body(requestparam.toJSONString());
        // Sending the POST Request
		Response response = httprequest.request(Method.POST,"/create");
		String responseBody=response.getBody().asString();
		System.out.println("Response Body" + "is" +responseBody );
		Assert.assertEquals(responseBody.contains(ename), true);
		Assert.assertEquals(responseBody.contains(esalary), true);
		Assert.assertEquals(responseBody.contains(eage), true);
		int status_code=response.getStatusCode();
		System.out.println("Status code is"  + status_code);
		
	}
	@DataProvider(name="empdata")
	String [][] getData()
	{
		String employee[][]= { {"nani" , "23000" , "20"},{"kishore" , "24000" , "24"},{"ganesh" , "25000" , "29"}};
		return(employee);
	}

}
