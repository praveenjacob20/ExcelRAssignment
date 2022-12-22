package selenium.module2;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class assignment2 {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		  driver.get("https://demo.guru99.com/test/delete_customer.php");
		  driver.findElement(By.name("cusid")).sendKeys("123456"); 
		  Thread.sleep(3000);
		  driver.findElement(By.name("submit")).click();
		  Thread.sleep(3000);
		  driver.switchTo().alert().accept();
		  Thread.sleep(3000);
		  driver.switchTo().alert().accept(); 
		  Thread.sleep(3000);
		 
		  driver.quit();
	
	}
}
