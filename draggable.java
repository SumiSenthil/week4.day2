package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class draggable {

	public static void main(String[] args) {
		
			WebDriverManager.chromedriver().setup(); 
			 ChromeDriver driver=new ChromeDriver();
			 //MAXIMISE WINDOW
			 driver.manage().window().maximize();
			 driver.get("https://jqueryui.com/draggable/");
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));		
			 WebElement frame1 = driver.findElement(By.xpath("//div[@id='content']/iframe"));			
			driver.switchTo().frame(frame1);			
			 WebElement drag =driver.findElement(By.id("draggable"));			
			 Actions builder=new Actions(driver);
			 builder.dragAndDropBy(drag, 110, 100).perform();

	}

}
