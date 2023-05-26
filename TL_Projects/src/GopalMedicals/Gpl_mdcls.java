package GopalMedicals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Gpl_mdcls {
	
	WebDriver driver;
	@BeforeTest
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	@BeforeMethod
	public void url()
	{
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	     driver.get("https://gopalmedicals.in/");
	     
	}
	
	@Test(priority = 1,enabled = true)
	public void enquiryForm() throws InterruptedException {
		// Title checking.

		String excepted_Title = "Gopal Medicals";
		String title = driver.getTitle();
		if (title.equals(excepted_Title)) {
			System.out.println("The Title : " + title);
		} else {
			System.out.println(false);
		}
		// Website Heading code.

		String excepted_Heading = "Gopal Medicals";
		String Actual_Title = driver.findElement(By.xpath("//*[@id=\"form1\"]/main/div/header/a/span")).getText();
		if (Actual_Title.equals(excepted_Heading)) {
			System.out.println("The Heading is as expected " );
		} else {
			System.out.println("The Heading is not as expected " );
		}

		
		// title checking

		WebElement getin_Touch = driver.findElement(By.xpath("//*[@id=\"form1\"]/main/div/div/div[2]/div/h2"));
		getin_Touch.getText().equals("Get in Touch!");

		// Contact form code.

		driver.findElement(By.id("txtName")).sendKeys("Pooja");
		driver.findElement(By.id("txtPhoneNumber")).sendKeys("9995910164");
		driver.findElement(By.id("txtEmailAddress")).sendKeys("abc@gmail.com");
		driver.findElement(By.id("txtVisitinfo")).sendKeys("abcvcvvc");
		
		WebElement contactUs = driver.findElement(By.name("ctl07"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", contactUs);

	}

	// Social Media Links

	@Test(priority = 2, enabled = true)
	public void social_media() throws InterruptedException {
		Thread.sleep(3000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement facebook = driver
				.findElement(By.xpath("//*[@id=\"form1\"]/main/div/div/div[2]/div/div[8]/ul/li[2]/a/i"));
		jse.executeScript("arguments[0].click()", facebook);
		Thread.sleep(4000);
		WebElement instagram = driver
				.findElement(By.xpath("//*[@id=\"form1\"]/main/div/div/div[2]/div/div[8]/ul/li[3]/a/i"));
		jse.executeScript("arguments[0].click()", instagram);
		Thread.sleep(5000);
		WebElement youtube = driver
				.findElement(By.xpath("//*[@id=\"form1\"]/main/div/div/div[2]/div/div[8]/ul/li[4]/a/i"));
		jse.executeScript("arguments[0].click()", youtube);
		Thread.sleep(6000);
		WebElement linkedin = driver
				.findElement(By.xpath("//*[@id=\"form1\"]/main/div/div/div[2]/div/div[8]/ul/li[5]/a/i"));
		jse.executeScript("arguments[0].click()", linkedin);
		Thread.sleep(7000);
		WebElement  googlemap= driver
				.findElement(By.xpath("//*[@id=\"form1\"]/main/div/div/div[2]/div/div[8]/ul/li[6]/a/i"));
		jse.executeScript("arguments[0].click()", linkedin);
		Thread.sleep(7000);
		WebElement twitter = driver
				.findElement(By.xpath("//*[@id=\"form1\"]/main/div/div/div[2]/div/div[8]/ul/li[7]/a/i"));
		jse.executeScript("arguments[0].click()", linkedin);
		Thread.sleep(7000);
		WebElement tl_Tech = driver
				.findElement(By.xpath(""));
		jse.executeScript("arguments[0].click()", tl_Tech);

	}

	// Image Carousel
	@Test(priority = 3, enabled = true)
	public void image_carousel() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		String class_Name = "carousel-item";
		List<WebElement> list = driver.findElements(By.className(class_Name));
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			// System.out.println("hello");
			WebElement arrow = driver.findElement(By.xpath("//*[@id=\"myCarousel\"]/a[2]/span[1]"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
			jse.executeScript("arguments[0].click()", arrow);
			driver.quit();
		}

	}

	// Fields name validations.
	@Test(priority = 0, enabled = true)
	public void field_Name_Validations() {
		WebElement name = driver.findElement(By.xpath("//*[@id=\"form1\"]/main/div/div/div[2]/div/div[3]/label"));
		System.out.println("Checking Name field: " + name.getText().equals("Name *"));
		WebElement phone_Number = driver
				.findElement(By.xpath("//*[@id=\"form1\"]/main/div/div/div[2]/div/div[4]/label"));
		System.out.println("Checking Phone number field: " + phone_Number.getText().equals("Phone Number *"));
		WebElement email_Address = driver
				.findElement(By.xpath("//*[@id=\"form1\"]/main/div/div/div[2]/div/div[5]/label"));
		System.out.println("Checking emailaddress field: " + email_Address.getText().equals("Email Address *"));
		WebElement Enquiry = driver.findElement(By.xpath("//*[@id=\"form1\"]/main/div/div/div[2]/div/div[7]/div[1]/label"));
		System.out.println("Checking Enquiry field: " + Enquiry.getText().equals("Enquiry *"));
		

	}
}


