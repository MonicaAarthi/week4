package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnWindows {

	public static void main(String[] args) throws Throwable {
        
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.irctc.co.in/nget/train-search");
		
		driver.manage().window().maximize();
		
		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[text()='OK']")).click();
		
		driver.findElement(By.xpath("//i[@class='fa fa-align-justify']")).click();
		
		driver.findElement(By.xpath("//label[text()='FLIGHTS']")).click();
	
		//String parentWindow = driver.getWindowHandle();
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		List<String> windows = new ArrayList<String>(windowHandles);
		
		//driver.switchTo().window(null)
		
		String childWindow = windows.get(1);
		
		driver.switchTo().window(childWindow);
		
		String title2 = driver.getTitle();
		
		System.out.println(title2);
		
		driver.close();
		
	}

}
