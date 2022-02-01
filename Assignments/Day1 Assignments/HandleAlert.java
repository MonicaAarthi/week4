package week4.day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleAlert {

	public static void main(String[] args) throws Throwable {
		
		//setup the chrome driver
        WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		//Launch URL "http://www.leafground.com/pages/Alert.html"
		
		driver.get("http://www.leafground.com/pages/Alert.html");
		
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		
		//click on alert box in window
		driver.findElement(By.xpath("//button[text()='Alert Box']")).click();
		
		//switch control to alert box
		Alert alert = driver.switchTo().alert();
		
		//click ok on alert box
		alert.accept();
		
        //click on confirm box in main page
		driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();
		
		//clicking cancel button
		alert.dismiss();
			
		//click promptbox in mainpage
		driver.findElement(By.xpath("//button[text()='Prompt Box']")).click();
		
		//switch cntrl to alert and adding text to field
        alert.sendKeys("XYZ");
		
        //click ok
        alert.accept();
        
		WebElement we1 = driver.findElement(By.id("result1"));
		
		String text1 = we1.getText();
		
		System.out.println(text1);
		
		driver.findElement(By.xpath("//button[text()='Line Breaks?']")).click();
		
		String text2 = alert.getText();
			
	    System.out.println(text2);
	    
	    alert.accept();
	    
	    driver.findElement(By.xpath("//button[text()='Sweet Alert']")).click();
	    
	    WebElement we2 = driver.findElement(By.xpath("//div[text()='Happy Coding!']"));
	    
	    String text3 = we2.getText();
	    
	    System.out.println(text3);
	    
	    driver.findElement(By.xpath("//button[text()='OK']")).click();
			

	}

}
