package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Snapdeal {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup(); 
		 ChromeDriver driver=new ChromeDriver();
		 //MAXIMISE WINDOW
		 driver.manage().window().maximize();
		 driver.get("https://www.snapdeal.com/");
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 WebElement men= driver.findElement(By.xpath("//li[@class='navlink lnHeight']//span"));		
		 Actions builder1=new Actions(driver);
		builder1.click(men).perform();
		 WebElement shoe= driver.findElement(By.xpath("//span[text()='Sports Shoes']"));		 
			builder1.click(shoe).perform();
			String TotalShoe =driver.findElement(By.xpath("//span[@class='category-count']")).getText();
			 System.out.println("No of shoes displayed:"+TotalShoe);
			 WebElement trainShoe= driver.findElement(By.xpath("//div[text()='Training Shoes']"));
			builder1.click(trainShoe).perform();
			WebElement sort= driver.findElement(By.xpath("//div[@class='sort-selected']"));
			builder1.click(sort).perform();
			WebElement lowHigh= driver.findElement(By.xpath("//ul[@class='sort-value']/li[2]"));
			builder1.click(lowHigh).perform();			
			 /*List<WebElement> shoerate = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
			 for(WebElement e : shoerate) 		        {        
		            System.out.print(e.getText());		           
		        }*/
			   	    
			 driver.findElement(By.xpath("//input[@name='fromVal']")).clear();	
			 driver.findElement(By.xpath("//input[@name='fromVal']")).sendKeys("900");
			 driver.findElement(By.xpath("//input[@name='toVal']")).clear();
			 driver.findElement(By.xpath("//input[@name='toVal']")).sendKeys("1200");
			 WebElement Go= driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']"));
			 builder1.click(Go).perform();
			 WebElement color= driver.findElement(By.xpath("//label[@for='Color_s-Gray']"));
			builder1.click(color).perform();
			WebElement greyShoe= driver.findElement(By.xpath("//img[@class='product-image wooble']"));
			builder1.moveToElement(greyShoe).perform();		
			
			WebElement QuickView= driver.findElement(By.xpath("//div[@class='clearfix row-disc']/div"));
			builder1.click(QuickView).perform();	
			 String Price = driver.findElement(By.xpath("//div[@class='product-desc-price pdp-e-i-PAY-r ']/span")).getText();
			 System.out.println("Price oh Grey shoe:"+Price);	
			 String discountPrice = driver.findElement(By.xpath("//div[@class='product-price pdp-e-i-PAY-l clearfix']/span")).getText();
			 System.out.println("Discount Price oh Grey shoe:"+discountPrice);	
			 String discountpercent = driver.findElement(By.xpath("//div[@class='product-price pdp-e-i-PAY-l clearfix']/span[2]")).getText();
			 System.out.println("Discount percentage of Grey shoe:"+discountpercent);			
					
				File src = driver.getScreenshotAs(OutputType.FILE);						
				 File dst = new File("./snaps/Snapdeal.png");
				 FileUtils.copyFile(src, dst);	
				 driver.quit();
			
			
	}

}
