package demo;
import org.testng.annotations.DataProvider;

public class DataForTests {
	
	@DataProvider(name="Data For Post")
	public Object [] [] dataForPost() {
//		Object [] [] data = new Object [2] [3];
//		data [0] [0] = "Moin";
//		data [0] [1] = "Uddin";
//		data [0] [2] = 1;
//		
//		data [1] [0] = "Rakibul";
//		data [1] [1] = "Islam";
//		data [1] [2] = 2;
//		return data;
		return new Object [] [] {
			{"Khan", "RASEL", 2},
			{"Abdur", "Rahim", 2}
		};
	}
	
	@DataProvider (name="Data For Delete")
	public Object [] dataForDelete() {
		return new Object [] {
			6,7	
		};
	}

}
