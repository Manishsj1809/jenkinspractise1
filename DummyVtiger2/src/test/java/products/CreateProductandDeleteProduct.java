package products;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import ObjectRepository.LoginPage;

public class CreateProductandDeleteProduct {
	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.maximizescreen(driver);
		wlib.implicitwait(driver);
		
		File_Utility flib = new File_Utility();
		String URL = flib.getpropertiesdata("url");
		String USERNAME = flib.getpropertiesdata("UserName");
		String PASSWORD = flib.getpropertiesdata("PassWord");

		driver.get(URL);
		LoginPage login = new LoginPage(driver);
		login.LoginToApp(USERNAME, PASSWORD);

		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.cssSelector("[alt='Create Product...']")).click();
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();
		

		Excel_Utility elib = new Excel_Utility();
		String prdName = elib.getExcelData("Product", 0, 0) + ranNum;
		System.out.println(prdName);

		driver.findElement(By.name("productname")).sendKeys(prdName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr/td//a[text()='"+prdName+"']/../preceding-sibling::td//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@value='Delete']")).click();
		
//		Thread.sleep(2000);
		driver.switchTo().alert().accept();

		Thread.sleep(2000);
		List<WebElement> allprd = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr//td[3])[position()>1]"));
		boolean flag = false;

		for (WebElement prdName1 : allprd) {
			String actData = prdName1.getText();
			if (actData.equalsIgnoreCase(prdName))
			{
				flag = true;
				break;
			}
		}
	
		if (!flag) 
		{
			System.out.println("Product data is deleted");
		}
		else 
		{
			System.out.println("Product data is not deleted");
		}
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
	}

}
