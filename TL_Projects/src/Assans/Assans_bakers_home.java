package Assans;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assans_bakers_home {

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
	     driver.get("https://assans.in/");
	     
	}
	

@Test(priority=0)
public void load()
{
driver.findElement(By.id("txtName")).sendKeys("sichin");
driver.findElement(By.id("txtPhoneNumber")).sendKeys("9895251516");
driver.findElement(By.xpath("//*[@id=\"txtEmailAddress\"]")).sendKeys("sichinc6969@gmail.com");
driver.findElement(By.id("txtNumberOfGuest")).sendKeys("10");
driver.findElement(By.id("txtVisitinfo")).sendKeys("Vancho");
}
@Test(priority=1,enabled=false)
public void loading()
{
//Facebook
WebElement java = driver.findElement(By.xpath("//*[@id=\"form1\"]/main/div/div/div[2]/div/div[11]/ul/li[1]/a"));
JavascriptExecutor js = (JavascriptExecutor)driver;
js.executeScript("arguments[0].click();", java);
//instagram
WebElement java1 = driver.findElement(By.xpath("//*[@id=\"form1\"]/main/div/div/div[2]/div/div[11]/ul/li[2]/a/i"));
JavascriptExecutor js1 = (JavascriptExecutor)driver;
js1.executeScript("arguments[0].click();", java1);
//youtube
WebElement java2 = driver.findElement(By.xpath("//*[@id=\"form1\"]/main/div/div/div[2]/div/div[11]/ul/li[3]/a/i"));
JavascriptExecutor js2 = (JavascriptExecutor)driver;
js2.executeScript("arguments[0].click();", java2);
//linkedin
WebElement java3 = driver.findElement(By.xpath("//*[@id=\"form1\"]/main/div/div/div[2]/div/div[11]/ul/li[4]/a/i"));
JavascriptExecutor js3 = (JavascriptExecutor)driver;
js3.executeScript("arguments[0].click();", java3);

}
/*public void calender() {

{
	driver.findElement(By.id("datepicker")).click();
	while(true)
		{
		WebElement month=driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div"));
		String month1=month.getText();
		if(month1.equals("February 2023")) 
		{
			System.out.println(month1);
			break;
		}
		else {
			driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]")).click();
		}
				
}

List<WebElement>alldetails=driver.findElements(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr/td/a"));
for(WebElement dateelement:alldetails)
{
	String date=dateelement.getAttribute("data-day");
	System.out.println(date);
	if(date.equals("6"))
	{
		
		System.out.println(date);
		dateelement.click();
		System.out.println("date selected");
	}

	

}}*/
}
