package Tests;

import org.testng.annotations.Test;

public class testclass1 {
	 
	 @Test
	public  void testcase1() {
		System.out.println("i am in testclass1");
	}
	 @Test(enabled = false)
	public  void testcase2() {
		System.out.println("i am in testclass2");
	} 
	 @Test
	public  void testcase3() {
		System.out.println("i am in testclass3");
	}
	 @Test
	public static void testcase4() {
		System.out.println("i am in testclass4");
	}
}
