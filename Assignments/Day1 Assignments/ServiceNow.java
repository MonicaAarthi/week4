package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNow {

	public static void main(String[] args) throws InterruptedException, IOException {
		
        WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://dev97515.service-now.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.switchTo().frame("gsft_main");
		
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
		
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("Jesussavesyou1*");
		
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		
		//Search “incident “ Filter Navigator
		WebElement fe = driver.findElement(By.id("filter"));
		
		fe.sendKeys("Incident",Keys.ENTER);
		
		driver.findElement(By.linkText("Incidents")).click();
		
		//Click “All”
		driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();
		
		//switch to frame
		driver.switchTo().frame("gsft_main");
		
		//Click New button
		
		driver.findElement(By.id("sysverb_new")).click();
		
		//storing incident number in a variable
		
		String ref = driver.findElement(By.id("incident.number")).getAttribute("value");
		
		System.out.println("Reference Number:" +ref);
	
		//Select a value for Caller 
		driver.findElement(By.id("lookup.incident.caller_id")).click();
			
		Set<String> windowHandles1= driver.getWindowHandles();
		
		List<String> window1 = new ArrayList<String>(windowHandles1);
		
		driver.switchTo().window(window1.get(1));
		
		Thread.sleep(3000);
		
		driver.findElement(By.linkText("Abel Tuter")).click();
		
		driver.switchTo().window(window1.get(0));
		
		driver.switchTo().frame("gsft_main");
		
		//Enter value for short_description
		driver.findElement(By.id("lookup.incident.short_description")).click();
		
		Set<String> windowHandles2 = driver.getWindowHandles();
		
		List<String> window2 = new ArrayList<String>(windowHandles2);
		
		driver.switchTo().window(window2.get(1));
		
		Thread.sleep(3000);
		
		driver.findElement(By.linkText("Issue with a web page")).click();
		
		driver.switchTo().window(window2.get(0));
		
		driver.switchTo().frame("gsft_main");
		
		//Click on Submit button
		driver.findElement(By.id("sysverb_insert_bottom")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//select[@role='listbox']/option[2]")).click();
		
		//search for created incident number and storing the attribute value
	driver.findElement(By.xpath("//label[text()='Search']/following-sibling::input")).sendKeys(ref,Keys.ENTER);
	
	String attribute = driver.findElement(By.xpath("(//tbody//td/a)[2]")).getAttribute("aria-label");
	
	//verifying the ref no is same
	if(attribute.contains(ref)) {
		
		System.out.println("Created Incident is verified");
	
	}else {
		
		System.out.println("Incident is not created");
	}
	
	//take screenshot
	File source = driver.getScreenshotAs(OutputType.FILE);
	
	File destination = new File("./images/IncidentCreated.png");
	
	FileUtils.copyFile(source, destination);
			
	driver.close();
	}

}
