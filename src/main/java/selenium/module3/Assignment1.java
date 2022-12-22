package selenium.module3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1 {

	WebDriver driver;
	
	@BeforeMethod
	public void initializitation() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/login.html");
	}
	
	
	@Test
	public void Login() {
		driver.findElement(By.id("email")).sendKeys("test");
		driver.findElement(By.id("passwd")).sendKeys("1234");
		driver.findElement(By.id("SubmitLogin")).click();
	}
	
	
	@AfterMethod
	public void close() {
		driver.quit();
	}

}
