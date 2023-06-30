package practice;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class MobileAppTest {
	
	public static final String Username="sagarnayak_DqH6KI";
	public static final String AcessKey="3cFkMsym77ZAJyE1PVUn";
	public static final String url="https://"+Username+":"+AcessKey+"@hub-cloud.browserstack.com/wd/hub";

	@Test
	public void mobileAppTest() throws Throwable
	{
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME,"Samsung Galaxy S22");
		dc.setCapability("os_version", "12.0");
		dc.setCapability("Project", "API Demo Testing");
		dc.setCapability("build", "API Demo 2.2.4");
		dc.setCapability("name", "Mobile_App_BrowserStack");
		dc.setCapability("app", "bs://7aee368eebfae9b6a8aa4237fbb41881c874ea79");
//		dc.setCapability(null, false);
//		dc.setCapability(null, false);
		
		AndroidDriver driver=new AndroidDriver(new URL(url),dc);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.quit();
		
	}
	
}
