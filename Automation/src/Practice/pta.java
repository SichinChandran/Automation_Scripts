package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class pta {
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
	     driver.get("https://practicetestautomation.com/practice-test-login/");
	     
	}
	

@Test(priority=0)
public void load()
{
	
	// Logo checking
			Boolean logo = driver.findElement(By.xpath("//*[@id=\"site-title\"]/a/img")).isDisplayed();
			if (logo) {
				System.out.println("Logo Visible");
			} else {
				System.out.println("Logo Invisible");
			}
			
			driver.findElement(By.xpath("//*[@id=\"menu-item-43\"]/a")).click();
			driver.findElement(By.xpath("//*[@id=\"menu-item-20\"]/a")).click();
			driver.findElement(By.xpath("//*[@id=\"menu-item-21\"]/a")).click();
			driver.findElement(By.xpath("//*[@id=\"menu-item-19\"]/a")).click();
			driver.findElement(By.xpath("//*[@id=\"menu-item-18\"]/a")).click();
	/*driver.findElement(By.id("username")).sendKeys("sichin");
	driver.findElement(By.id("password")).sendKeys("Password2020");*/
}

}
