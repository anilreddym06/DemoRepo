package framework;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EventMethods {
	
  public static void enter_value_in_text_field(By locator,String input,String stepname ) {
	  try {
		  highlightElement(Data.driver.findElement(locator));
	  Data.driver.findElement(locator).sendKeys(input);
	  }catch(NoSuchElementException nse) {   //click on selenium exception here
		  System.out.println(stepname+ ";unable to enter the value as the elemenyt could not found. exception info: "+nse.getMessage());
		  System.exit(0);
	  }catch(ElementNotInteractableException eie) {
		  System.out.println(stepname+ "; unable to enter the value as element either element not visible or disabled. exception info: "+eie.getMessage());
		  System.exit(0);
	  }catch(InvalidArgumentException iae) {
		  System.out.println(stepname+ ";unable to enter the value as the input given is null.");
	  }
  }
  
  
  
  public static void click_button(By locator,String stepname) {
	  try {
		  highlightElement(Data.driver.findElement(locator));
	  Data.driver.findElement(locator).click();
	  }catch(NoSuchElementException nse) {   //click on org.openqa.selenium.NoSuchElementException here//
		  System.out.println(stepname+ ";unable to enter the value as the element could not found. exception info: "+nse.getMessage());
		  System.exit(0);
	  }catch(ElementNotInteractableException eie) {
		  System.out.println(stepname+ "; unable to enter the value as element either element not visible or disabled. exception info: "+eie.getMessage());
		  System.exit(0);
	  }
  }
  
  
  public static boolean Verify_element_exists(By locator) {
	  try {
		  highlightElement(Data.driver.findElement(locator));
	  Data.driver.findElement(locator);
	  return true;
  }catch(NoSuchElementException nse) { 
	  return false;
  }

  }
  public static boolean Verify_element_exists(By locator,int timeout) {
	  try {
		  WebDriverWait wait =new WebDriverWait(Data.driver, timeout);
		  wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		  wait.pollingEvery(Duration.ofMillis(200));
		  return true;
	  }catch(Exception e) {
		  return false;
	  }
		  
	  
  }
  
  public static void highlightElement(WebElement element) {
	  JavascriptExecutor jse=(JavascriptExecutor)Data.driver;
	  jse.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", element);
  }
  
 
  }

