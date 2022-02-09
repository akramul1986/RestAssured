package demo;
import java.io.IOException;

import org.testng.annotations.DataProvider;

import utils.Constants;
import utils.ExcelUtils;

public class DataForTests {
	
	static ExcelUtils excelUtils = new ExcelUtils();
	static String excelFilePath =Constants.Path_TestData+Constants.File_TestData;
	
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
	
	@DataProvider(name="Data For Post to use Exelsheet")
	public void setData() throws IOException {
		excelUtils.setExcelFile(excelFilePath,"STUDENT_DATA");
		for(int i=1;i<=excelUtils.getRowCountInSheet();i++)
        {
			excelUtils.getCellData(i,0);
			excelUtils.getCellData(i,1);
			excelUtils.getCellData(i,2);
			//System.out.println("Toatal Value Is :"+i);
        }
		
	}
	
	
	
	@DataProvider (name="Data For Delete")
	public Object [] dataForDelete() {
		return new Object [] {
			6,7	
		};
	}

}
