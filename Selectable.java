package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selectable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup(); 
		 ChromeDriver driver=new ChromeDriver();
		 //MAXIMISE WINDOW
		 driver.manage().window().maximize();
		 driver.get("https://jqueryui.com/selectable/");
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));		 
		 WebElement frame1 = driver.findElement(By.xpath("//div[@id='content']/iframe"));			
		driver.switchTo().frame(frame1);
		 WebElement item1 =driver.findElement(By.xpath("//ol[@id='selectable']/li[1]"));			
		 WebElement item4 =driver.findElement(By.xpath("//ol[@id='selectable']/li[4]"));	
		 Actions builder=new Actions(driver);
		 builder.clickAndHold(item1).moveToElement(item4).release().perform();

	}

}
