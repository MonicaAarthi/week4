package week4.day2;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TextChangeWait {

	public static void main(String[] args) {
		
		 WebDriverManager.chromedriver().setup();
			
			ChromeDriver driver = new ChromeDriver();
			
			driver.get("http://www.leafground.com/pages/TextChange.html");
			
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			WebElement fe1 = driver.findElement(By.id("btn"));
			
	        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	      
	        wait.until(ExpectedConditions.visibilityOf(fe1)).click();
	        
	        Alert alert = driver.switchTo().alert();
	        
	        String text = alert.getText();
	        
	        System.out.println(text);
	        
	        alert.accept();
		

	}

}
