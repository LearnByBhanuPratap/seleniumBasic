package log4JForSelenium;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class TestLog4J extends TestBase{
	
	private static final Logger logger = Logger.getLogger(TestLog4J.class.getName());
	
	@Test
	public void testLogin(){
		logger.info("staring login test");
		logger.info("clicked on sign in button");
		logger.info("enter user name");
		logger.info("enter password");
		logger.info("click on submit button");
	}

}
