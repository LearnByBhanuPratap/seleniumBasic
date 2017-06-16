package seleniumExamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Example1 {
	
	@Test
	public void testLogin(){
		//System.out.println("testLogin() is pass");
		Assert.assertTrue(false, "testLogin() is pass");
	}
	
	@Test
	public void testLogin1(){
		System.out.println("testLogin() is pass");
		Assert.assertTrue(true, "testLogin() is pass");
	}
}
