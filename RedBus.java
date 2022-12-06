package marathon2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
TestCase:3 
Red Bus:
=====
01) Launch Firefox / Chrome
02) Load https://www.redbus.in/
03) Type ""Chennai"" in the FROM text box and select the first option
04) Type ""Bangalore"" in the To text box and select the first option
05) Select tomorrow's date in the Date field
06) Click Search Buses
07) Print the number of buses shown as results
08) Choose SLEEPER in the left menu 
09) Print the name of the second resulting bus 
10) Click the VIEW SEATS of that bus
11) Take screenshot and close browser
Note: Application is built with Shadow Elemenets. Handle shadow element with help of reference document shared on main group
Shadow dom =new Shadow(driver);
dom.setImplicitWait(30);
*/
public class RedBus {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(5);
		WebElement from = driver.findElement(By.xpath("//input[@id='src']"));
		from.sendKeys("Chennai");
		driver.findElement(By.xpath("//li[@data-id='123']")).click();
		from.sendKeys(Keys.TAB);
		WebElement to = driver.findElement(By.id("dest"));
		to.sendKeys("Bangalore");
		driver.findElement(By.xpath("//li[@data-id='122']")).click();
		to.sendKeys(Keys.TAB);
		driver.findElement(By.xpath("//table//tr//td[@class='current day']")).click();
		driver.findElement(By.id("search_btn")).click();
		//no.of buses
		String text = driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText();
		System.out.println("No of buses are "+text);
		//select sleeper
		 driver.findElement(By.xpath("(//label[@class='cbox-label'])[6]")).click();
		String text2 = driver.findElement(By.xpath("(//div[@class='column-two p-right-10 w-30 fl'])[2]")).getText();
		System.out.println("The second bus" +text2);
		//view seats
		driver.findElement(By.xpath("(//div[text()='View Seats'])[2]")).click();
		Thread.sleep(2000);
		//screenshot
		 File source = driver.getScreenshotAs(OutputType.FILE);
	      
		 File dest =new File("./snap/redbus.png");
		       
		 FileUtils.copyFile(source, dest);  
		
		

	}

}
