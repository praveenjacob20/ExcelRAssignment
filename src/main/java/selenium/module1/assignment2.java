package selenium.module1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class assignment2 {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.guru99.com/test/radio.html");
		driver.findElement(By.xpath("//input[@value='Option 1']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='checkbox2']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='checkbox3']")).click();
		Thread.sleep(3000); 
		
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		
		WebElement dropdown = driver.findElement(By.name("country"));
		Select SC = new Select(dropdown);
		
		SC.selectByVisibleText("KUWAIT");
		
		Thread.sleep(3000); 
		
		driver.quit();

	}
}
