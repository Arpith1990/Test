import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PlayAround {

	public static void main(String[] args) {
	

		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		
		//WebDriver driver = new ChromeDriver();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.redbus.in");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		//driver.findElement(By.name("flight_origin_date")).click();
		driver.findElement(By.id("src")).sendKeys("BENG");	
		
		driver.findElement(By.id("src")).sendKeys(Keys.DOWN);
		driver.findElement(By.id("src")).sendKeys(Keys.DOWN);
		//List<WebElement> list =driver.findElements(By.xpath("//ul[@class='autoFill']//li"));
		//System.out.println(list.size());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
