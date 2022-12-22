package selenium.module2;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3 {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/");
		WebElement drag = driver.findElement(By.xpath("//*[@id=\"sidebar\"]/aside[1]/ul/li[1]/a"));
		Thread.sleep(3000);
		drag.click();
		WebElement frame = driver.findElement(By.xpath("//iframe"));
		driver.switchTo().frame(frame);
		WebElement draggable = driver.findElement(By.id("draggable"));
		Actions act = new Actions(driver);
		act.dragAndDropBy(draggable, 150, 200).build().perform();
		
		TakesScreenshot ssc = (TakesScreenshot)driver;
		  File file = ssc.getScreenshotAs(OutputType.FILE);
			 String fileName = "./Screenshot/" + "filename"+".png"; 
			 try {
				 FileUtils.copyFile(file, new File(fileName));
				 } 
			 catch (IOException e) 
			 {
				 //TODO Auto-generated catch block 
				 e.printStackTrace(); 
			 		}
		
	}

}
