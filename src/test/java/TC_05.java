import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_05 {
	@Test
	void extractingAllNodesValues()
	{   
		
		RestAssured.baseURI="https://reqres.in/api/users";
		RequestSpecification httprequest = RestAssured.given();
		Response response = httprequest.request(Method.GET,"?page=2");
		JsonPath jsonpath=response.jsonPath();
		System.out.println(jsonpath.get("page"));
		System.out.println(jsonpath.get("per_page"));
		System.out.println(jsonpath.get("total"));
		System.out.println(jsonpath.get("total_pages"));
		System.out.println(jsonpath.get("data.avatar"));
        String responseBody=response.getBody().asString();
		System.out.println("Response Body" + "is" +responseBody );
		
		

}
}

