package modules;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;

import framework.CommonMethods;
import framework.Data;
import framework.EventMethods;
import framework.UtilityMethods;

public class companies {
	public static String createcompany(HashMap<String, String> tcData) throws IOException {
		String companyName = tcData.get("COMPANY_NAME") + UtilityMethods.getCurrentTimeStamp();
		EventMethods.enter_value_in_text_field(
				By.xpath("//label[text()='Name']//following::div/descendant::input[@name='name']"), companyName,
				"Entering company name");
		companies.clickAccessButton(tcData.get("ACCESS_LEVEL"));
		EventMethods.enter_value_in_text_field(By.xpath("//label[text()='Website']/following::div/descendant::input"),
				tcData.get("WEBSITE"), "enter website");
		EventMethods.enter_value_in_text_field(
				By.xpath("//label[text()='Address']/following::div/descendant::input[@name='address']"),
				tcData.get("ADDRESS"), "enter endress");
		EventMethods.enter_value_in_text_field(By.xpath("//input[@name='city']"), tcData.get("CITY"), "enter city");
		EventMethods.enter_value_in_text_field(By.xpath("//input[@name='state']"), tcData.get("STATE"), "enter state");
		EventMethods.enter_value_in_text_field(By.xpath("//input[@name='zip']"),
				UtilityMethods.formatnumber(tcData.get("POSTAL_CODE")), "Enter POSTAL_CODE");
		CommonMethods.selectCountryFromList(By.xpath("//div[text()='Country']"),
				By.xpath("//span[text()='" + tcData.get("COUNTRY") + "']"));
		// in the above code first locator it will click on country once it will click
		// on country then it will show options which country you want to select in that
		// case second locator will select one of the option and next it will click on
		// that option//
		CommonMethods.selectCountryFromList(By.xpath("//div[text()='United States']/parent::div[@role='combobox']"),
				By.xpath("(//span[text()='" + tcData.get("COUNTRY") + "'])[2]"));
		// in the above code first locator it will click on United States once it will
		// click on United States then it will show options which country you want to
		// select in that case second locator will select one of the option and next it
		// will click on that option here second locator xpath is
		// >>>(//span[text()='India'])[2] >>>>//
		EventMethods.enter_value_in_text_field(By.xpath("//input[@placeholder='Number']"),
				UtilityMethods.formatLongNumber(tcData.get("PHONE")), "Enter the phone number");
		EventMethods.click_button(By.xpath("//input[@name='image']"), "Uploading the image");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

		}
		Runtime.getRuntime().exec("E:\\SeleniumJava\\CogmentoAutomation\\Autoscript\\FileuploadScript.exe");
		// EventMethods.click_button(By.xpath("//i[@class='save icon']"),
		// "click on save button after entering company info");
		boolean element = EventMethods.Verify_element_exists(By.xpath("//div[text()='" + companyName + "']"));
		if (element) {
			System.out.println("company created successfully");
		} else {
			System.out.println("company created successfully");
		}
		return companyName;

	}

	public static void verifyCompanyExists(String companyname) {
		while (true) {
			if (EventMethods.Verify_element_exists(By.xpath("//td[text()='" + companyname + "']"))) {
				System.out.println("Company: " + companyname + " is found");
				break;
			} else {
				String rightlinktext = Data.driver.findElement(By.xpath("//a[@class='icon item disabled']"))
						.getAttribute("class");

				if (rightlinktext.endsWith("disabled")) {
					System.out.println(
							"company : " + companyname + "is  not found even after searching till last page. ");
					break;
				} else {
					EventMethods.click_button(By.xpath("//i[contains(@class,'right')]/parent::a"),
							"click right arrow for next page");
				}

			}
		}
	}

	public static void clickAccessButton(String selectAccesslevel) {
		String buttontext = Data.driver.findElement(By.xpath(
				"//label[text()='Access']/following::div/descendant::button[@class='ui small fluid positive toggle button']"))
				.getText();
		switch (selectAccesslevel.toLowerCase()) {
		case "public":
			if (buttontext.contains("Private")) { // when you call contains method it is case sensitive so you need to
													// check the element weather the element contains any small letters
													// or capital letters in the starting or in the middle or in the end
													// so you need to check every letter when you calling contains
													// method//
				EventMethods.click_button(By.xpath(
						"//label[text()='Access']/following::div/descendant::button[@class='ui small fluid positive toggle button']"),
						"click on access button");
			}
			break;

		default:
			if (buttontext.contains("Public")) {
				EventMethods.click_button(By.xpath(
						"//label[text()='Access']/following::div/descendant::button[@class='ui small fluid positive toggle button']"),
						"click on access button");
			}
			break;
		}
	}
}
