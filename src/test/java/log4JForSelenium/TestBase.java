package log4JForSelenium;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeTest;

public class TestBase {
	private static final Logger logger = Logger.getLogger(TestBase.class.getName());
	
	@BeforeTest
	public void loadlog4J(){
		String log4jConfPath = System.getProperty("user.dir")+"/src/test/java/log4JForSelenium/log4J.properties";
		PropertyConfigurator.configure(log4jConfPath);
	}

}
