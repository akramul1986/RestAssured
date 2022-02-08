package demo;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Parameters;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DataDrivenExample extends DataForTests{
	
		//@Test (dataProvider = "Data For Post")
		public void test_Post(String firstName, String lasnName, int subjectId) {
			JSONObject request = new JSONObject();
			request.put("firstName", firstName);
			request.put("lastName", lasnName);
			request.put("subjectId", subjectId);
			baseURI = "http://localhost:3000/";
			given().header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
			when().
			post("/users").
			then().
			statusCode(201).log().all();
			
		}
		
		//@Test (dataProvider = "Data For Delete")
		public void test_Delete(int userID) {
			baseURI = "http://localhost:3000/";
			when().
				delete("/users/"+userID).
			then().
			statusCode(200);
		}
		
		@Parameters({"userID"})
		@Test
		public void test_Delete2(int userID) {
		baseURI = "http://localhost:3000/";
			when().
				delete("/users/"+userID).
			then().
				statusCode(200);
		}

}
