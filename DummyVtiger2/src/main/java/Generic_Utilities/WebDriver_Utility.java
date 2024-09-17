package Generic_Utilities;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebDriver_Utility {
	
	
	public void maximizescreen(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	public void implicitwait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void movetoelementaction(WebDriver driver,WebElement ele)
	{
		Actions act = new Actions(driver);
		act.moveToElement(ele).click().perform();
				
	}
	
	public void swichingwindows(WebDriver driver,String title)
	{
		Set<String> allWin1 = driver.getWindowHandles();
		Iterator<String> it1 = allWin1.iterator();

		while (it1.hasNext()) {
			String win1 = it1.next();
			driver.switchTo().window(win1);
			String currentTitle = driver.getTitle();
			System.out.println(currentTitle);

			if (currentTitle.contains(title)) {
				break;

			}
		}

	}

}
