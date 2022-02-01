package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selectable {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get(" http://www.leafground.com/pages/Dropdown.html");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		Actions builder = new Actions(driver);
		
		WebElement fe1 = driver.findElement(By.xpath("//option[text()='Select your programs']/following-sibling::option[text()='Selenium']"));
		
		WebElement fe2 = driver.findElement(By.xpath("//option[text()='Select your programs']/following-sibling::option[text()='Loadrunner']"));
		
	    builder.keyDown(Keys.CONTROL).click(fe1).click(fe2).keyUp(Keys.CONTROL).perform();
	   	

	}

}
