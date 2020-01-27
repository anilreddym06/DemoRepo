package basics_of_excel;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import framework.Data;

public class debug {
	@Test
	public void Testmethod() {

		Random r = new Random();
		System.setProperty("webdriver.chrome.driver", Data.CHROME_DRIVER_PATH);
		WebDriver driver = new ChromeDriver();
		// int res = r.nextInt() + r.nextInt() * 20;
		driver.get(data.url);

	}
}
