package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class amazon {
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
	     driver.get("https://www.amazon.in/");
	     
	}
	

@Test(priority=0)
public void load()
{
	
	// Logo checking
			Boolean logo = driver.findElement(By.xpath("//*[@id=\"nav-logo-sprites\"]")).isDisplayed();
			if (logo) {
				System.out.println("Logo Visible");
			} else {
				System.out.println("Logo Invisible");
			}
			
			driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[4]")).click();

}
}
