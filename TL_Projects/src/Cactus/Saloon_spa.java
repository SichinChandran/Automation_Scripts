package Cactus;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Saloon_spa {
	WebDriver driver;

	@BeforeTest
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	/*@Parameters("Browser")
	public void cross_Browser(String browser_Name) {
		if (browser_Name.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser_Name.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser_Name.equalsIgnoreCase("Microsoft Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			System.out.println("Sorry");
		}*/
	public void url()
	{


		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://booking.cactus-salonspa.com/");
		System.out.println(driver.getTitle().equals(""));
	}

	@Test
	public void enquiryForm() throws InterruptedException {
		// Title checking.

		String excepted_Title = "CACTUS";
		String title = driver.getTitle();
		if (title.equals(excepted_Title)) {
			System.out.println("The Title : " + true);
		} else {
			System.out.println(false);
		}

		// Heading checking
		
		String excepted_Heading = "CACTUS";
		String Actual_Title = driver.findElement(By.xpath("//*[@id=\"form1\"]/main/div/header/a/span")).getText();
		if (Actual_Title.equals(excepted_Heading)) {
			System.out.println("The Heading is as expected "+ true);
		} else {
			System.out.println("The Heading is not as expected "+ false);
		}
		
		//logo checking
		
		Boolean logo = driver.findElement(By.xpath("//*[@id=\"form1\"]/main/div/header/a/img")).isDisplayed();
		if (logo) {
			System.out.println("Logo Visible");
		} else {
			System.out.println("Logo Invisible");
		}
		
		//title checking
		
				WebElement getin_Touch = driver.findElement(By.xpath("//*[@id=\"form1\"]/main/div/div/div[2]/div/h2"));
				System.out.println("The title of the form is visible: " +getin_Touch.getText().equals("Book Your Appointment!"));
				
				// Contact form code.
				
				driver.findElement(By.xpath("//*[@id=\"txtName\"]")).sendKeys("Parvathi");
				driver.findElement(By.xpath("//*[@id=\"txtPhoneNumber\"]")).sendKeys("9995910164");
				Select service = new Select(driver.findElement(By.name("ddrequirement")));
				service.selectByIndex(4);
//				WebElement selectDate = driver.findElement(By.xpath("//*[@id=\"TextBox1\"]"));
//		        
//			    selectDate.click();
//			    while(true) {
//			    	WebElement month = driver.findElement(By.xpath("/html/body/div/div[3]/ul[1]/li[2]"));
//			    	String month_Name = month.getText();
//			    	if(month_Name.equals("May 2023")) {
//			    		System.out.println(month_Name);
//						break;
//			    	}
//			    	else {
//			    		driver.findElement(By.xpath("/html/body/div/div[3]/ul[1]/li[3]")).click();
//			    	}
//			    }
			   
			driver.findElement(By.xpath("//*[@id=\"txtVisitinfo\"]")).sendKeys("Hello");
			Thread.sleep(3000);
			WebElement contactUs = driver.findElement(By.name("ctl07"));
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].click()", contactUs);

	}
	}



