package report;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Automation.Selenium.Base;

public class ExtentReportsWithScreenshots extends Base
{
	static WebDriver driver;
	public ExtentReports report;
	public ExtentTest log;
	@BeforeClass
	public void beforeclass()
	{
		driver=initialiazation();
		report=new ExtentReports("./shotsReport.html", false);
		log=report.startTest("ExtentReportsWithScreenshots.class");
	}
	
	@Test
	public void loginFlipkart() throws IOException
	{
		log.log(LogStatus.INFO, "trying to login to flipkart");
		driver.get("https://www.flipkart.com/");
		String filePath=extentScreenShots();
		log.log(LogStatus.ERROR, log.addScreenCapture(filePath));
	}
	
	@AfterClass
	public void closing()
	{
		report.endTest(log);
		report.flush();
	}
	
	public static String extentScreenShots() throws IOException
	{
		TakesScreenshot shot=(TakesScreenshot)driver;
		File srcFile=shot.getScreenshotAs(OutputType.FILE);
		String destFile="./Screenshots/temp.png";
		FileUtils.copyFile(srcFile, new File(destFile));
		return destFile;
	}
}
