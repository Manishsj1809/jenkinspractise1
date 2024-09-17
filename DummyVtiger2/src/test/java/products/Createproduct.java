package products;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import ObjectRepository.CreateProductPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;

public class Createproduct {
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
		
		HomePage home = new HomePage(driver);
		home.clickproductlink();

//		driver.findElement(By.linkText("Products")).click();
		CreateProductPage prdpage = new CreateProductPage(driver);
		
		prdpage.clickprdplusbtn();
//		driver.findElement(By.cssSelector("[alt='Create Product...']")).click();

		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();

		Excel_Utility elib = new Excel_Utility();
		String prdName = elib.getExcelData("Product", 0, 0) + ranNum;
		System.out.println(prdName);
		
		prdpage.enterProdutname(prdName);
		prdpage.clicksavebutton();
//		driver.findElement(By.name("productname")).sendKeys(prdName);
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		home.LogOutFromApp();

//		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

	}

}
