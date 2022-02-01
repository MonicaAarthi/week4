package week4.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesLeafGround {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leafground.com/pages/frame.html");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//switch to frame 1
		driver.switchTo().frame(0);
		
		WebElement fe1 = driver.findElement(By.xpath("//button[@id='Click']"));
		fe1.click();
		String t1 = fe1.getText();
		System.out.println(t1);
		
		//switch back to main page
		driver.switchTo().defaultContent();
		
		//frame 2
		driver.switchTo().frame(1);
		
		//frame 3
		driver.switchTo().frame("frame2");
		
		WebElement fe2 = driver.findElement(By.xpath("//button[@id='Click1']"));
		fe2.click();
		String t2 = fe2.getText();
		System.out.println(t2);
		
		//switch to parent frame ie.frame 1
		driver.switchTo().parentFrame();
		
		//main page
		driver.switchTo().defaultContent();
		
		//to find no. of frames present in a webpage
       
		List<WebElement> fe3 = driver.findElements(By.tagName("iframe"));
			
		int size1 = fe3.size();
		
	    System.out.println("No. of outer frames:" + size1);
		
		//Add nested frame to total
		
		for (int i = 0; i < fe3.size(); i++) {
			
			driver.switchTo().frame(fe3.get(i));
			
			List<WebElement> fe4 = driver.findElements(By.tagName("iframe"));
			
			size1 =  size1 + fe4.size();
			
			driver.switchTo().defaultContent();
			
		}
		
		System.out.println("Total no. of frames present:" + size1);
		

	}

}
