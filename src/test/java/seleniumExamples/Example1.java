package seleniumExamples;

import org.testng.annotations.Test;
import org.testng.Assert;


public class Example1 {
	
	@Test
	public void testLogin(){
		//System.out.println("testLogin() is pass");
		Assert.assertTrue(false, "testLogin() is pass");
	}
	
	@Test
	public void testLogin1(){
		System.out.println("testLogin1() is pass");
		Assert.assertTrue(true, "testLogin() is pass");
	}
}
