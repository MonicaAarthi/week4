package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHover {

	public static void main(String[] args) throws InterruptedException {
		    
		    WebDriverManager.chromedriver().setup();
		   
		    //to handle notifications in websites
		    ChromeOptions options = new ChromeOptions();
		    options.addArguments("--disable-notifications");
		    
		    
			ChromeDriver driver = new ChromeDriver(options);
			
			driver.get(" https://www.snapdeal.com/");
			
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
			Actions builder = new Actions(driver);
			
			WebElement men = driver.findElement(By.xpath("//span[text()=\"Men's Fashion\"]"));
			
			WebElement shirts = driver.findElement(By.xpath("//span[text()='Shirts']"));
			
			builder.moveToElement(men).pause(1000).click(shirts).perform();
			
			WebElement firstEle = driver.findElement(By.xpath("//div[@class='product-tuple-image ']"));
			
			builder.moveToElement(firstEle).perform();
			
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//div[contains(text(),'Quick View')]")).click();
			
			driver.close();	

	}

}
