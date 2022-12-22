package selenium.module2;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2_2 {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
driver.get("http://demo.guru99.com/popup.php");
		
		String Parentwindow = driver.getWindowHandle();
		System.out.println("Parent Window ID ==> " + Parentwindow);
		System.out.println(driver.getTitle());
		System.out.println("");
		driver.findElement(By.xpath("//a[@target='_blank']")).click();
		Thread.sleep(3000);
		
		Set<String> allHandles = driver.getWindowHandles();
		System.out.println(allHandles);
		System.out.println("");
		String ChildWindow = null;
		for(String abc : allHandles ) {
			if(!(abc.equals(Parentwindow)));
			ChildWindow = abc;
		}
		System.out.println("Chind window ID ==> " + ChildWindow);
		driver.switchTo().window(ChildWindow);
		System.out.println(driver.getTitle());
		
		driver.findElement(By.name("emailid")).sendKeys("test@mail.com");
		driver.findElement(By.name("btnLogin")).click();	
		
		Thread.sleep(3000);
		
		driver.quit();
		
	}

}
