package Foodizon;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Fd_zn {
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
	     driver.get("https://foodizone.shop/");
	     
	}
	@Test(priority = 1, enabled = true)
	public void open() throws InterruptedException {
		// title
		System.out.println("title is " + driver.getTitle());
		String class_Name = "carousel-item";
		List<WebElement> list = driver.findElements(By.className(class_Name));
		System.out.println("image number is = " + list.size());

		// logo
		boolean logo = driver.findElement(By.xpath("//*[@id=\"form1\"]/main/div/header/a/img")).isDisplayed();
		if (logo) {
			System.out.println("logo is present");
		} else {
			System.out.println("logo is not present");
		}

		// form validation
		driver.findElement(By.name("txtName")).sendKeys("pooj");
		driver.findElement(By.id("txtPhoneNumber")).sendKeys("8123453456");
		WebElement brand = driver.findElement(By.id("ddrequirement"));
		Select branddetails = new Select(brand);
		branddetails.selectByVisibleText("CHEMEEN KIZHI");
		driver.findElement(By.id("txtVisitinfo")).sendKeys("abc.trivandrum");
		driver.findElement(By.id("txtNotesinfo")).sendKeys("hbghfbhhfhdfhdfhdd");
		Thread.sleep(2000);
		// button
		WebElement button = driver.findElement(By.name("ctl07"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", button);
	}

	@Test(priority = 2, enabled = true)
	public void socialmedia() {
		// google map
		WebElement map = driver.findElement(By.xpath("//*[@id=\"form1\"]/main/div/div/div[2]/div/div[8]/ul/li[1]/a/i"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", map);
		// facebook
		WebElement facebook = driver
				.findElement(By.xpath("//*[@id=\"form1\"]/main/div/div/div[2]/div/div[8]/ul/li[2]/a"));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", facebook);
		// instagram
		WebElement instagram = driver
				.findElement(By.xpath("//*[@id=\"form1\"]/main/div/div/div[2]/div/div[8]/ul/li[3]/a"));
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("arguments[0].click();", instagram);
		// youtube
		WebElement youtube = driver
				.findElement(By.xpath("//*[@id=\"form1\"]/main/div/div/div[2]/div/div[8]/ul/li[4]/a"));
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		js3.executeScript("arguments[0].click();", youtube);
		// linkedin
		WebElement linkedin = driver
				.findElement(By.xpath("//*[@id=\"form1\"]/main/div/div/div[2]/div/div[8]/ul/li[5]/a"));
		JavascriptExecutor js4 = (JavascriptExecutor) driver;
		js4.executeScript("arguments[0].click();", linkedin);
		// pinrest
		WebElement pinrest = driver
				.findElement(By.xpath("//*[@id=\"form1\"]/main/div/div/div[2]/div/div[8]/ul/li[6]/a"));
		JavascriptExecutor js5 = (JavascriptExecutor) driver;
		js5.executeScript("arguments[0].click();", pinrest);
		// twitter
		WebElement twitter = driver
				.findElement(By.xpath("//*[@id=\"form1\"]/main/div/div/div[2]/div/div[8]/ul/li[7]/a"));
		JavascriptExecutor js6 = (JavascriptExecutor) driver;
		js6.executeScript("arguments[0].click();", twitter);
		// tl logo
		WebElement logo = driver.findElement(By.xpath("//*[@id=\"form1\"]/main/div/div/div[2]/div/div[8]/div/img"));
		JavascriptExecutor js7 = (JavascriptExecutor) driver;
		js7.executeScript("arguments[0].click();", logo);
		// tl footer
		WebElement footer = driver.findElement(By.xpath("//*[@id=\"form1\"]/main/div/div/footer/div/p/a"));
		JavascriptExecutor js8 = (JavascriptExecutor) driver;
		js8.executeScript("arguments[0].click();", footer);
	}
}



