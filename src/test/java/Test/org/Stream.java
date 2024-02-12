package Test.org;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Stream {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Kanmani\\eclipse-workspace\\TestAutomation_QA\\driver\\chromedriver.exe");
    WebDriver driver=new ChromeDriver();
    driver.get("https://www.flipkart.com/");
    List<WebElement> x = driver.findElements(By.tagName("a"));
    System.out.println("Links are");
    List<String> allLink=x.stream().map(link->link.getAttribute("href")).collect(Collectors.toList());
    //Print All links
    allLink.forEach(System.out::println);

}
}
