package Test.org;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.read.biff.File;
import net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForField.Read;

public class StockValidation {
	public static HashMap<String, String> sharePriceExcel;
	public static HashMap<String, String> sharePriceExcelValue;
	
	public static void main(String[] args) throws BiffException, IOException {
		String filename = "C:\\Users\\Kanmani\\eclipse-workspace\\TestAutomation_QA\\Input File\\SharePriceList.xls";
		sharePriceExcelValue=readXLSFile(filename);
		sharePriceExcel = readData();

		String expected =sharePriceExcelValue.get("Quess corp");
		String actual=sharePriceExcel.get("Quess corp");
		if(actual.equals(expected)) {
			System.out.println("Passed");				
		}else
		{
			System.out.println("Failed");
		}
		Set<String> keylist=sharePriceExcelValue.keySet();
		for(String key:keylist) {
			System.out.println(key);
			if(sharePriceExcelValue.get(key).equals(sharePriceExcel.get(key))) {
				System.out.println("Key value passed" +key);
			}else {
				System.out.println("Failed" +key);
			}
		}
	}
	public static HashMap<String, String> readData(){
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Kanmani\\eclipse-workspace\\TestAutomation_QA\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://money.rediff.com/losers/bse/daily/groupa?src=gain_lose");
		List<WebElement> currentPriceList = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[4]"));
		List<WebElement> companyList = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[1]"));
		System.out.println(currentPriceList.size());
		HashMap<String,String> sharePriceExcel=new HashMap<String,String>();
		for(int i=0; i<currentPriceList.size(); i++) {
			System.out.println("Key :" +companyList.get(i).getText().trim() + "Value:" +currentPriceList.get(i).getText().trim() );
			sharePriceExcel.put(companyList.get(i).getText().trim(), currentPriceList.get(i).getText().trim());
			
		}
		return sharePriceExcel;
	}
	
	public static HashMap<String, String> readXLSFile(String filename) throws IOException, BiffException {
		HashMap<String,String> SharePriceExcelValue= new HashMap<String,String>();
	
		FileInputStream fis=new FileInputStream(filename);
		Workbook w=Workbook.getWorkbook(fis);
		Sheet sheet=w.getSheet(0);
		int rows=sheet.getRows();
		
		for (int i=0;i<rows;i++) {
			Cell cell=sheet.getCell(0,i);
			String key=cell.getContents();
			cell=sheet.getCell(1,i);
			String value=cell.getContents();
			System.out.println("key:" +key);
			System.out.println("value:" +value);
			SharePriceExcelValue.put(key, value);
			System.out.println();
			
			
		}
		
		return SharePriceExcelValue;	
}
}