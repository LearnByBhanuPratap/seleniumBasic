package selenium.questionsAndAnswers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class Series7 {

	/**
	 How to work with properties file
	 What are the java script function for selenium object location
	 * @throws IOException 
	 */
	
	public static void main(String[] args) throws IOException {
	Properties OR = new Properties();
	File file = new File(System.getProperty("user.dir")+"/src/test/java/selenium/questionsAndAnswers/or.properties");
	FileInputStream input = new  FileInputStream(file);
	OR.load(input);
	System.out.println(OR.getProperty("userName"));
	
	//following-sibling
	//preceding-sibling
	//starts-with()
	//ends-with()
	//following
	//preceding
	// contains
	
	//nth-child(1)
	//$ (starts-with)
	//^ (ends with)
	}
}
