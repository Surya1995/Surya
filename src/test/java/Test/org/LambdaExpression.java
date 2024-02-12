package Test.org;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LambdaExpression {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Kanmani\\eclipse-workspace\\TestAutomation_QA\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		List<WebElement> x = driver.findElements(By.tagName("a"));
		x.forEach(linkall -> System.out.println("Links are" + linkall.getAttribute("href")));
		

	}
}
