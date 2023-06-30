package browserstack;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;

public class MobileBrowser_BrowserStack {
	
	
	
	WebDriver driver;
	
	public static final String Username="sagarnayak_DqH6KI";
	public static final String AcessKey="3cFkMsym77ZAJyE1PVUn";
	public static final String url="https://"+Username+":"+AcessKey+"@hub-cloud.browserstack.com/wd/hub";
	
	@Parameters("DeviceName")
	@BeforeTest
	public void setup(String DeviceName) throws Throwable
	{
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, DeviceName);
		dc.setCapability(MobileCapabilityType.BROWSER_NAME,MobileBrowserType.CHROME);
		dc.setCapability("build","1.2.4");
		dc.setCapability("name","sagar_browserstack_mobiletest");
		
		driver=new RemoteWebDriver(new URL(url),dc);
	}
	
	@Test
	public void mobileBrowserTest()
	{
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("appium"+Keys.ENTER);
		System.out.println(driver.getTitle());
	}
	
	@AfterTest
	public void closeSetup()
	{
		driver.quit();
	}
	
	
	

}
