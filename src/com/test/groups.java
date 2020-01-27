package com.test;

import org.testng.annotations.Test;

public class groups {
	
	@Test(groups = "admin")
	public void testmethod1() {
		System.out.println("i am in test meethod1");
	}
	
	@Test(groups = "rep")
	public void testmethod2() {
		System.out.println("i am in test meethod2");
	}
	
	@Test(groups = {"manager","admin"})
	public void testmethod3() {
		System.out.println("i am in test meethod3");
	}
	@Test(groups = "rep")
	public void testmethod4() {
		System.out.println("i am in test meethod4");
	}
	
	@Test(groups = "admin")
	public void testmethod5() {
		System.out.println("i am in test meethod5");
	}
	
	@Test(groups = "annonymous")
	public void testmethod6() {
		System.out.println("i am in test meethod6");
	}
	
	@Test(groups = "manager")		 
	public void testmethod7() {
		System.out.println("i am in test meethod7");
	}
	
	@Test(groups = "annonymous")
	public void testmethod8() {
		System.out.println("i am in test meethod8");
	}
	
	@Test(groups = "admin")
	public void testmethod9() {
		System.out.println("i am in test meethod9");
	}
	
	@Test(groups = "admin")  
	public void testmethod10() {
		System.out.println("i am in test meethod10");
	}
	
	@Test(groups = "rep")   //rep >> reprasentative
	public void testmethod11() {
		System.out.println("i am in test meethod11");
	}
	
	

}
