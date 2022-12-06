package marathon2;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;
public class SalesForce extends BaseSalesforce {
@Test
	public void Architect() {
		
		
		driver.findElement(By.xpath("(//span[@class=' label bBody'])[2]")).click();
		
		Set<String> wh = driver.getWindowHandles();
		List<String>list=new ArrayList<String>(wh);
		driver.switchTo().window(list.get(1));
		
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		
		Shadow shadow=new Shadow(driver);
		shadow.setImplicitWait(20);
		
		shadow.findElementByXPath("//span[text()='Learning']").click();
		shadow.setImplicitWait(10);
		
		WebElement mouseover = shadow.findElementByXPath("//span[text()='Learning on Trailhead']");
		Actions builder =new Actions(driver);
		builder.moveToElement(mouseover).perform();
		
		shadow.findElementByXPath("//a[text()='Salesforce Certification']").click();
		driver.findElement(By.xpath("(//img[@class='roleMenu-item_img'])[2]")).click();
		System.out.println("The URL is "+driver.getTitle());
		String text = driver.findElement(By.xpath("//div[contains(@class,'cert-site_text slds-text')]")).getText();
		System.out.println(text);
			
		System.out.println("Certificates");
		List<WebElement> list3 = driver.findElements(By.xpath("//div[@class='credentials-card_title']"));
		for (int i = 0; i <list3.size(); i++) {
			System.out.println(list3.get(i).getText()+"\n");
		}
		
		
		
		
		
		
		
		
			
		
		
		
		
		
		
		
		
		
		
	}
}