package testNG;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GroupTest {
	
	@BeforeClass(groups={"sanity","regression","database"})
	public void setUP(){
		System.out.println("setUP()");
	}
	
	@Test(groups={"sanity","regression"})
	public void test1(){
		System.out.println("(groups={sanity,regression})");
	}
	@Test(groups={"sanity","database"})
	public void test2(){
		System.out.println("(groups={sanity,database})");
	}
	@Test(groups={"sanity"})
	public void test3(){
		System.out.println("(groups={sanity})");
	}
	@Test(groups={"regression"})
	public void test4(){
		System.out.println("(groups={regression}");
	}

}
