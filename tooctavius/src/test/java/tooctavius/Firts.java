package tooctavius;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.*;




public class Firts {
	
	
	public String baseUrl = "http://octaviusqa.24livehost.com";
	String driverPath = "D://chromedriver_win32//chromedriver.exe";
	public WebDriver driver ;
	
	@BeforeTest
	public void launchBrowser() {
		System.out.println("launching Chrome browser");
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.manage().window().maximize(); 

}
	
	@Test()
	public void CheckPageURL() {

		String url1=driver.getCurrentUrl();
		//System.out.println(url1);

		if (url1.contains("https://octaviusqa.24livehost.com/")){
			System.out.println("URL Verification: "+ "This is correct URL -https://octaviusqa.24livehost.com/ – Passed");
		}
		else{
			System.out.println("URL Verification: “+ “It is Not an Internal Link – Failed");
		}
	}
	
	
	@Test
	public void CheckTextFind() {
		String url1=driver.getCurrentUrl();
		WebElement textDemo = driver.findElement(By.xpath("/html/body/div/div/main/div/div/h1"));
		if(textDemo.isDisplayed())
		{
		System.out.println("Element found using text");
		}
		 
		else
		System.out.println("Element not found");
		}
	
	@Test
	public void CheckBrowserTitleText() {
		String expectedTitle = "Octavius Login";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test
	public void LogoCheck() throws InterruptedException {
		//verify image
        WebElement ImageFile = driver.findElement(By.xpath("/html/body/div/div/div/img"));
        Thread.sleep(5000);
        Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", ImageFile);

        if (ImagePresent)
        {
        System.out.println("Image displayed.");
        }
        else
        {
        System.out.println("Image not displayed.");
        }
	}
	@Test
	public void IsLogintextboxEmpty() throws InterruptedException {
		/*Here Check The Case of Text Box Null? */
		WebElement Ele = driver.findElement(By.xpath("//*[@id=\"Email\"]"));
		String Clob = Ele.getAttribute("value");
		if(Clob.isEmpty()) {
			System.out.println("Yes Email Text Box Is Clear");
		}else {
			System.out.println("No Email Text Box is not Clear");
		}
	}
	@Test
	public void IsPasswordtextboxEmpty() throws InterruptedException {
		/*Here Check The Case of Text Box Null? */
		WebElement Ele = driver.findElement(By.xpath("//*[@id=\"PasswordHash\"]"));
		String Clob = Ele.getAttribute("value");
		if(Clob.isEmpty()) {
			System.out.println("Yes Password text box Is Clear");
		}else {
			System.out.println("No Password text box is not Clear");
		}
	}
	@Test
	public void CheckEmailValidationErrorMessage() {
		 WebElement t = driver.findElement(By.xpath("//*[@id=\"LoginFrm\"]/div/div[3]/button"));
	      t.click();
	      //expected error text
	      String exp = "Please enter email";
	      //identify actual error message
	      WebElement m = driver.findElement(By.xpath("//*[@id=\"Email-error\"]"));
	      String act = m.getText();
	      System.out.println("Email Error message is: "+ act);
	      //verify error message with Assertion
	      Assert.assertEquals(exp, act);
	      
	}
	@Test
	public void CheckPasswordValidationErrorMessage() {
		 WebElement t = driver.findElement(By.xpath("//*[@id=\"PasswordHash\"]"));
	      t.click();
	      //expected error text
	      String exp = "Please enter password";
	      //identify actual error message
	      WebElement m = driver.findElement(By.xpath("//*[@id=\"PasswordHash-error\"]"));
	      String act = m.getText();
	      System.out.println("Password Error message is: "+ act);
	      //verify error message with Assertion
	      Assert.assertEquals(exp, act);
	      
	}
	@Test
	public void CheckForgotPasswordLink() {
		try{
			boolean linkExistence=driver.findElement(By.linkText("Forgot Password?")).isDisplayed();

			if (linkExistence == true){
				System.out.println("Forgot Password Link Exists – Passed");
			}
		}
		catch(NoSuchElementException e){
			System.out.println("Forgot Password Link Not Exists – Failed");
		}
	}
	
	
	
	@AfterTest
	public void terminateBrowser(){
		driver.close();
		System.out.println("Browser is Down successfully");
	}
}