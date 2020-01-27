package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import framework.Data;

public class results {

	public static void main(String[] args) {
		/*
		 * String datafilepath =
		 * "E:\\SeleniumJava\\CogmentoAutomation\\newdata\\anil.xlsx"; String sheetname
		 * = "sheet1"; HashMap<String, String> tcData = ExcelUtil.getData(datafilepath,
		 * sheetname, "TC_1"); System.out.println(tcData.get("COMPANY_NAME"));
		 */

		/*
		 * System.setProperty("webdriver.chrome.driver", Data.CHROME_DRIVER_PATH);
		 * Data.driver = new ChromeDriver();
		 * Data.driver.get("https://www.linkedin.com/login");
		 * Data.driver.manage().window().maximize();
		 * Data.driver.findElement(By.id("username")).sendKeys("8688");
		 * Data.driver.findElement(By.id("password")).sendKeys("okkkoklol");
		 * Data.driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		 * Data.driver.findElement(By.xpath("//span[text()='Me']")).click();
		 * Data.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 * Data.driver.findElement(By.xpath(
		 * "//a[@data-control-name='nav.settings_signout']")).click();
		 * 
		 * 
		 * }
		 */
		System.setProperty("webdriver.chrome.driver", Data.CHROME_DRIVER_PATH);
		Data.driver = new ChromeDriver();
		Data.driver.get("https://classic.freecrm.com/index.html");
		Data.driver.findElement(By.name("username")).sendKeys("sudhananda123");
		Data.driver.findElement(By.name("password")).sendKeys("Test@1234");
		Data.driver.findElement(By.xpath("//input[@type='submit']")).click();
		Data.driver.switchTo().frame("mainpanel");
		WebElement ele = Data.driver.findElement(By.xpath("//a[text()='Companies']"));
		Actions act = new Actions(Data.driver);
		act.moveToElement(ele).perform();
		Data.driver.findElement(By.xpath("//a[text()='New Company']")).click();
		Data.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Data.driver.findElement(By.xpath("//input[@id='company_name']")).sendKeys("11ssss");

		// List<String>status=Data.driver.findElement(By.
		WebElement ele1 = Data.driver.findElement(By.name("status"));
		Select sec = new Select(ele1);
		sec.selectByVisibleText("Hot");
		WebElement ele2 = Data.driver.findElement(By.xpath("//select[@name='priority']"));
		Select sec1 = new Select(ele2);
		sec1.selectByVisibleText("High");

		// WebElement el = Data.driver.findElement(By.xpath("//option[text()='Low']"));

		// Select sec1 = new Select(ele2);
		// sec1.selectByVisibleText("High");

		/*
		 * Data.driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		 * Data.driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		 * Data.driver.findElement(By.name("Submit")).click(); // WebElement web =
		 * Data.driver.findElement(By.xpath("//b[text()='Admin']")); // Actions act =
		 * new Actions(Data.driver); // act.moveToElement(web).perform(); // WebElement
		 * web1 = // Data.driver.findElement(By.xpath("//a[text()='Qualifications']"));
		 * // Actions act1 = new Actions(Data.driver); //
		 * act.moveToElement(web1).perform(); WebElement web =
		 * Data.driver.findElement(By.xpath("//b[text()='PIM']")); Actions act = new
		 * Actions(Data.driver); act.moveToElement(web).perform(); //
		 * Data.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 * Data.driver.findElement(By.id("menu_pim_addEmployee")).click(); WebElement
		 * ele = Data.driver.findElement(By.xpath("//label[text()='Employee Id']")); if
		 * (ele.isDisplayed()) { System.out.println("empid is displayed"); } else {
		 * System.out.println("empid is not displayed"); } /* String value =
		 * Data.driver.findElement(By.id("employeeId")).getAttribute("value");
		 * System.out.println(value); if (!value.isEmpty()) { if
		 * (value.matches("[0-9]{4}")) {
		 * System.out.println("emp id is populated as expected"); } else {
		 * System.out.println("emp id is not populated as expected");
		 * 
		 * }
		 * 
		 * }
		 */
		// System.out.println(value);
		// Data.driver.findElement(By.id("employeeId")).clear();
		// Data.driver.findElement(By.id("employeeId")).sendKeys("12345");

	}
}
