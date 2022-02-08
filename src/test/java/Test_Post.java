import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Test_Post {
	
	@Test(priority=0)
	public void test_Post() {
		
//			Map<String, Object> map = new HashMap<String, Object>();
//			map.put("name", "Akram");
//			map.put("job", "SQA Automation Engineer");
//			System.out.println(map);
			
			JSONObject request = new JSONObject();
			request.put("name", "Akram");
			request.put("job", "SQA Automation Engineer");
//			System.out.println(request);
			System.out.println(request.toJSONString());
			given().header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
			when().
			post("https://reqres.in/api/users").
			then().
			statusCode(201).log().all();
			
			
			
	}
	
	@Test(priority=1)
	public void test_Put() {
		
//			Map<String, Object> map = new HashMap<String, Object>();
//			map.put("name", "Akram");
//			map.put("job", "SQA Automation Engineer");
//			System.out.println(map);
			
			JSONObject request = new JSONObject();
			request.put("name", "SUMONA");
			request.put("job", "MANAGER");
//			System.out.println(request);
			System.out.println(request.toJSONString());
			given().header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
			when().
			put("https://reqres.in/api/users/2").
			then().
			statusCode(200).log().all();
			
			
			
	}
	
	@Test(priority=2)
	public void test_Patch() {
		
//			Map<String, Object> map = new HashMap<String, Object>();
//			map.put("name", "Akram");
//			map.put("job", "SQA Automation Engineer");
//			System.out.println(map);
			
			JSONObject request = new JSONObject();
			request.put("name", "SUMONA");
			request.put("job", "MANAGER");
//			System.out.println(request);
			System.out.println(request.toJSONString());
			given().header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
			when().
			patch("https://reqres.in/api/users/2").
			then().
			statusCode(200).log().all();
			
			
			
	}
	
	@Test(priority=3)
	public void test_Delete() {
		
			when().
			delete("https://reqres.in/api/users/2").
			then().
			statusCode(204).log().all();
			
			
			
	}
	

}
