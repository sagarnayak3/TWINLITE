package practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class iphoneFetch {

	public static void main(String[] args) throws Throwable {
//		ChromeOptions options=new ChromeOptions();
//		options.addArguments("--remote-allow-origins=*");
		
//		System.setProperty("webdriver.chrome.driver","C:\\Users\\sagar\\Desktop\\testyantra\\sowmya sir\\chrome\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new EdgeDriver();
		FileInputStream fis= new FileInputStream("./src/test/resources/testdata.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh=book.getSheet("RegisterUserPage");
//		System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver.exe");
		
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("apple iphone 13");
		List<WebElement> titles=driver.findElements(By.xpath("//span[@class='a-size-small a-color-base a-text-normal']"));
		
		for (int i = 0; i < titles.size(); i++) {
			String T1=titles.get(i).getText();
			String Price=driver.findElement(By.xpath("//span[text()='"+T1+"']/../../../../../span[3]//span[@class='a-price-whole']")).getText();
			Row rw=sh.createRow(i);
			Cell cell=rw.createCell(0);
			cell.setCellValue(T1);
			Cell name=rw.createCell(1);
			cell.setCellValue(Price);
			
			
		}
		FileOutputStream fos=new FileOutputStream("./src/test/resources/testdata.xlsx");
		book.write(fos);
		book.close();
		driver.close();
		
	}
//	@Test
//	public void iphoneFetch() throws Throwable
//	{
//		
//		
//	}
	
}
