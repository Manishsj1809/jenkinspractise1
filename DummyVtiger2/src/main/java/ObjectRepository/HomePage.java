package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Products']")
	private WebElement prdlink;
	
	@FindBy(xpath="//a[text()='Organizations']")
	private WebElement orglink;
	
	@FindBy(xpath="//a[text()='More']")
	private WebElement morelink;
	
	@FindBy(name="Campaigns")
	private WebElement camplink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminlink;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signout;

	public WebElement getPrdlink() {
		return prdlink;
	}

	public WebElement getOrglink() {
		return orglink;
	}

	public WebElement getMorelink() {
		return morelink;
	}

	public WebElement getCamplink() {
		return camplink;
	}
	
	
	public WebElement getAdminlink() {
		return adminlink;
	}

	public WebElement getSignout() {
		return signout;
	}

	public void clickproductlink()
	{
		prdlink.click();
	}
	public void clickorganizationlink()
	{
		orglink.click();
	}
	public void clickmorelink()
	{
		morelink.click();
	}
	public void campaignlink()
	{
		camplink.click();
	}
	
	public void SignOutFromApp(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.moveToElement(adminlink).perform();
		signout.click();
	}
	
	public void LogOutFromApp()
	{
		adminlink.click();
		signout.click();
	}
	

}
