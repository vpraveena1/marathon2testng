package marathon2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class AdministrationCertificate extends BaseSalesforce {

	@Test
	public void Certificate() {

		driver.findElement(By.xpath("(//span[@class=' label bBody'])[2]")).click();
		Set<String> wh = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(wh);
		driver.switchTo().window(list.get(1));

		driver.findElement(By.xpath("//button[text()='Confirm']")).click();

		Shadow shadow = new Shadow(driver);
		shadow.setImplicitWait(20);

		shadow.findElementByXPath("//span[text()='Learning']").click();
		shadow.setImplicitWait(10);

		WebElement mouseover = shadow.findElementByXPath("//span[text()='Learning on Trailhead']");
		Actions builder = new Actions(driver);
		builder.moveToElement(mouseover).perform();

		shadow.findElementByXPath("//a[text()='Salesforce Certification']").click();

		driver.findElement(By.xpath("//a[text()='Administrator']")).click();
		System.out.println("Title of the page  " + driver.getTitle());

		System.out.println("Certificates");
		List<WebElement> certi = driver.findElements(By.xpath("//div[@class='credentials-card_title']"));
		for (int i = 0; i < 4; i++) {
			System.out.println(certi.get(i).getText() + "\n");
		}

	}

}
