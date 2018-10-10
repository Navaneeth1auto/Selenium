package Automation.Selenium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.common.io.Files;

public class Base {
	public static WebDriver driver;
	public static WebDriver initialiazation()
	{
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\Navaneeth\\eclipse-workspace\\Selenium\\Drivers\\geckodriver.exe");
		 driver = new FirefoxDriver();
		return driver;
	}
	
	public static void takeScreenshot(String testName) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File scrFiles=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFiles, new File("./Screenshots/"+testName+".png"));
	}
	
	
	public static void sendEmail() throws EmailException 
	{
		System.out.println("================Stared email========================");
		Email email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("247nava@gmail.com", "nav@12345"));
		email.setSSLOnConnect(true);
		email.setFrom("247nava@gmail.com");
		email.setSubject("Test Report");
		email.setMsg("Results of failed test)");
		email.addTo("navaneeth.info@gmail.com");
		email.send();
		System.out.println("================sent email========================");
	}
}
