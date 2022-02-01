package week4.day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertFrame {

	public static void main(String[] args) throws InterruptedException {
		
		/*1. Navigate to https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt
2. Click on Try it button
3. Enter your name in Alert field
4. Accept the alert
5. Verify your name is displayed correctly*/
	
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
		
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		
		driver.switchTo().frame("iframeResult");
		
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		
		Alert alert = driver.switchTo().alert();
		
		alert.sendKeys("Monica");
		
		alert.accept();
		
		String text = driver.findElement(By.id("demo")).getText();
			
		System.out.println(text);
			

	}

}
