package B1;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class MobileWorld {

		WebDriver driver;
		long startTime;
		long endTime;

		@BeforeClass
		public void launchBrowser() {
			startTime = System.currentTimeMillis();
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
		@Test
		public void SignUp() {
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

		@Test(dependsOnMethods={"SignUp"})
		public void Login() throws InterruptedException {

			driver.get("https://mobileworld.azurewebsites.net/sign.html");
		  //Alignment of TextField
			int Unx=driver.findElement(By.id("username")).getLocation().getX();
			int Pwd= driver.findElement(By.id("password")).getLocation().getX();
			if(Unx==Pwd) {
				System.out.println("Both are equal and aligned");
			}
			else {
				System.out.println("Both are not aligned");
			}
         // Login
			driver.findElement(By.id("username")).sendKeys("Nepolean");
			driver.findElement(By.id("password")).sendKeys("12345");
			driver.findElement(By.xpath("//a[.='Log In']")).click();

         // All mobile page
			driver.findElement(By.linkText("All Mobiles")).click();

         // Order Mobile
			driver.findElement(By.xpath("//tbody[@id='myTable']/tr[1]/td[5]/a")).click();
			
         // Switching Windows Control
			Set<String> windows = driver.getWindowHandles();
			Iterator<String> it = windows.iterator();
			String parentId = it.next();
			String childId = it.next();
			driver.switchTo().window(childId);
         // Place your order Details
			driver.findElement(By.xpath("//div[@class='container']/div[1]/div[2]/form[1]/div[1]/div[1]/input")).sendKeys("Nepolean");
			driver.findElement(By.xpath("//div[@class='container']/div[1]/div[2]/form[1]/div[1]/div[2]/input")).sendKeys("N");
			driver.findElement(By.id("inputEmail")).sendKeys("nepolean123@gmail.com");
			driver.findElement(By.id("inputPassword")).sendKeys("12345");
			driver.findElement(By.id("flexRadioDefault1")).click();
			driver.findElement(By.xpath("//input[@min='0']")).sendKeys("8056920107");
			driver.findElement(By.id(" address1")).sendKeys("H2,Mountain Ash");
			driver.findElement(By.id("address2")).sendKeys("Manyata Embassy Bussiness Park");
			driver.findElement(By.id("inputCity")).sendKeys("Bangalore");

			WebElement State = driver.findElement(By.xpath("//select[@id='inputState']"));
			Select s1 = new Select(State);
			s1.selectByIndex(2);

			driver.findElement(By.id("inputZip")).sendKeys("560045");
			WebElement Brand = driver.findElement(By.xpath("//input[@rel='samsung']"));
			Brand.click();
			Brand.click();

			driver.findElement(By.xpath("//select[@class='multi_select']/option[1]")).click();
            driver.findElement(By.xpath("//input[@placeholder='no of mobiles']")).sendKeys("2");

			WebElement Bought = driver.findElement(By.id("bought"));
			Select s3 = new Select(Bought);
			s3.selectByIndex(1);

			List<WebElement> a = driver.findElements(By.id("gridCheck1"));
			a.get(0).click();
			a.get(1).click();
			
			// order
			driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
			Thread.sleep(1000);
			System.out.println(driver.findElement(By.xpath("//div[@class='modal-body']")).getText());
			driver.findElement(By.xpath("//span[@aria-hidden='true']")).click();
		}

		@Test(dependsOnMethods={"Login"})
		public void ContactUs() {
			driver.get("https://mobileworld.azurewebsites.net/index.html");
	     // ContactUs
			driver.findElement(By.linkText("Contact Us")).click();
	     // Switching Windows Control
			Set<String> windows = driver.getWindowHandles();
			Iterator<String> it = windows.iterator();
			String parentId = it.next();
			String childId = it.next();
			String childId1 = it.next();
			driver.switchTo().window(childId1);
	     // Details
			driver.findElement(By.xpath("//div[@class='contact-form']/form/div[1]/input")).sendKeys("@Nj1688");
			driver.findElement(By.xpath("//div[@class='contact-form']/form/div[2]/input")).sendKeys("nepolean123@gmail.com");
			driver.findElement(By.xpath("//div[@class='contact-form']/form/div[3]/input")).sendKeys("8056920107");
			driver.findElement(By.xpath("//div[@class='contact-form']/form/div[4]/textarea")).sendKeys("ContactUs");

			driver.findElement(By.cssSelector(".btn")).click();
			driver.close();
		}

		@AfterClass
		public void closeBrowser() {
			driver.quit();
			endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			System.out.println("Total time taken" + totalTime);

		}

	}








