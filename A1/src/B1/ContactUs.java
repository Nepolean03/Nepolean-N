package B1;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ContactUs extends Dependencies {
	
    @Test
	public void contactuS() {

	
		driver.get("https://mobileworld.azurewebsites.net/index.html");
	     // ContactUs
			driver.findElement(By.linkText("Contact Us")).click();
	     // Switching Windows Control
			Set<String> windows = driver.getWindowHandles();
			Iterator<String> it = windows.iterator();
			String parentId = it.next();
			String childId = it.next();
			driver.switchTo().window(childId);
	     // Details
			driver.findElement(By.xpath("//div[@class='contact-form']/form/div[1]/input")).sendKeys("@Nj1688");
			driver.findElement(By.xpath("//div[@class='contact-form']/form/div[2]/input")).sendKeys("nepolean123@gmail.com");
			driver.findElement(By.xpath("//div[@class='contact-form']/form/div[3]/input")).sendKeys("8056920107");
			driver.findElement(By.xpath("//div[@class='contact-form']/form/div[4]/textarea")).sendKeys("ContactUs");

			driver.findElement(By.cssSelector(".btn")).click();
			
		}
}
