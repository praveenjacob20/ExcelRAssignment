package selenium.module2;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class assignment1 {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();		
		driver.get("https://demo.guru99.com/test/web-table-element.php");
		WebElement table = driver.findElement(By.xpath("//table[@class='dataTable']"));
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='dataTable']//tr"));
		//System.out.println(rows.size());

		String col1 = "//table[@class='dataTable']//tr[";
		String col2 = "]//td[1]";
		
		List<WebElement> column;
		for(int i=1; i<rows.size(); i++) {
			
			column = table.findElements(By.xpath(col1+i+col2));
				
				System.out.println(column.get(0).getText());
				
				}
		 
		driver.get("https://demo.guru99.com/test/login.html");
		driver.findElement(By.id("email")).sendKeys("Test");
		driver.findElement(By.id("passwd")).sendKeys("Test1234");
		driver.findElement(By.id("SubmitLogin")).click();
		Thread.sleep(5000);
		
		driver.quit();
		
	}

}
