package Module3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assig3 {

	WebDriver driver;
	
	@Test
	public void TC1() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test(groups = "smoke")
	private void TC2() {
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[2]/div")).click();
	}
	
	@Test(groups = "regression")
	private void TC3() throws InterruptedException {
		driver.findElement(By.id("firstName")).sendKeys("Bruce");
		driver.findElement(By.id("lastName")).sendKeys("Mathers");
		driver.findElement(By.xpath("//*[@id=\"userEmail\"]")).sendKeys("bruce.mathers@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[1]/label")).click();
		driver.findElement(By.xpath("//*[@id=\"userNumber\"]")).sendKeys("6363639876");
		driver.findElement(By.xpath("//*[@id=\"currentAddress\"]")).sendKeys("Karnataka, India");
		Thread.sleep(5000);
		driver.findElement(By.id("submit")).click();
	}
	@Test
	public void TC4() {
		driver.quit();
	}
	
}
