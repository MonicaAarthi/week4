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

class Snapdeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		     WebDriverManager.chromedriver().setup();
		   
		    //to handle notifications in websites
		    ChromeOptions options = new ChromeOptions();
		    options.addArguments("--disable-notifications");
		        
			ChromeDriver driver = new ChromeDriver(options);
			
			driver.get("https://www.snapdeal.com/");
			
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
			Actions builder = new Actions(driver);
			
			WebElement fe1 = driver.findElement(By.xpath("//li[@navindex='1']"));
			
			WebElement fe2 = driver.findElement(By.xpath("//span[contains(text(),'Sports Shoes')]"));
			
			builder.clickAndHold(fe1).moveToElement(fe2).click(fe2).perform();
			
	//WebElement fe3 = driver.findElement(By.xpath("//div[@class='child-cat-name selected']/following-sibling::div"));
	
	//String t1 = fe3.getText();
	      
   WebElement fe4 = driver.findElement(By.xpath("//div[@class='vis-hid node-toggle sd-icon node-open sd-icon-minus']/following-sibling::a"));
   
          fe4.click();
      	
      driver.findElement(By.xpath("//span[contains(text(),'Sort by')]")).click();
			
      driver.findElement(By.xpath("//ul[@class='sort-value']/li[2]")).click();
      
      WebElement fe5 = driver.findElement(By.xpath("//span[@class='sort-label']/following-sibling::div"));
      
      String t2 = fe5.getText();
      
      if(t2.contains("Low To High")) {
    	  
    	  System.out.println("Sorted Low to High");
      }else {
    	  
    	  System.out.println("Sorted improperly");
      }
      
      Thread.sleep(5000);
      
  WebElement fe6 = driver.findElement(By.xpath("//input[@name='fromVal']"));
  
     fe6.clear();
     fe6.sendKeys("900");
     
   
  WebElement fe7 = driver.findElement(By.xpath("//input[@name='toVal']"));
  
  fe7.clear();
  fe7.sendKeys("1200");
 
  driver.findElement(By.xpath("//input[@name='toVal']/following::div[1]")).click();
  
  Thread.sleep(5000);
driver.findElement(By.xpath("//button[@data-filtername='Color_s']")).click();

  WebElement fe8 = driver.findElement(By.xpath("//label[@for='Color_s-Navy']"));
  
  fe8.click();
   
  WebElement fe9 = driver.findElement(By.xpath("//div[@class='filters-top-selected']/div[@class='filters']//a[contains(text(),'Navy')]"));
  
  String t4 = fe9.getText();
  
  WebElement fe10 = driver.findElement(By.xpath("//div[@class='filters-top-selected']/div[@class='filters']//a[@data-key='Price|Price']"));
  
    String t5 = fe10.getText();
    
    
   if(t4.contains("Navy") && t5.contains("1200")) {
  
		   System.out.println("All filters applied");
	  
	}else {
		
		System.out.println("Filters not applied");
		
	}
   
  		
   WebElement fe11 = driver.findElement(By.xpath("(//picture[@class='picture-elem']/img)[1]"));
   
   Thread.sleep(7000);
   
   WebElement fe12 = driver.findElement(By.xpath("(//div[@class='clearfix row-disc']/div)[1]"));
   
   builder.moveToElement(fe11).moveToElement(fe12).click(fe12).perform();
   
   Set<String> windowHandles = driver.getWindowHandles();
   
   List<String> window1 = new ArrayList<String>(windowHandles);
   
   driver.switchTo().window(window1.get(0));
   
   WebElement fe13 = driver.findElement(By.xpath("//span[@class='payBlkBig']"));
   
   String t11 = fe13.getText();
   
   String text1 = t11.replaceAll("[^0-9]","");
   
   int parseInt = Integer.parseInt(text1);
  
   System.out.println("Shoe Price: Rs." + parseInt);
   
   Thread.sleep(7000);
   
  WebElement fe14 = driver.findElement(By.xpath("//div[@class='product-price pdp-e-i-PAY-l clearfix']/span[2]"));
  
  Thread.sleep(7000);
   
   String text2 = fe14.getText();
   
   System.out.println("Discount:" + text2);
   
 //take screenshot
 	File source = driver.getScreenshotAs(OutputType.FILE);
 	
 	File destination = new File("./images/TrainingShoes.png");
 	
 	FileUtils.copyFile(source, destination);
 			
 	driver.switchTo().defaultContent();
 	
 	driver.close();
  
   
	}   
   
}
