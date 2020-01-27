package basics_of_excel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class testclass {
	public WebDriver driver;

	@Test
	public void hhhh() {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium Jar files\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://google.com");

	}

}
