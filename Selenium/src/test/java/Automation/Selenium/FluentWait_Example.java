package Automation.Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class FluentWait_Example {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/Drivers/geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		Thread.sleep(50);
		driver.manage().window().maximize();
		driver.navigate().to("https://www.flipkart.com/");
		
		WebDriverWait wait1=new WebDriverWait(driver, 2);
		wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='✕']")));
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		
		driver.navigate().refresh();
		Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
				.withTimeout(10, TimeUnit.SECONDS)
				.pollingEvery(1, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		
		WebElement bbd = wait.until(new Function<WebDriver, WebElement>() 
		{
		  public WebElement apply(WebDriver driver) {
		  return driver.findElement(By.xpath("(//img[@alt='BBD'])[2]"));
		}
		
		});
		
		bbd.click();
	}

}
