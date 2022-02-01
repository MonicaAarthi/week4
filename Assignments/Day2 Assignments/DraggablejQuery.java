package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DraggablejQuery {

	public static void main(String[] args) {
		
		    WebDriverManager.chromedriver().setup();
		 
		    ChromeDriver driver = new ChromeDriver();
			
			driver.get("https://jqueryui.com/draggable/");
			
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
		   Actions builder = new Actions(driver);	
			
		   driver.findElement(By.linkText("Draggable")).click();
		   
		   driver.switchTo().frame(0);
		    
		   WebElement fe = driver.findElement(By.id("draggable"));
		   
		   builder.dragAndDropBy(fe, 100, 80).perform();
			

	}

}
