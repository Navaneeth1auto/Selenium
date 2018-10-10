package Listener;



import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Automation.Selenium.Base;

@Listeners(Automation.Selenium.TestngListeners.class)
public class ListenersExample extends Base {
	Logger log;
	WebDriver driver;
	@BeforeClass
	public void initializingLogger()
	{
		log=Logger.getLogger(ListenersExample.class);
		PropertyConfigurator.configure("log4j.properties");
		
	}
	
	@BeforeMethod
	public void init()
	{
		log.info("driver initialiazed");
		driver=initialiazation();
	}
	
	/*@Test(priority = 1)
	public void listeners() {
		
		driver.get("https://www.flipkart.com/");
	}*/

	@Test(priority = 2)
	public void failedTest() {
		System.out.println("failedTest started");
		//driver.get("https://www.flipkart.com/");
		Assert.assertTrue(false);
		log.error("failedTest completed");
	}
	
	/*@AfterMethod
	public void tearDown()
	{
		System.out.println("closing");
		driver.quit();
	}*/
}
