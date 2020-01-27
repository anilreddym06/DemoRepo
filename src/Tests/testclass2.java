package Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class testclass2 {
	
	@DataProvider
	public Object[][] loginInfo(){
		Object[][] data=new Object[2][2];
		data[0][0]="chrome";
		data[0][1]="http://google.com";
		data[1][0]="chrome";
		data[1][1]="http://google.com";
		return data;	
		
	}
	@Test(dataProvider ="loginInfo")
	public void createsalesorder(String browser, String url) {
		System.out.println(browser+ "--------->" +url);
		
		
	}

}
