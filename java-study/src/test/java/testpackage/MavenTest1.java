package testpackage;  


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;  
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.HasDownloads;
import org.testng.annotations.AfterTest;  
import org.testng.annotations.BeforeTest;  
import org.testng.annotations.Test;
import java.time.Duration;


public class MavenTest1 {  
public String baseUrl = "https://opensource-demo.orangehrmlive.com/";  
public WebDriver driver;  
String driverPath = "src/test/resources/Driver/chromedriver.exe";  
		@Test     
		public void test() 
		{      
			//set the system property for Chrome driver      
			System.setProperty("webdriver.chrome.driver", driverPath);
			
		
			//Create driver object for CHROME browser  
			//WebDriver driver = new ChromeDriver();
			 
			// Create an instance of ChromeDriver	
			driver = new ChromeDriver(); 
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.manage().window().maximize();  
			

			
			// Navigate to the web site, can use driver.get("https:..")
			driver.get(baseUrl);  
			
			
			//Locate the user name input field by name attribute and input the user name
			WebElement username = driver.findElement(By.name("username"));
			username.sendKeys("Admin");
			
			//Locate the password input field by name attribute and input the password
			WebElement password = driver.findElement(By.name("password"));
			password.sendKeys("admin123");
			
			// Locate and click the login button using CSS selector
		    WebElement loginButton = driver.findElement(By.cssSelector("button.orangehrm-login-button"));
		    loginButton.click();
		    
		    // Locate the element by CSS selector
		    //WebElement element = driver.findElement(By.className("oxd-icon"));
		    WebElement element = driver.findElement(By.className("oxd-userdropdown-tab"));
		    // Get the text content of the element
		    String name = element.getText();
		    // Print the name
		    System.out.println(name);
		    
		    
			// Navigate to the Admin page by locate and click the Admin button using CSS selector
		    WebElement AdminButton = driver.findElement(By.className("oxd-main-menu-item"));
		    AdminButton.click();
		
			//get the current URL of the page  
			String URL= driver.getCurrentUrl();  
			System.out.print(URL);  
		
			//get the title of the page  
			String title = driver.getTitle();                  
			System.out.println(title);  
		}     

		@BeforeTest  
		public void beforeTest() 
		{    
			System.out.println("Before test");  
		}     
		
		@AfterTest
		public void afterTest() {
		    System.out.println("After test");
		}   
}  
