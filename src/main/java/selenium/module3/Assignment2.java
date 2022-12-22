package selenium.module3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2 {
	
	WebDriver driver;
	
	@BeforeMethod
	public void initializitation() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/login.html");
	}
	
	
	@Test(dataProvider = "getLoginData")
	public void Login(Object da, Object ta) {
		driver.findElement(By.id("email")).sendKeys((CharSequence[]) da);
		driver.findElement(By.id("passwd")).sendKeys((CharSequence[]) ta);
		driver.findElement(By.id("SubmitLogin")).click();
	}
	
	
	@DataProvider
	public Object[][] getLoginData() {
		Object[][] data = new Object[3][2];
		data[0][0] = "admin";
		data[0][1] = "admin123";
		
		return data;
	}
	
	
	@AfterMethod
	public void close() {
		driver.quit();
	}

}
