package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntra {

	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup(); 
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		WebDriverManager.chromedriver().setup(); 
		 ChromeDriver driver=new ChromeDriver();
		 //MAXIMISE WINDOW
		 driver.manage().window().maximize();
		 driver.get("https://www.myntra.com/");
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 WebElement men= driver.findElement(By.xpath("//a[text()='Men']"));		
		 Actions builder1=new Actions(driver);
		builder1.moveToElement(men).perform();		
		 WebElement Jacket= driver.findElement(By.xpath("//a[text()='Jackets']"));		 
		builder1.click(Jacket).perform();		
		String TotalJacket= driver.findElement(By.xpath("//h1[text()='Jackets for Men']/following::span[1]")).getText();
		 System.out.println("Total Jackets available:"+TotalJacket);
		 WebElement chkJacket= driver.findElement(By.xpath("//div[@class='common-checkboxIndicator']"));		 
			builder1.click(chkJacket).perform();
			WebElement brand= driver.findElement(By.xpath("//div[@class='brand-more']"));		 
			builder1.click(brand).perform();
			driver.findElement(By.xpath("//input[@class='FilterDirectory-searchInput']")).sendKeys("Duke");	
			
		WebElement Duke= driver.findElement(By.xpath("//label[@class=' common-customCheckbox']/div"));		 
		builder1.click(Duke).perform();
		  List<WebElement> duke = driver.findElements(By.xpath("//h3[text()='Duke']"));	      
	      for (WebElement webElement : duke) {			
	   	  if(webElement.getText().contains("Duke"))	   	  {
	   		  System.out.println("All Jackets are Duke brand");
	   		  break;
	   	  }
		}
		WebElement recomend= driver.findElement(By.xpath("//span[text()='Recommended']"));		 
		builder1.click(recomend).perform();
		WebElement better= driver.findElement(By.xpath("//ul[@class='sort-list']/li[3]"));		 
		builder1.click(better).perform();
		WebElement price = driver.findElement(By.xpath("(//span[@class='product-discountedPrice'])[1]"));	         
	    price.click();
		
		//capture screenshot
		File src = driver.getScreenshotAs(OutputType.FILE);						
		 File dst = new File("./snaps/Snapdeal.png");
		 FileUtils.copyFile(src, dst);	
		//New window
		 Set<String> windowHandles = driver.getWindowHandles();	      
	      List<String> lst = new ArrayList<String>(windowHandles);	      
	      driver.switchTo().window(lst.get(1));
	      WebElement wish= driver.findElement(By.xpath("//span[text()='WISHLIST']"));
	      builder1.click(wish).perform();
	      driver.quit();
		
	}

}
