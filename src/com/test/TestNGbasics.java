package com.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGbasics {
	
//pre-conditions annotations---starting with @Before	
@BeforeSuite    
public void setup() {
	System.out.println("setup system property for chrome");
}
@BeforeClass
public void launchBrowser() {
	System.out.println("launch chrome browser");  
}
@BeforeTest
public void login() {
	System.out.println("login to app");
}
@BeforeMethod
public void enterurl() {
	System.out.println("enter url");
}

//test cases----starting with @Test
@Test
public void gooogletitletest() {
	System.out.println("google  title  test");
}
@Test
public void searchTest() {
	System.out.println("search test");
}

//post-conditions ---starting with @After
@AfterMethod
public void logout() {
	System.out.println("logout from app");
}
@AfterTest
public void deleteallcookies() {
	System.out.println("delete all cookies");
}
@AfterClass
public void closebrowser() {
	System.out.println("close browser");
}
@AfterSuite
public void generateTestReport() {
	System.out.println("generate test report");
}
	
	
	
	
	

}
