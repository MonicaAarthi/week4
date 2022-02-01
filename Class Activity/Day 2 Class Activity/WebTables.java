package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTables {

	public static void main(String[] args) throws InterruptedException {
		
        WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://erail.in/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		WebElement ele1 = driver.findElement(By.id("txtStationFrom"));
		
		ele1.clear();
		
		ele1.sendKeys("Chennai Egmore");
		
		Thread.sleep(500);
		
		ele1.sendKeys(Keys.TAB);
		
        WebElement ele2 = driver.findElement(By.id("txtStationTo"));
		
        ele2.clear();
        
        ele2.sendKeys("Madurai Jn");
        
        Thread.sleep(500);
        
        ele2.sendKeys(Keys.TAB);
		
		driver.findElement(By.id("chkSelectDateOnly")).click();
		
		int rowCount = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr")).size();
		
		List<String> trainNames = new ArrayList<String>();
		
		for(int i=1; i<=rowCount;i++) {
			
		 String trains = driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr[ "+ i + " ]/td[2]")).getText();       
			
		 trainNames.add(trains);
		 
		}
		
		System.out.println("No.of trains available:"+ trainNames.size());
		
		System.out.println("List of trains:" + trainNames);
		
		Set<String> st1 = new HashSet<String>(trainNames);
		
		if(trainNames.size() == st1.size()) {
			
			System.out.println("There is no duplicates");
			
		} else {
			
			System.out.println("It has duplicates");
		}
		
		
	}
	
	
}
