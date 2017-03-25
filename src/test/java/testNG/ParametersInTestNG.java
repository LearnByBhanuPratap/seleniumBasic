package testNG;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersInTestNG {
	
	@Test
	@Parameters({"userName","password"})
	public void testLogin(@Optional("userNameOptional") String userName,@Optional("passwordOptional") String password){
		System.out.println("userName is:-"+userName+" passowrd:-"+password);
	}

}
