package report;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ScreenShots
{
	public static WebDriver driver;
	
	@Test
	public void checkingScreenShotOption() throws IOException
	{
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/Drivers/geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get("https://mvnrepository.com/artifact/commons-io/commons-io/2.6");
		TakeScreenshot("Hello");
	}
	
	public static void TakeScreenshot(String testName) throws IOException
	{
		System.out.println("in screen");
		TakesScreenshot shot=((TakesScreenshot)driver);
		System.out.println("1");
		File scrFile=shot.getScreenshotAs(OutputType.FILE);
		System.out.println("2");
		FileUtils.copyFile(scrFile, new File("./Screenshots/"+testName+".png"));
		System.out.println("3");
		
	}
}
