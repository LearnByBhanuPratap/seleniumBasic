package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;



public class DependsOnTest {
	
	@Test
	public void login(){
		System.out.println("(groups={sanity,regression})");
		//Assert.assertTrue(false);
	}
	@Test(dependsOnMethods={"login","logout"})
	public void test2(){
		System.out.println("(groups={sanity,database})");
	}
	
	@Test(dependsOnMethods={"login"})
	public void logout(){
		System.out.println("(groups={sanity,regression})");
		Assert.assertTrue(false);
	}

}
