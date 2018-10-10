package report;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Automation.Selenium.Base;

public class ExtendReport extends Base
{
	public static ExtentReports report;
	public static ExtentTest extent_log;
	
	@BeforeClass
	public void beforeclass()
	{
		System.out.println("in before class");
		report=new ExtentReports("./extentReports.html", false);
		extent_log=report.startTest("ExtendReport");
	}
	@BeforeMethod
	public void beforeMethod(Method result)
	{
		System.out.println("in beforeMethod");
		extent_log.log(LogStatus.INFO, result.getName()+": Stared........");
	}
	
	@Test(priority=1)
	public void login()
	{
		System.out.println("in login");
		extent_log.log(LogStatus.INFO, "login to the application");
		extent_log.log(LogStatus.INFO, "login succesful");
	}
	
	@Test(priority=2)
	public void logout()
	{
		System.out.println("in logout");
		extent_log.log(LogStatus.INFO, "logout stared");
		Assert.assertTrue(false);
		extent_log.log(LogStatus.INFO, "logout complete");
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException
	{
		if(result.getStatus()==result.SUCCESS)
		{
			extent_log.log(LogStatus.INFO, result.getName()+" -------------------Sucessfully");
		}
		else if (result.getStatus()==result.FAILURE) 
		{
			extent_log.log(LogStatus.ERROR, "fuck off");
			extent_log.log(LogStatus.ERROR, result.getName()+" Failed----------------------------");
			
		}
	}
	
	@AfterClass
	public void afterclass()
	{
		report.endTest(extent_log);
		report.flush();
	}
}
