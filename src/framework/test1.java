package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class test1 {
	public static void main(String[] args) {

	}

	private WebDriver driver;

	public void launchApplication(String browser, String url) {

		switch (browser.toLowerCase().trim()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", Data.CHROME_DRIVER_PATH);
			this.driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("Webdriver.chrome.driver", Data.CHROME_DRIVER_PATH);
			this.driver = new FirefoxDriver();
			break;
		case "edge":
			System.setProperty("Webdriver.chrome.driver", Data.EDGE_DRIVER_PATH);
			this.driver = new EdgeDriver();
			break;
		default:
			System.out.println(
					"given browser : " + browser + "is invalid. please give either chrome or firefox or edge browsers");
			System.exit(0);
			break;
		}
		this.driver.get(url);

	}

	public WebDriver getdriver() {
		return this.driver;
	}

}
