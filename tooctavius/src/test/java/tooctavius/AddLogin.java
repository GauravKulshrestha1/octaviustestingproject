package tooctavius;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

	public class AddLogin {

	public String baseUrl = "http://octaviusqa.24livehost.com";
	String driverPath = "D://chromedriver_win32//chromedriver.exe";
	public WebDriver driver ;
	private Object actualError;
	
	@BeforeTest
	public void launchBrowser() {
		System.out.println("launching Chrome browser");
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.manage().window().maximize(); 

	}
	@Test
	public void InsertCredentialsEmai() throws InterruptedException {
		/* Pass Email Here */
	WebElement der = driver.findElement(By.id("Email"));
	der.sendKeys("adminoctavius@yopmail.com");
	String val = der.getAttribute("value");
    System.out.println("Entered text is: " + val);
	Thread.sleep(5000);
	driver.findElement(By.id("PasswordHash")).sendKeys("Test@123");
	Thread.sleep(5000);
	driver.findElement(By.xpath("//*[@id=\"LoginFrm\"]/div/div[3]/button")).click();
	
	System.out.println("To login click on Login Button");
	String actualUrl="https://octaviusqa.24livehost.com/Admin/SiteManagement/Index"; 
	  String expectedUrl= driver.getCurrentUrl(); 
	  if(actualUrl.equalsIgnoreCase(expectedUrl))
	  { 
	  System.out.println("Admin Login is Successful – Passed"); 
	  } else 
	  {
		  	System.out.println("Admin Login is Unsuccessful – Failed"); }
	  	}
	@Test
	public void logout() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"navbarDropdown\"]")).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Sign out")).click();
		System.out.println("Logout successfully");
		Thread.sleep(5000);
	}
	/*@Test 
	public void CheckInvalidcredentials() throws InterruptedException {
		Thread.sleep(5000);
		String actualMsg = driver.findElement(By.xpath("//*[@id=\"ErrorMsg\"]")).getText();
  		String errorMsg= "Invalid credentials";
  		if(actualMsg.equals(errorMsg)) {
	        System.out.println("Invalid User Message Found");
	    }else{
	        System.out.println("Invalid User Message Not Found");
	    }

		
	}*/
	
	@AfterTest
	public void terminateBrowser(){
	driver.close();
	System.out.println("Browser is Down successfully");
}
}