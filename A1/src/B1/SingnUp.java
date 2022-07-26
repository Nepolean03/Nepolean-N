package B1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SingnUp extends Dependencies {
	@Test
	public void Signup(){

		
		    driver.get("https://mobileworld.azurewebsites.net/index.html");
		// SignUp Button
			driver.findElement(By.cssSelector(".btn.btn-warning.my-2.my-sm-0")).click();
			driver.findElement(By.xpath("//a[.='Sign up']")).click();
			
         // Registration Form
			driver.findElement(By.cssSelector("[placeholder='First Name']")).sendKeys("Nepolean");
			driver.findElement(By.cssSelector("[placeholder='Last Name']")).sendKeys("N");
			driver.findElement(By.cssSelector("[placeholder='Enter Email']")).sendKeys("nepolean123@gmail.com");
			driver.findElement(By.cssSelector("[placeholder='Password']")).sendKeys("12345");
			driver.findElement(By.xpath("//input[@type='date']")).sendKeys("06/21/1998");
			driver.findElement(By.xpath("//div[@class='col-md-2']/input")).click();
			driver.findElement(By.cssSelector("[placeholder='91XXXXXXXXXX']")).sendKeys("8056920107");
			driver.findElement(By.cssSelector("[placeholder='Short Bio']")).sendKeys(" qawertfyguhijoiuytresdf");
			driver.findElement(By.xpath("//button[.='Register']")).click();
			
         // Switching to Alert
			Alert alert = driver.switchTo().alert();
			String alertmessage = driver.switchTo().alert().getText();
			System.out.println(alertmessage);
			alert.accept();

			driver.findElement(By.xpath("//button[.='Sign In']")).click();
			driver.switchTo().alert().accept();
			

}
}


