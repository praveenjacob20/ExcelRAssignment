package selenium.module1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class assignment_1 {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		
		driver.get("https://www.facebook.com/");
		
		String exptitle = "Facebook – log in or sign up";
		String Pagetitle = driver.getTitle();
		
		System.out.println(Pagetitle);
		
		if(exptitle.equals(Pagetitle)) {
			System.out.println("TC PASSES");
		}else {
				System.out.println("TC FAILED");
			}
		Thread.sleep(3000);
		
		
		driver.navigate().back();
		Thread.sleep(3000);
		driver.navigate().forward();
		Thread.sleep(3000);
		driver.quit();
	}

}
