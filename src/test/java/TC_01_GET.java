import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TC_01_GET {
	
	@Test
	void test_01() {
		Response aResponse = get("https://reqres.in/api/users?page=2");
		System.out.println(aResponse.asString());
		System.out.println(aResponse.getBody().asString());
		System.out.println(aResponse.getStatusCode());
		System.out.println(aResponse.getStatusLine());
		System.out.println(aResponse.getTime());
		System.out.println(aResponse.getHeader("content-type"));
		
		int statusCode = aResponse.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}
	
	@Test
	void test_02() {
		given()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200)
		.body("data.id[0]", equalTo(7));
	}

}
