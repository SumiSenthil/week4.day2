package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Resizable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup(); 
		 ChromeDriver driver=new ChromeDriver();
		 //MAXIMISE WINDOW
		 driver.manage().window().maximize();
		 driver.get("https://jqueryui.com/resizable/");
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));			 
		 Actions builder=new Actions(driver);		
		 driver.switchTo().frame(0);			
		 WebElement resize = driver.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']"));		
         builder.clickAndHold(resize).moveByOffset(100, 10).release(resize).build().perform();
	}

}
