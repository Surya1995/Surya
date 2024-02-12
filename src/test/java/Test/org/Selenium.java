package Test.org;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Selenium {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Kanmani\\eclipse-workspace\\TestAutomation_QA\\driver\\chromedriver.exe");
	    @SuppressWarnings("unused")
		WebDriver driver=new ChromeDriver();
	    driver.get("https://www.flipkart.com/");
	}

}
