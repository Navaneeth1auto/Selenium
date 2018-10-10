package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DisplayingProductDetails 
{
	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Navaneeth\\eclipse-workspace\\Selenium\\Drivers\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.flipkart.com/");
		
		try {
			driver.findElement(By.xpath("//button[text()='✕']")).isDisplayed();
			driver.findElement(By.xpath("//button[text()='✕']")).click();
			driver.navigate().refresh();
		} catch (Exception e) {
			System.out.println("in catch block of ClickOnLogin_SignIN");
		}
		driver.findElement(By.xpath("//*[@title='Search for products, brands and more']")).sendKeys("Apple iPhone X");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		Thread.sleep(1000);
		
		List<WebElement> phoneList = driver.findElements(By.xpath("//a[contains(text(),'Apple iPhone X ')]"));
		int count=phoneList.size();
		System.out.println(count);
		for(int i=1;i<=count; i++)
		{
			System.out.println(i);
			Thread.sleep(50);
			String phoneName=driver.findElement(By.xpath("(//a[contains(text(),'Apple iPhone X ')])["+i+"]")).getText();
			String price = driver.findElement(By.xpath("(//a[contains(text(),'Apple iPhone X ')]/following-sibling::a//*[@class='_1vC4OE'])["+i+"]")).getText();
			System.out.println(phoneName+"  "+price);
		}
	}
}
