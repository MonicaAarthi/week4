package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SortablejQuery {

	public static void main(String[] args) {
		
        WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://jqueryui.com/sortable/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Actions builder = new Actions(driver);
		
		driver.switchTo().frame(0);
		
		WebElement fe1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
		
		WebElement fe2 = driver.findElement(By.xpath("//li[text()='Item 5']"));
		
		//get location of fe1
		Point l1 = fe2.getLocation();
		
		//get x co-ordinate of l1
		int x = l1.getX();
		
		//get xco-ordinate of l2
		int y = l1.getY();
			
		//drag and drop fe1 to fe2
		builder.clickAndHold(fe1).moveByOffset(x, y).perform();
		
		
	}

}
