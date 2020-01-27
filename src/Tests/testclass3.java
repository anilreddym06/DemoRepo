package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import framework.Data;

public class testclass3 {
	
	@Test
	public void purchaseorder() {
		System.setProperty("webdriver.chrome.driver", Data.CHROME_DRIVER_PATH);
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com");
		System.out.println("hey i am in google page");
		driver.quit();
	}
	
	@Test
	public void salesorder() {
		System.setProperty("webdriver.chrome.driver", Data.CHROME_DRIVER_PATH);
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com");
		System.out.println("hey i am in google page");
		driver.quit();
	}
	@Test
	public void workorder() {
		System.setProperty("webdriver.chrome.driver", Data.CHROME_DRIVER_PATH);
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com");
		System.out.println("hey i am in google page");
		driver.quit();
	}



}
