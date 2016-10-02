package selenium;

public class ExcelReport {

	
	public void generateExcelReport(){
		
		String path = ExcelReport.class.getClassLoader().getResource("./").getPath();
		path = path.replaceAll("bin", "src");
	}
}
