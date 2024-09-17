package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {
	
	public CreateProductPage(WebDriver driver)

	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@alt='Create Product...']")
	private WebElement prdplussign;
	
	@FindBy(name="productname")
	private WebElement productname;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebutton;

	public WebElement getPrdplussign() {
		return prdplussign;
	}

	public WebElement getProductname() {
		return productname;
	}

	public WebElement getSavebutton() {
		return savebutton;
	}
	
	public void clickprdplusbtn()
	{
		prdplussign.click();
	}
	
	public void enterProdutname(String name)
	{
		productname.sendKeys(name);
	}
	public void clicksavebutton()
	{
		savebutton.click();
	}
	
}
