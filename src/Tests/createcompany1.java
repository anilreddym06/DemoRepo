package Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import framework.CommonMethods;
import framework.Data;
import framework.DataUtil;
import framework.EventMethods;
import framework.ExcelUtil;
import modules.companies;

public class createcompany1 {
	public static Properties configpproperties;

	@Test
	public void testmethod() throws IOException {

		try {
			String propfilepath = "E:\\SeleniumJava\\CogmentoAutomation\\Config\\MasterData.properties";
			configpproperties = DataUtil.getpropertiesfile(propfilepath);
		} catch (IOException e) {
			System.out.println("unable to read the data from properties file. Exception caught as: " + e.getMessage());
			System.exit(0);
		}
		System.out.println(configpproperties);
		CommonMethods.launchApplication(configpproperties.getProperty("browser"), configpproperties.getProperty("url"));
		CommonMethods.login(configpproperties.getProperty("username"), configpproperties.getProperty("password"));
		navigate_to_companies_page();
		navigate_to_New_companies_page();

		String datafilepath = "E:\\SeleniumJava\\CogmentoAutomation\\newdata\\anil.xlsx";
		String sheetname = "sheet1";
		HashMap<String, String> tcData = ExcelUtil.getData(datafilepath, sheetname, "TC_1");
		String companyname = companies.createcompany(tcData);
		navigate_to_companies_page();
		companies.createcompany(tcData);
		// String companyname="anil";
		// companies.verifyCompanyExists(companyname);

	}

	public static void navigate_to_companies_page() {

		EventMethods.click_button(By.xpath("//span[text()='Companies']"), "click on companies");
		boolean ele = EventMethods.Verify_element_exists(By.xpath("//div[text()='Companies']"));
		if (ele) {
			System.out.println("Application is navigated to companies page");
		} else {
			System.out.println("Application is not navigated to companies page");
		}
	}

	public static void navigate_to_New_companies_page() {
		Data.driver.findElement(By.xpath("//span[text()='Companies']")).click();
		Data.driver.findElement(By.xpath("//button[text()='New']")).click();
		boolean ele = EventMethods.Verify_element_exists(By.xpath("//div[text()='Create new Company']"));

		if (ele) {
			System.out.println("Application is  navigated to new companies page");
		} else {
			System.out.println("Application is not navigated to new companies page");
		}

	}

}
