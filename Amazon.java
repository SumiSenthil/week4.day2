package week4.day2;

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
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup(); 
		 ChromeDriver driver=new ChromeDriver();
		 //MAXIMISE WINDOW
		 driver.manage().window().maximize();
		 driver.get("https://www.amazon.in/");
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro",Keys.ENTER);
		 String Price = driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
		 System.out.println("Price of Product:"+Price);
		 String cutomerReview = driver.findElement(By.xpath("//span[@class='a-size-base'][1]")).getText();
		 System.out.println("No of Customer Reviews for product:"+cutomerReview);
		 Actions builder=new Actions(driver);
		 WebElement star = driver.findElement(By.xpath("//a[@class='a-popover-trigger a-declarative']/i"));
		 builder.click(star).perform();

		 String rating = driver.findElement(By.xpath("//td[@class='a-text-right a-nowrap']//a")).getText();
		 System.out.println("Rating for product:"+rating);
		
		 WebElement eleBrands=driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		Actions builder1=new Actions(driver);
		builder1.click(eleBrands).perform();	
		 File src = driver.getScreenshotAs(OutputType.FILE);
		 File dst = new File("./snaps/Amazon.png");
		 FileUtils.copyFile(src, dst);	
		 Set<String> winset = driver.getWindowHandles();
		 List<String> winList =new ArrayList<String>(winset);
		 System.out.println("We are in window number:"+winList.size());		
		 driver.switchTo().window(winList.get(1));
		 driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		 Thread.sleep(500);
		String MRP = driver.findElement(By.xpath("//b[text()='Cart subtotal']/following::span[1]/span")).getText();
		
		
		 if (MRP.contains(Price)) {
			 System.out.println("Price are same");
		 }
		 else
		 {
			 System.out.println("Price are different due to addition of shipping charge");
		 }
	}

}
