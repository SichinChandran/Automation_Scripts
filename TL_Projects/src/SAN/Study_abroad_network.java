package SAN;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Study_abroad_network {
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
		driver.get("https://apply.studyabroadnetworks.com/");
		System.out.println(driver.getTitle().equals("Study Abroad Network"));
	}

	@Test(priority =0)
	public void enquiry_Form() throws InterruptedException {
		// Title Checking

		String excepted_Title = "Study Abroad Network";
		String title = driver.getTitle();
		if (title.equals(excepted_Title)) {
			System.out.println("The Title is : " + title);
		} else {
			System.out.println(false);
		}

		// Heading checking

		String excepted_Heading = "Study Abroad Network";
		String Actual_Title = driver.findElement(By.xpath("//*[@id=\"form1\"]/main/div/header/a/span")).getText();
		if (Actual_Title.equals(excepted_Heading)) {
			System.out.println("The Heading is as expected " + true);
		} else {
			System.out.println("The Heading is not as expected " + false);
		}
		// logo checking

		Boolean logo = driver.findElement(By.xpath("//*[@id=\"form1\"]/main/div/header/a/img")).isDisplayed();
		if (logo) {
			System.out.println("Logo Visible");
		} else {
			System.out.println("Logo Invisible");
		}
		// title checking

		WebElement getin_Touch = driver.findElement(By.xpath("//*[@id=\"form1\"]/main/div/div/div[2]/div/h2"));
		System.out.println("The title of the form is visible: " + getin_Touch.getText().equals("Get in Touch!"));

		// Contact Form

		driver.findElement(By.id("txtName")).sendKeys("Parvathi");
		driver.findElement(By.xpath("//*[@id=\"txtPhoneNumber\"]")).sendKeys("9995910164");
		driver.findElement(By.xpath("//*[@id=\"txtEmailAddress\"]")).sendKeys("sparvathi0164@gmail.com");
		Select course = new Select(driver.findElement(By.xpath("//*[@id=\"ddrequirement\"]")));
		course.selectByValue("B.Sc. Radiology");
		Select joining_Year = new Select(driver.findElement(By.xpath("//*[@id=\"DropDownList1\"]")));
		joining_Year.selectByIndex(1);
		Select joining_Month = new Select(driver.findElement(By.xpath("//*[@id=\"DropDownList2\"]")));
		joining_Month.selectByIndex(5);
		driver.findElement(By.xpath("//*[@id=\"txtNotesinfo\"]")).sendKeys("Hello");
		Thread.sleep(3000);

		// Button Click

		WebElement contactUs = driver.findElement(By.name("ctl11"));
		JavascriptExecutor
		jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", contactUs);
	}

	// field checking

	@Test(priority = 0, enabled = true)
	public void field_Name_Validations() {
		WebElement name = driver.findElement(By.xpath("//*[@id=\"form1\"]/main/div/div/div[2]/div/div[3]/label"));
		System.out.println("Checking Name field: " + name.getText().equals("Name *"));
		WebElement phone_Number = driver
				.findElement(By.xpath("//*[@id=\"form1\"]/main/div/div/div[2]/div/div[4]/div[1]/div/label"));
		System.out.println("Checking Phone number field: " + phone_Number.getText().equals("Phone Number *"));
		WebElement email_Address = driver
				.findElement(By.xpath("//*[@id=\"form1\"]/main/div/div/div[2]/div/div[4]/div[2]/div/label"));
		System.out.println("Checking emailaddress field: " + email_Address.getText().equals("Email Address *"));
		WebElement courses = driver.findElement(By.xpath("//*[@id=\"form1\"]/main/div/div/div[2]/div/div[5]/label"));
		System.out.println("Checking course field: " + courses.getText().equals("Select Course *"));
		WebElement year = driver
				.findElement(By.xpath("//*[@id=\"form1\"]/main/div/div/div[2]/div/div[6]/div[3]/div[1]/div/label"));
		System.out.println("Checking joining year field: " + year.getText().equals("Joining Year *"));
		WebElement month = driver
				.findElement(By.xpath("//*[@id=\"form1\"]/main/div/div/div[2]/div/div[6]/div[3]/div[2]/div/label"));
		System.out.println("Checking joining month field: " + month.getText().equals("Joining Month *"));
		WebElement notes = driver
				.findElement(By.xpath("//*[@id=\"form1\"]/main/div/div/div[2]/div/div[6]/div[3]/div[3]/label"));
		System.out.println("Checking notes field: " + notes.getText().equals("Notes"));

	}

	// social media checking.

	@Test(priority = 2, enabled = true)
	public void social_media() throws InterruptedException {
		Thread.sleep(3000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement facebook = driver
				.findElement(By.xpath("//*[@id=\"form1\"]/main/div/div/div[2]/div/div[6]/div[4]/ul/li[1]/a"));
		jse.executeScript("arguments[0].click()", facebook);
		Thread.sleep(4000);
		WebElement instagram = driver
				.findElement(By.xpath("//*[@id=\"form1\"]/main/div/div/div[2]/div/div[6]/div[4]/ul/li[2]/a"));
		jse.executeScript("arguments[0].click()", instagram);
		Thread.sleep(5000);
		WebElement youtube = driver
				.findElement(By.xpath("//*[@id=\"form1\"]/main/div/div/div[2]/div/div[6]/div[4]/ul/li[3]/a"));
		jse.executeScript("arguments[0].click()", youtube);
		Thread.sleep(6000);
		WebElement linkedin = driver
				.findElement(By.xpath("//*[@id=\"form1\"]/main/div/div/div[2]/div/div[6]/div[4]/ul/li[4]/a"));
		jse.executeScript("arguments[0].click()", linkedin);
		Thread.sleep(7000);
		WebElement pintrest = driver
				.findElement(By.xpath("//*[@id=\"form1\"]/main/div/div/div[2]/div/div[6]/div[4]/ul/li[5]/a"));
		jse.executeScript("arguments[0].click()", pintrest);
		Thread.sleep(8000);
		WebElement tl_Tech = driver
				.findElement(By.xpath("//*[@id=\"form1\"]/main/div/div/div[2]/div/div[6]/div[4]/div/ul/li/a"));
		jse.executeScript("arguments[0].click()", tl_Tech);

	}

	@AfterTest
	public void browser_Close() throws InterruptedException {
		Thread.sleep(5000);
		

}
}
