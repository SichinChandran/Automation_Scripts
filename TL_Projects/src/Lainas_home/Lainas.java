package Lainas_home;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lainas {

	WebDriver driver;
	/*@BeforeTest
	/*public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	@BeforeMethod
	public void url()
	{
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	     driver.get("https://www.lainashomestay.in/");
	     
	}*/

	@Parameters("Browser")
	@BeforeTest

	//cross browser testing code.
	public void foodizonecrossbrowsertesting(String browserName) {
			
			if(browserName.equalsIgnoreCase("Chrome")) {
				WebDriverManager.chromedriver().setup();
				driver =  new ChromeDriver();
			}
			else if(browserName.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
			else if(browserName.equalsIgnoreCase("Microsoft Edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get("https://www.lainashomestay.in/");
		
		
	}

	      @Test(priority=0,enabled=true)
	      public void open() {
	    	  //title
	    	  System.out.println("title is " +driver.getTitle());
	    	  //image
	    	  String class_Name = "carousel-item";
				List<WebElement> list = driver.findElements(By.className(class_Name));
				System.out.println("image number is = "+list.size());
	  		//driver.findElement(By.xpath("//*[@id=\"myCarousel\"]/a[2]/span[1]")).click();
	    	  //logo
	  		boolean logo =driver.findElement(By.xpath("//*[@id=\"form1\"]/main/div/header/a/img")).isDisplayed();
	  		if(logo)
	  		{
	  			System.out.println("logo is present");
	  		}
	  		else
	  		{
	  			System.out.println("logo is not present");
	  		}}
	  		 @Test(priority=1)
		      public void form() throws InterruptedException {
	  
	    //form validation  
		driver.findElement(By.id("txtName")).sendKeys("pooj");
		driver.findElement(By.id("txtPhoneNumber")).sendKeys("9845678998");
		driver.findElement(By.cssSelector("#txtEmailAddress")).sendKeys("poo@mail.com");
		WebElement brand=driver.findElement(By.id("ddrequirement"));
		Select branddetails=new Select(brand);
		branddetails.selectByVisibleText("PAYING GUEST");
		driver.findElement(By.id("txtEventType")).sendKeys("500");
		driver.findElement(By.id("TextBox1")).sendKeys("19/03/2023");
		Thread.sleep(2000);
		WebElement form=driver.findElement(By.id("form1"));
		form.click();
		
		  WebElement notes=driver.findElement(By.cssSelector("#txtVisitinfo"));
		  notes.sendKeys("vgvgvgbg");
		  
		  WebElement button = driver.findElement(By.name("ctl07"));
	      JavascriptExecutor js = (JavascriptExecutor)driver;
	      js.executeScript("arguments[0].click();", button);
	        
	        }
	    
	@Test(priority=1,enabled=true)
	public void socialmedia() {
		
	     //facebook   
	        WebElement facebook = driver.findElement(
	                By.xpath("//*[@id=\"form1\"]/main/div/div/div[2]/div/div[8]/ul/li[1]/a"));
	           JavascriptExecutor js1 = (JavascriptExecutor)driver;
	          js1.executeScript("arguments[0].click();", facebook);
	          //instagram
	          WebElement instagram = driver.findElement(
	                  By.xpath("//*[@id=\"form1\"]/main/div/div/div[2]/div/div[8]/ul/li[2]/a"));
	             JavascriptExecutor js2 = (JavascriptExecutor)driver;
	            js2.executeScript("arguments[0].click();", instagram);
	     
	            //linkedin
	              WebElement linkedin = driver.findElement(
	                      By.xpath("//*[@id=\"form1\"]/main/div/div/div[2]/div/div[8]/ul/li[4]/a"));
	                 JavascriptExecutor js3 = (JavascriptExecutor)driver;
	                js3.executeScript("arguments[0].click();", linkedin);
	            
	            //tl logo
	                    WebElement logo = driver.findElement(
	                            By.xpath("//*[@id=\"form1\"]/main/div/div/div[2]/div/div[9]/ul/li/a"));
	                       JavascriptExecutor js4 = (JavascriptExecutor)driver;
	                      js4.executeScript("arguments[0].click();", logo);
	          //tl footer
	                      WebElement footer = driver.findElement(
	                              By.xpath("//*[@id=\"form1\"]/main/div/div/footer/div/p/a"));
	                         JavascriptExecutor js5 = (JavascriptExecutor)driver;
	                        js5.executeScript("arguments[0].click();", footer);  
	}
	//Fields name validations.
	@Test(priority = 2, enabled = true)
	public void field_Name_Validations() {
		WebElement name = driver.findElement(By.xpath("//*[@id=\"form1\"]/main/div/div/div[2]/div/div[3]/label"));
		System.out.println("Checking Name field: " + name.getText().equals("Name *"));
		WebElement phone_Number = driver
				.findElement(By.xpath("//*[@id=\"form1\"]/main/div/div/div[2]/div/div[4]/label"));
		System.out.println("Checking Phone number field: " + phone_Number.getText().equals("Phone Number *"));
		WebElement email = driver
				.findElement(By.xpath("//*[@id=\"form1\"]/main/div/div/div[2]/div/div[5]/label"));
		System.out.println("Checking emailaddress field: " + email.getText().equals("Email Address *"));
		
		WebElement selectservice = driver.findElement(By.xpath("//*[@id=\"form1\"]/main/div/div/div[2]/div/div[6]/label"));
		System.out.println("Checking select service field: " + selectservice.getText().equals("Select Service *"));
		WebElement noofpeople = driver
				.findElement(By.xpath("//*[@id=\"form1\"]/main/div/div/div[2]/div/div[7]/div[1]/div/label"));
		System.out.println("Checking no.of people field: " + noofpeople.getText().equals("No:of people*"));
		WebElement checkindate = driver.findElement(By.xpath("//*[@id=\"form1\"]/main/div/div/div[2]/div/div[7]/div[2]/div/label/span/small"));
		System.out.println("Checking checkindate field: " + checkindate.getText().equals("Check-in Date *"));
		WebElement notes = driver.findElement(By.xpath("//*[@id=\"form1\"]/main/div/div/div[2]/div/div[7]/div[3]/label"));
		System.out.println("Checking notes field: " + notes.getText().equals("Notes*"));
		
	}
	  	}

//calander
/* String month="march 2023";
  driver.findElement(By.xpath("//*[@id=\"TextBox1\"]")).click();
  while(true){
	  String text=driver.findElement(By.xpath("/html/body/div/div[3]/ul[1]/li[2]")).getText();
	  if(text.equals(month)) {
		  break;
	  }else {
		  driver.findElement(By.xpath("/html/body/div/div[3]/ul[1]/li[3]")).click();
	  }
  }
  driver.findElement(By.xpath("/html/body/div/div[3]/ul[3]/li[18]")).click();
*/

