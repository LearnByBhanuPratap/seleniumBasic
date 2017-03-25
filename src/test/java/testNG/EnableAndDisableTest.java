package testNG;

import org.testng.annotations.Test;

public class EnableAndDisableTest {
	
	@Test(enabled=true, description="I am login test with valid data")
	public void test(){
		System.out.println("test()");
	}
	
	@Test(enabled=false ,description="I am login test with valid data")
    public void test1(){
		System.out.println("test1()");
	}

}
