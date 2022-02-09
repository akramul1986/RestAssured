package gmail;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.path.json.JsonPath;

public class Authentication {
	
	@Test
	public void bearrerTokenAuthenticationTest() {
		
		baseURI = "https://bookstore.toolsqa.com/";
		RequestSpecification request = RestAssured.given();
		String paylod = "{\r\n  "
				+ "\"userName\": \"TOOLSQA-Test\",\r\n  "
				+ "\"password\": \"Test@@123\"\r\n"
				+ "}";
		request.header("Content-Type", "application/json");
		Response responseFromGenerateToken = request.body(paylod).post("/Account/V1/GenerateToken");
		responseFromGenerateToken.prettyPrint();
		String jsonString = responseFromGenerateToken.getBody().asString();
		String tokenGenerated = JsonPath.from(jsonString).get("token");
		request.header
		("Authorization", "Bearer "+tokenGenerated).
		header("Content-Type", "application/json");
		String addBookDetails = "{\r\n    "
				+ "\"userId\":\"a178a104-e3c0-4f50-bbd5-3e4919f063e8\","
				+ "\r\n    "
				+ "\"collectionOfIsbns\":[\r\n        "
				+ "{\r\n            \"isbn\":\"9781449325862\""
				+ "\r\n        }\r\n    ]"
				+ "\r\n}";
		Response addBooksResponse = request.body(addBookDetails).post("/BookStore/v1/Books");
		Assert.assertEquals(200, addBooksResponse.getStatusCode());
		
		addBooksResponse.prettyPrint();
		
	}

}
