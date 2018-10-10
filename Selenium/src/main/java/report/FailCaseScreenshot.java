package report;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Automation.Selenium.Base;

@Listeners(Automation.Selenium.TestngListeners.class)
public class FailCaseScreenshot extends Base
{
	WebDriver driver;
	@BeforeMethod
	public void beforemethod()
	{
		this.driver=initialiazation();
	}
	
	@Test
	public void flipkart()
	{
		driver.get("https://www.flipkart.com/?");
	}
	
	@Test
	public void maven()
	{
		driver.get("https://mvnrepository.com/artifact/commons-io/commons-io/2.6");
		assertTrue(false);
	}
}
