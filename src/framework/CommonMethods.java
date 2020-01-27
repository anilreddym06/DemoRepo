//In common methods we doing the validation//
package framework;

import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CommonMethods {
	public static void launchApplication(String browser,String url) {
		try {
		switch (browser.toLowerCase().trim()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver",Data.CHROME_DRIVER_PATH);
			 Data.driver=new ChromeDriver();
			 break;
		case"firefox":
			System.setProperty("Webdriver.chrome.driver",Data.CHROME_DRIVER_PATH);
			Data.driver=new FirefoxDriver();
			break;
		case"edge":
			System.setProperty("Webdriver.chrome.driver",Data.EDGE_DRIVER_PATH);
			Data.driver=new EdgeDriver();
			break;
		default:
			System.out.println("given browser : "+browser+ "is invalid. please give either chrome or firefox or edge browsers");
			System.exit(0);
			break;
	}
		Data.driver.get(url);
		Data.driver.manage().window().maximize();
		Data.driver.manage().timeouts().implicitlyWait(Data.IMPLICT_TIME_OUT, TimeUnit.SECONDS);
		}catch( IllegalStateException |SessionNotCreatedException ise) {
			System.out.println("unable  to launch the browser as exception hasbeen found. Exception info:"+ise.getMessage());
		}
	}
	
	
	public static void login(String username,String password) {
		
		EventMethods.enter_value_in_text_field(By.xpath("//input[@name='email']"),username, "Enter username");
		EventMethods.enter_value_in_text_field(By.xpath("//input[@name='password']"), password, "enter password");
		EventMethods.click_button(By.xpath("//div[text()='Login']"), "Click on Login button");
		if(EventMethods.Verify_element_exists(By.xpath("//span[text()='Home']"))) {
		System.out.println("Login is successfully navigated to home page.");
		}else {
			System.out.println("Login is not successfully navigated to home page.");
			System.exit(0);
		}
		
		
		
		
		
	}
	public static void SelectFutureDateFromCalendar(Date dt){
		HashMap<String, String> dateparts=UtilityMethods.getDateparts(dt);
		String monthyear=dateparts.get("MONTH_NAME")+" "+dateparts.get("YEAR");
		while(true) {
			boolean ismonthyearexist=EventMethods.Verify_element_exists(By.xpath("//div[text()='"+monthyear+"']"),1);
			if( ismonthyearexist) {
				//here we writing dynamic xpath why because if you give month name august or september or anything for every month name xpath will change if you give day number 2 or 3 or 7 or...anything for every number xpath will change 
				String xpath="//div[text()='"+dateparts.get("MONTH_NAME")+"']/following::p[text()='"+dateparts.get("DAY_NUMBER")+"']";
				break;
			}else {
				EventMethods.click_button(By.xpath("//span[@role='button' and @aria-label='Next Month'] "), "click on next button");
				
			}
		}
		

		}	
	
	
	
	
	

		
		
		/*try {
			Data.driver.findElement(By.name("email"));
			System.out.println("Application is successfully launched and Navigated to login page");
			
		}catch(NoSuchElementException e) {
			System.out.println("Application is not navigated to login page");
			System.exit(0);
		}
		
		
		}
	/*public static void login(String username,String password) {
		Data.driver.findElement(By.name("email")).sendKeys(username);
		Data.driver.findElement(By.name("password")).sendKeys(password);
		Data.driver.findElement(By.xpath("//div[text()='Login']")).click();
		
		try {
			Data.driver.findElement(By.xpath("))
			System.out.println("Login is success and Application is navigated to login page.");
		}catch(NoSuchElementException e) {
			System.out.println("Login is not success.");
			System.exit(0);
		}
	}
	/*public static void CaptureScreenShot(String imagename) {
    	String imagepath=System.getProperty("user.dir")+"\\Screenshots\\"+imagename+".png";
    	TakesScreenshot ts=(TakesScreenshot) Data.driver;
             File image=ts.getScreenshotAs(OutputType.FILE);
             File dest=new File(imagepath);
             try {
				Files.move(image, dest);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
             
public static void selectCountryFromList(By locatorforlist,By locatorforcountry) {
	  EventMethods.click_button(locatorforlist,"click on country list to populate countries");
	  EventMethods.click_button(locatorforcountry,"click on country list to populate countries");  
}


}

