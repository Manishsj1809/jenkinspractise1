package organization;

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
import ObjectRepository.LoginPage;

public class CreateOrganization {
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

//		driver.get("http://localhost:8888/");
		LoginPage login = new LoginPage(driver);
		login.LoginToApp(USERNAME, PASSWORD);
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.cssSelector("[title='Create Organization...']")).click();
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();

		Excel_Utility elib = new Excel_Utility();
		String orgname = elib.getExcelData("Organization", 0, 0) + ranNum;
		System.out.println(orgname);
		String phnNum = elib.getExcelDataUsingDataFormatter("Organization", 1, 0);
		String mailID = elib.getExcelDataUsingDataFormatter("Organization", 2, 0);


		driver.findElement(By.name("accountname")).sendKeys(orgname);
		driver.findElement(By.id("phone")).sendKeys(phnNum);
		driver.findElement(By.id("email1")).sendKeys(mailID);
		driver.findElement(By.cssSelector("[title='Save [Alt+S]']")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

//		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//		driver.findElement(By.linkText("Sign Out")).click();

	}

}
