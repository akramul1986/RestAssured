package gmail;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class GmailLogin extends BaseClass {
	
	@Test
	public void testCase01() {
		
		int code = given().
					get().
					getStatusCode();
		System.out.println("Response Code from the server"+code);
	}

}
