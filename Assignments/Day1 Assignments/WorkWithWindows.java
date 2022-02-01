package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkWithWindows {

	public static void main(String[] args) throws InterruptedException {
		
        WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://www.leafground.com/pages/Window.html");
		
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		
		driver.findElement(By.id("home")).click();
		
		Set<String> windowHandles1 = driver.getWindowHandles();
		
		List<String> windows1 = new ArrayList<String>(windowHandles1);
		
		String childWindow1 = windows1.get(1);
	
		driver.switchTo().window(childWindow1);
		
		driver.switchTo().window(windows1.get(0));
		
		driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
		
		Set<String> windowHandles2 = driver.getWindowHandles();
	
		List<String> windows2 = new ArrayList<String>(windowHandles2);
		
		String childWindow2 = windows2.get(1);
		
		driver.switchTo().window(childWindow2);
		
		int size = windows2.size();
		
        System.out.println("No. of windows opened:" + size);
         
        driver.switchTo().window(windows2.get(3));
        
        driver.close();
        
        driver.switchTo().window(windows2.get(2));
        
        driver.close();
        
        driver.switchTo().window(windows2.get(1));
        
        driver.close();
        
        driver.switchTo().window(windows2.get(0));
        
        driver.findElement(By.id("color")).click();
        
        driver.switchTo().window(windows2.get(0));
        
        driver.findElement(By.xpath("//button[@onclick='openWindowsWithWait();']")).click();
        
        Thread.sleep(5000);
        
        Set<String> windowHandles3 = driver.getWindowHandles();
    	
		List<String> windows3 = new ArrayList<String>(windowHandles3);
		
		String childWindow3 = windows3.get(1);
		
		driver.switchTo().window(childWindow3);
        
		driver.switchTo().window(windows3.get(3));
        
        driver.close();
        
        driver.switchTo().window(windows3.get(2));
        
        driver.close();
        
        driver.switchTo().window(windows3.get(1));
        
        driver.close();
        
		driver.switchTo().window(windows3.get(0));
		
        driver.close();
        
	}

}
