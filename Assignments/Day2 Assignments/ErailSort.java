package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErailSort {

	public static void main(String[] args) throws InterruptedException {
		
//		Launch the browser
//		Launch the URL - https://erail.in/		
		     WebDriverManager.chromedriver().setup();
			
			ChromeDriver driver = new ChromeDriver();
			
			driver.get("http://erail.in/");
			
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
//		Uncheck the check box - sort on date
			
			driver.findElement(By.id("chkSelectDateOnly")).click();
			
//		clear and type in the source station 
			
			WebElement ele1 = driver.findElement(By.id("txtStationFrom"));
			ele1.clear();		
			Thread.sleep(500);
			ele1.sendKeys(Keys.TAB);

//			clear and type in the destination station		
	        WebElement ele2 = driver.findElement(By.id("txtStationTo"));
	        ele2.clear();
	        Thread.sleep(500);  
	        ele2.sendKeys(Keys.TAB);

//		Find all the train names using xpath and store it in a list
	        
	   int rowCount = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr")).size();
			
	   List<String> trainNames = new ArrayList<String>();
			
		for(int i=1; i<=rowCount;i++) {
				
	    String trains = driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr[ "+ i + " ]/td[2]")).getText();       
				
	     trainNames.add(trains);
			 
			}
			
		
//		Use Java Collections sort to sort it and then print it
		
		Collections.sort(trainNames);
		
		System.out.println("No.of trains available:"+ trainNames.size());
		
		System.out.println("List of trains:" + trainNames);
	
		
	}

}
