package framework;

import org.openqa.selenium.WebDriver;

public class Data {
	public static WebDriver driver;
	public static final String PROJECT_FOLDER_PATH = System.getProperty("user.dir");
	public static final String CHROME_DRIVER_PATH = PROJECT_FOLDER_PATH + "\\Drivers\\chromedriver.exe";
	public static final String EDGE_DRIVER_PATH = PROJECT_FOLDER_PATH + "\\Drivers\\MicrosoftWebDriver.exe";
	public static final int IMPLICT_TIME_OUT = 20;

}
