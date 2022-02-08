import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Example {
	
	//@Test
	public void test_get() {
		
		baseURI = "http://localhost:3000/";
		given().
		param("name", "Automation").
			get("/subject").
		then().
			statusCode(200).
			log().all();
	}
	
	//@Test
	public void test_Post() {
		JSONObject request = new JSONObject();
		request.put("firstName", "Sabiul");
		request.put("lastName", "Islam");
		request.put("subjectId", 2);
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
	
	//@Test
	public void test_Patch() {
		JSONObject request = new JSONObject();
		request.put("firstName", "Rima");
		baseURI = "http://localhost:3000/";
		given().header("Content-Type", "application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		patch("/users/2").
		then().
		statusCode(200).log().all();
		
	}
	
		//@Test
		public void test_Put() {
			JSONObject request = new JSONObject();
			request.put("firstName", "Rimu");
			request.put("lastName", "Islam");
			request.put("subjectId", 2);
			baseURI = "http://localhost:3000/";
			given().header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
			when().
			put("/users/2").
			then().
			statusCode(200).log().all();
			}
		@Test
		public void test_Delete() {
			baseURI = "http://localhost:3000/";
			when().
				delete("/users/2").
			then().
			statusCode(200);
		}

}
