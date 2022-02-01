package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntra {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		  WebDriverManager.chromedriver().setup();
		   
		    //to handle notifications in websites
		    ChromeOptions options = new ChromeOptions();
		    options.addArguments("--disable-notifications");
		        
			ChromeDriver driver = new ChromeDriver(options);
			
			driver.get("https://www.myntra.com/");
			
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
			Actions builder = new Actions(driver);
			
			WebElement fe1 = driver.findElement(By.xpath("(//div[@class='desktop-navLink']/a)[1]"));
		
			WebElement fe2 = driver.findElement(By.xpath("(//a[contains(text(),'Jackets')])[1]"));
			
			builder.moveToElement(fe1).moveToElement(fe2).click(fe2).perform();
			
			WebElement fe3 = driver.findElement(By.xpath("//span[@class='title-count']"));
			
			String t1 = fe3.getText();
			System.out.println(t1);
			
			String rp1 = t1.replaceAll("[^0-9]","");
			
			int s1 = Integer.parseInt(rp1);
			
			WebElement fe4 = driver.findElement(By.xpath("//input[@value='Jackets']/following-sibling::span"));
			String t2 = fe4.getText();
			
            String rp2 = t2.replaceAll("[^0-9]","");
			
			int s2 = Integer.parseInt(rp2);
			
			WebElement fe5 = driver.findElement(By.xpath("//input[@value='Rain Jacket']/following-sibling::span"));
			
            String t3 = fe5.getText();
			
            String rp3 = t3.replaceAll("[^0-9]","");
			
			int s3 = Integer.parseInt(rp3);
			
			int sum = s2 + s3;
			
			if(s1==sum) {
				
				System.out.println("Total matches");
				
			}else {
				
			System.out.println("Total mismatches");
			}
		
	
		driver.findElement(By.xpath("//input[@value='Jackets']/following-sibling::span")).click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("(//div[@class='brand-more'])[1]")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		List<String> window1 = new ArrayList<String>(windowHandles);
		
		driver.switchTo().window(window1.get(0));
		
		driver.findElement(By.xpath("//input[@placeholder='Search brand']")).sendKeys("Duke");
	
	driver.findElement(By.xpath("//ul[@class='FilterDirectory-list']/li[2]")).click();
	Thread.sleep(3000);
		
	driver.findElement(By.xpath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']")).click();
		
		driver.switchTo().defaultContent();
		
		
	WebElement fe6 = driver.findElement(By.xpath("(//input[@value='Duke']/following::span)[1]"));

	String c1 = fe6.getText();
	String dd = c1.replaceAll("[^0-9]","");
	int duke = Integer.parseInt(dd);
	
	List<WebElement> lt = new ArrayList<WebElement>();
	for (int i = 0; i < duke ; i++) {
		
		lt.add(fe6);
	}	
		
	int size = lt.size();
		
		if(size==duke) {
			
			System.out.println("Only Duke brand is added to the list");
		}else {
			
			System.out.println("Contains other brands");
		}
		
	WebElement fe7 = driver.findElement(By.xpath("//div[@class='sort-sortBy']"));
	
	WebElement fe8 = driver.findElement(By.xpath("//div[@class='sort-sortBy']/span"));
	
	builder.moveToElement(fe7).moveToElement(fe8).click(fe8).perform();
	
	WebElement fe9 = driver.findElement(By.xpath("(//span[@class='product-discountedPrice'])[1]"));
	
	String text = fe9.getText();
	
	System.out.println("Price of 1st item:" + text);
	
	driver.findElement(By.xpath("(//img[@class='img-responsive'])[1]")).click();
	
	Set<String> windowHandles2 = driver.getWindowHandles();
	
	List<String> window2 = new ArrayList<String>(windowHandles2);
	
	driver.switchTo().window(window2.get(1));
	
	File source = driver.getScreenshotAs(OutputType.FILE);
	
	File destination = new File("./images/DukeJacket.png");
	
	FileUtils.copyFile(source, destination);
	
	driver.findElement(By.xpath("//span[contains(text(),'WISHLIST')]")).click();
	
	driver.switchTo().defaultContent();
	
	
	driver.quit();
	

	}

}
