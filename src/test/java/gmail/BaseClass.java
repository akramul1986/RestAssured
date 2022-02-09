package gmail;
import static io.restassured.RestAssured.*;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;

public class BaseClass {
	
	@BeforeClass
	public void setUP() {
		
		RestAssured.authentication = RestAssured.preemptive().
				basic("TOOLSQA-Test", "Test@@123");
		baseURI = "https://bookstore.demoqa.com/";
	}

}
