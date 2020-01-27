package framework;

public class test2 {

	public static void main(String[] args) {
		test1 d = new test1();
		d.launchApplication("chrome", "https://www.makemytrip.com");
		d.getdriver();
		System.out.println(d.getdriver());
		System.out.println();
	}

}
