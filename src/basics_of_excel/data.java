package basics_of_excel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import framework.Data;

public class data {

	/*
	 * @Test public void testmethod() { int count = 0; for (int i = 0; i <= 10; i++)
	 * { count = count + i + 2;
	 * 
	 * }
	 * 
	 * System.out.println(count); }
	 * 
	 * @Test public void testmethod1() throws InterruptedException {
	 * System.setProperty("webdriver.chrome.driver", Data.CHROME_DRIVER_PATH);
	 * WebDriver driver = new ChromeDriver(); driver.get("http:\\facebook.com");
	 * Thread.sleep(5000); JavascriptExecutor jp = (JavascriptExecutor) driver;
	 * jp.executeScript("scroll(0,80)"); }
	 */

	@Test
	public void testmethod2() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", Data.CHROME_DRIVER_PATH);
		WebDriver driver = new ChromeDriver();
		driver.get("http:\\facebook.com");
		Thread.sleep(5000);
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//a[text()='Help']"))).perform();
	}
	// JavascriptExecutor jp = (JavascriptExecutor) driver;
	// jp.executeScript("arguments[0].scrollIntoView(true)",
	// driver.findElement(By.xpath("//a[text()='Help']")));

	/*
	 * @Test public void testmethod3() throws InterruptedException {
	 * System.setProperty("webdriver.chrome.driver", Data.CHROME_DRIVER_PATH);
	 * WebDriver driver = new ChromeDriver(); driver.get("http:\\facebook.com");
	 * Thread.sleep(5000); JavascriptExecutor jp = (JavascriptExecutor) driver;
	 * jp.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	 * Thread.sleep(5000);
	 * jp.executeScript("window.scrollTo(document.body.scrollHeight,0)"); }
	 */
}
