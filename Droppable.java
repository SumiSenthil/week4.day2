package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Droppable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup(); 
		 ChromeDriver driver=new ChromeDriver();
		 //MAXIMISE WINDOW
		 driver.manage().window().maximize();
		 driver.get("https://jqueryui.com/droppable/");
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));		 
		 WebElement frame1 = driver.findElement(By.xpath("//div[@id='content']/iframe"));			
			driver.switchTo().frame(frame1);
		 WebElement drag =driver.findElement(By.id("draggable"));			
		 WebElement drop =driver.findElement(By.id("droppable"));
		 Actions builder=new Actions(driver);
		 builder.dragAndDrop(drag, drop).perform();
	}

}
