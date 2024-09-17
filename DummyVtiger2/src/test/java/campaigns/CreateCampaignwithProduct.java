package campaigns;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import ObjectRepository.LoginPage;

public class CreateCampaignwithProduct {
	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.maximizescreen(driver);
		wlib.implicitwait(driver);
		File_Utility flib = new File_Utility();
		String URL = flib.getpropertiesdata("url");
		String USERNAME = flib.getpropertiesdata("UserName");
		String PASSWORD = flib.getpropertiesdata("PassWord");

		// pro.load(fis);
		driver.get(URL);
		LoginPage login = new LoginPage(driver);
		login.LoginToApp(USERNAME, PASSWORD);

		driver.findElement(By.xpath("//a[text()='Products']")).click();
		driver.findElement(By.cssSelector("[title='Create Product...']")).click();
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();

		Excel_Utility elib = new Excel_Utility();
		String prdName = elib.getExcelData("Product", 0, 0) + ranNum;
		System.out.println(prdName);

		driver.findElement(By.name("productname")).sendKeys(prdName);
		System.out.println(prdName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		WebElement link = driver.findElement(By.xpath("//a[text()='More']"));
		Actions act = new Actions(driver);
		act.moveToElement(link).click().perform();
		driver.findElement(By.xpath("//a[text()='Campaigns']")).click();
		driver.findElement(By.cssSelector("[title='Create Campaign...']")).click();

		String campName = elib.getExcelData("Campaigns", 0, 0) + ranNum;
		System.out.println(campName);

		driver.findElement(By.name("campaignname")).sendKeys(campName);

		driver.findElement(By.xpath("//img[@alt='Select']")).click();
		
		wlib.swichingwindows(driver, "Products&action");


		driver.findElement(By.id("search_txt")).sendKeys(prdName);
		driver.findElement(By.xpath("//input[@type='button']")).click();
		driver.findElement(By.xpath("//a[text()='" + prdName + "']")).click();
		
		wlib.swichingwindows(driver, "Campaigns&action");


		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}

}
