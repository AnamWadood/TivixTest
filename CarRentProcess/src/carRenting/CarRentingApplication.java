package carRenting;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;

public class CarRentingApplication {
public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");		
		WebDriver driver = new ChromeDriver();   
		//Applying Wait
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		//Navigating to the website
		String Url = "http://qalab.pl.tivixlabs.com/";
	    driver.get(Url);
	    System.out.println( "Successfully navigated to the web site");
	    // maximize the browser window
	    driver.manage().window().maximize();
	     
	    //Enter Model on Landing page
	    WebElement modelName= driver.findElement(By.id("model"));
	    modelName.sendKeys("Toyota");
	     
	    //Choose pickup date
	    WebElement pickupDate= driver.findElement(By.cssSelector("input[id='pickup']"));
	    pickupDate.sendKeys("01-01-2020");
	    System.out.println( "Pick Up date is entered"); 
	    //Choose Drop off date
	    WebElement dropOffDate= driver.findElement(By.cssSelector("input[id='dropoff']"));
	    dropOffDate.sendKeys("06-01-2020");
	    System.out.println( "Drop off date is entered");
	  
	    //Clicking on Search button at the bottom
	    WebElement searchButton= driver.findElement(By.cssSelector("button[class='btn btn-primary']"));
		searchButton.click();
		 
		//Explicit wait -Waiting for Rent button to appear on page so that it can be clicked
	    WebDriverWait wait = new WebDriverWait(driver,30);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[class='btn btn-success']")));

		//Clicking on the second Car row Rent button according to index value. User can click on any button by changing the index
		List<WebElement> carListRentButton = driver.findElements(By.cssSelector("a[class='btn btn-success']"));
		carListRentButton.get(1).click();
		//Waiting for sometime
		Thread.sleep(3000);
		 
		WebElement carDetailsRentButton = driver.findElement(By.cssSelector("a[class='btn btn-primary']"));
		carDetailsRentButton.click();
		Thread.sleep(3000);
		 
		//Entering details in Rent Form
		//Entering name in rent form
		WebElement name= driver.findElement(By.cssSelector("input[id='name']"));
		name.sendKeys("TestName");
		System.out.println( "Name is entered successfully");
		    
		//Entering Last Name in rent form
		WebElement lastName= driver.findElement(By.cssSelector("input[id='last_name']"));
		lastName.sendKeys("TestLastName");
		System.out.println( "Last name entered successfully"); 
		
		//Entering Card Number in rent form
		WebElement cardNumber= driver.findElement(By.cssSelector("input[id='card_number']"));
		cardNumber.sendKeys("0011234");
		System.out.println( "Card No. entered successfully");	
		
		//Entering Email Address in rent form
		WebElement emailAddress= driver.findElement(By.cssSelector("input[id='email']"));
		emailAddress.sendKeys("abc@test.com");
		System.out.println( "Email entered successfully");
		
		//Clicking on Rent button to confirm
		WebElement rentTab = driver.findElement(By.cssSelector("button[class='btn btn-primary']"));
		rentTab.click();
		System.out.println( "Rent button clicked-Test case Passed") ;
		
		//Closing the browser window
		driver.close();
	}

}
