package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class nykaa {

	public static void main(String[] args) throws InterruptedException {
		
			WebDriverManager.chromedriver().setup(); 
			 ChromeDriver driver=new ChromeDriver();
			 //MAXIMISE WINDOW
			 driver.manage().window().maximize();
			 driver.get("https://www.nykaa.com/");
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			 
			 WebElement eleBrands = driver.findElement(By.xpath("//a[text()='brands']"));
			 Actions builder=new Actions(driver);
			 builder.moveToElement(eleBrands).perform();
			 
			WebElement brandname = driver.findElement(By.xpath("//input[@id='brandSearchBox']"));
			brandname.sendKeys("L'Oreal Paris");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOf(brandname));
			driver.findElement(By.linkText("L'Oreal Paris")).click();
			System.out.println(driver.getTitle());			 
						 
			 WebElement sortPopular = driver.findElement(By.xpath("//span[text()='Sort By : popularity']"));
		
			 builder.click(sortPopular).perform();			 
			 WebElement sortCustomer = driver.findElement(By.xpath("//span[text()='customer top rated']"));
			
			 builder.click(sortCustomer).perform(); 
			 WebElement cliCategory = driver.findElement(By.xpath("//span[text()='Category']"));		
			 builder.click(cliCategory).perform();
			 
			 WebElement clicHair = driver.findElement(By.xpath("//span[text()='Hair']"));			 
			 builder.click(clicHair).perform();
			
			 WebElement clicHairCare = driver.findElement(By.xpath("//span[text()='Hair Care']"));			 
			 builder.click(clicHairCare).perform();
			 
			 WebElement shampoo = driver.findElement(By.xpath("//span[text()='Shampoo']"));			 
			 builder.click(shampoo).perform();
			 
			 driver.findElement(By.xpath("//span[text()='Concern']")).click();

			driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
			
			 Boolean chkShampoo =driver.findElement(By.xpath("//span[text()='Shampoo']")).isDisplayed();
			 Boolean chkColor =driver.findElement(By.xpath("//span[text()='Color Protection']")).isDisplayed();
			 if (chkShampoo==true) {
				 System.out.println("Filtered with Shampoo");
			 }
			 else
			 {
				 System.out.println("Not Filtered with Shampoo");
			 }
				 if (chkColor==true) {
					 System.out.println("Filtered with Color Protection");
				 }
				 else
				 {
					 System.out.println("Not Filtered with Color Protection");
				 }
				 
				 String price =driver.findElement(By.xpath("//span[text()='MRP:']/following-sibling::span")).getText();
				 System.out.println("Price of Shampoo:"+price);
				 
				 driver.findElement(By.xpath("//div[@id='product-list-wrap']//div[1]/following::a/div[2]/div[1]")).click();
				Set<String> windowHandles = driver.getWindowHandles();
				List<String> set = new ArrayList<String>(windowHandles);
				System.out.println("No of windows " + windowHandles.size());
				driver.switchTo().window(set.get(1));
				Thread.sleep(2000);
				WebElement quantityML = driver.findElement(By.xpath("//div[text()='inclusive of all taxes']/following::select[@title='SIZE']"));
				quantityML.click();	
				String MRP=driver.findElement(By.xpath("//span[text()='MRP:']/following::span[1]")).getText();
				System.out.println("MRP of shampoo: " + MRP);
				 
				 WebElement addToBag = driver.findElement(By.xpath("//span[text()='ADD TO BAG']"));			 
				 builder.click(addToBag).perform();
				 driver.findElement(By.xpath("//span[text()='Account']/following::button[1]")).click();
				 driver.switchTo().frame(0);
				 String GrandTotal = driver.findElement(By.xpath("//span[text()='Grand Total']/following::div")).getText();			 
				 System.out.println("GrandTotal of Shampoo:"+GrandTotal);
				 
				 if (price==GrandTotal) {
					 System.out.println("Price are same");
				 }
				 else
				 {
					 System.out.println("Price are different due to addition of shipping charge");
				 }
					 WebElement Proceed = driver.findElement(By.xpath("//span[text()='Proceed']"));			 
					 builder.click(Proceed).perform();
					 //WebElement Guest = driver.findElement(By.className("btn full big"));			 
					 //builder.click(Guest).perform();
					 driver.quit();
				 }
			}
			 
			 
			 
	





