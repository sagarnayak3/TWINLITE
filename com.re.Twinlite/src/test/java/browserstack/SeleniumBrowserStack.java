package browserstack;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class SeleniumBrowserStack {
	public static final String Username="sagarnayak_DqH6KI";
	public static final String AcessKey="3cFkMsym77ZAJyE1PVUn";
	public static final String url="https://"+Username+":"+AcessKey+"@hub-cloud.browserstack.com/wd/hub";
	@Test
	public void seleniumBrowserStack() throws Throwable
	
	{
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability("os", "Windows");
		dc.setCapability("os_version", "11");
		dc.setCapability("browser", "chrome");
		dc.setCapability("browser_version", "114");
		dc.setCapability("name","sagar_Test_browserstack");
		
		WebDriver driver=new RemoteWebDriver(new URL(url),dc);
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("appium"+Keys.ENTER);
		System.out.println(driver.getTitle());
		
	}

}
