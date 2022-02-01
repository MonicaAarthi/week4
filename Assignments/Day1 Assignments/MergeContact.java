package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws Throwable {
		
		//setup the chrome driver
        WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		//Launch URL "http://leaftaps.com/opentaps/control/login"
		
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		
		//Enter UserName and Password Using Id Locator

		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		// Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//Click on contacts Button
		driver.findElement(By.linkText("Contacts")).click();
		
		//Click on Merge Contacts using Xpath Locator
		driver.findElement(By.linkText("Merge Contacts")).click();
		
		//Click on Widget of From Contact
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
		
		//getting the parentwindow reference
		//String parentWindow = driver.getWindowHandle();
		
		//getting the child window reference
		Set<String> windowHandles = driver.getWindowHandles();
		
		List<String> windows = new ArrayList<String>(windowHandles); 
		
		//switching control to childwindow
		driver.switchTo().window(windows.get(1));
		
        //performing actions in childwindow
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
		
		//switching back to parentwindow
		driver.switchTo().window(windows.get(0));
		
		//performing actions in parent window
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		
		//getting the childwindow reference again
        Set<String> windowHandles1 = driver.getWindowHandles();
	
		List<String> windows1 = new ArrayList<String>(windowHandles1);
		
		//switching control to child window
		driver.switchTo().window(windows1.get(1));
		
		//performing actions in childwindow
		//driver.findElement(By.xpath("//a[@class='linktext']")).click();
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]")).click();
		
		//switching back to parentwindow
		driver.switchTo().window(windows.get(0));
		
		//perform actions in parentwindow
		driver.findElement(By.linkText("Merge")).click();
		
		//accept the alert box
		driver.switchTo().alert().accept();
		
		//get the title of the page
		String title = driver.getTitle();
		
		//verify title
		System.out.println("Title of the page:"+title);
		
		if(title.contains("View Contact")) {
			
			System.out.println("Title verified");
		}else {
			
			System.out.println("Title mismatched");
			
		}
			
		

	}

}
