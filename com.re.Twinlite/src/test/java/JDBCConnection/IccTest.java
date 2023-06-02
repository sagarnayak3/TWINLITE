package JDBCConnection;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.re.TwinliteGenericUtilities.JavaScriptUtility;

public class IccTest {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		JavaScriptUtility jsu=new JavaScriptUtility();
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		
		Thread.sleep(3000);
		jsu.scrollDown();
		jsu.scrollUp();
		
	
		
	}

}
