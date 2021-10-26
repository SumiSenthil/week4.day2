package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sortable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup(); 
		 ChromeDriver driver=new ChromeDriver();
		 //MAXIMISE WINDOW
		 driver.manage().window().maximize();
		 driver.get("https://jqueryui.com/sortable/");
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));		 
		 WebElement frame1 = driver.findElement(By.xpath("//div[@id='content']/iframe"));			
		driver.switchTo().frame(frame1);
		 WebElement item1 =driver.findElement(By.xpath("//ul[@id='sortable']/li[1]"));			
		 WebElement item4 =driver.findElement(By.xpath("//ul[@id='sortable']/li[4]"));	
		 Point location=item4.getLocation();
		 System.out.println(location);
		 int x=location.getX();
		 int y=location.getY();
		 Actions builder=new Actions(driver);
		 System.out.println(x);
		 builder.dragAndDropBy(item1, x, y).perform();
	}
		
	}

	


