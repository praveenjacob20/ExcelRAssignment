package Module4;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Assig2 {
	
WebDriver driver;
	@BeforeMethod
	public void initializitation() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://itechnotion.com/what-will-be-the-cost-of-an-app-like-justdial-its-indias-no-1-local-business-directory/");	
	}
	
	@Test
	public void TestCase1() throws IOException, InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//*[@id=\"menu-item-5974\"]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"menu-item-5978\"]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"navigation\"]/ul/li[2]/a")).click();
		WebElement features = driver.findElement(By.xpath("//*[@id=\"nfeatures\"]/div/div[2]/div[2]"));
		String feat = features.getText();
		System.out.println(feat);
		Thread.sleep(3000);
		System.out.println();
		driver.findElement(By.xpath("//*[@id=\"navigation\"]/ul/li[3]/a")).click();
		WebElement Technology = driver.findElement(By.xpath("/html/body/section[3]/div/div[4]/div[1]/div"));
		String Tech = Technology.getText();
		System.out.println(Tech);
		Thread.sleep(3000);
		
		
		driver.findElement(By.xpath("//*[@id=\"topnav\"]/div/div[2]/a")).click();
		String filepath = "./src/test/java/Module4/Details.xlsx";
		XSSFWorkbook workbook = new XSSFWorkbook(filepath);
		XSSFSheet sheet = workbook.getSheet("data");
		WebElement iframe = driver.findElement(By.xpath("//iframe[@title='Form 0']"));
		driver.switchTo().frame(iframe);
		driver.findElement(By.xpath("//*[@id=\"firstname-e83e7559-32cd-4d21-8fe5-970edce9bc8e\"]")).sendKeys(sheet.getRow(0).getCell(0).getStringCellValue());
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(sheet.getRow(0).getCell(1).getStringCellValue());
		driver.findElement(By.xpath("//input[@name='country']")).sendKeys(sheet.getRow(0).getCell(2).getStringCellValue());
		driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys(sheet.getRow(0).getCell(3).getStringCellValue());
		driver.findElement(By.xpath("//*[@id=\"hsForm_e83e7559-32cd-4d21-8fe5-970edce9bc8e\"]/div[5]/div/ul/li[1]/label/span")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(5000);
		workbook.close();
	}
	
	@AfterMethod
	public void close() {
		driver.quit();
	}
}
