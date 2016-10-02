package selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ExcelReport {
	public static int  rowNumber = 0;

	@SuppressWarnings("null")
	public void generateExcelReport() throws ParserConfigurationException, SAXException, IOException {
		// create new file
		String startDateTime = new SimpleDateFormat("MM-dd-yyyy_HH-ss").format(new GregorianCalendar().getTime());
		
		String path = System.getProperty("user.dir")+"//src//test//java//report//"+startDateTime+".xls";
		

        
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = null;


		File file = new File(System.getProperty("user.dir") + "//test-output//testng-results.xml");

		DocumentBuilderFactory docuemntFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = docuemntFactory.newDocumentBuilder();
		Document parsedFile = builder.parse(file);
		parsedFile.getDocumentElement().normalize();

		
		NodeList testData = parsedFile.getElementsByTagName("test");
		for (int i = 0; i < testData.getLength(); i++) {
			int  rowNumber = 0;
			Node xmlNode = testData.item(i);
			String testName = ((Element) xmlNode).getAttribute("name");
			System.out.println("testName is:-"+testName);
			System.out.println(workbook.getSheetIndex(testName));
			if(workbook.getSheetIndex(testName) ==-1){
				workbook.createSheet(testName);
	            sheet = workbook.getSheet(testName);	
			}

			NodeList totalClass = ((Element) xmlNode).getElementsByTagName("class");
			for (int j = 0; j < totalClass.getLength(); j++) {

				Node classNode = totalClass.item(j);
				String className = ((Element) classNode).getAttribute("name");
				NodeList methodNameList = ((Element) classNode).getElementsByTagName("test-method");

				for (int k = 0; k < methodNameList.getLength(); k++) {
					Node methodNode = methodNameList.item(k);
					String methodName = ((Element) methodNode).getAttribute("name");
					String methodStatus = ((Element) methodNode).getAttribute("status");
					HSSFRow row = sheet.createRow(rowNumber++);
					HSSFCell cell = row.createCell(0);
					cell.setCellValue(className+"-"+methodName);
					
					cell = row.createCell(1);
					cell.setCellValue(methodStatus);
					
					HSSFCell cellException;
					String exceptionMsg;
					if("fail".equalsIgnoreCase(methodStatus)){
						NodeList exception = ((Element) methodNode).getElementsByTagName("exception");
						Node exceptionNode = exception.item(0);
						exceptionMsg = ((Element) exceptionNode).getAttribute("class");
						cellException = row.createCell(2);
						cellException.setCellValue(exceptionMsg);
					}
				}
			}

		}
        FileOutputStream stream = new FileOutputStream(path);
        workbook.write(stream);
        stream.close();
	}
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		ExcelReport obj = new ExcelReport();
		obj.generateExcelReport();
	}
}
