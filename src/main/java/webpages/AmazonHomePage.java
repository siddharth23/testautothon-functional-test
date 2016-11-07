package webpages;

import omelet.common.ExpectedConditionExtended;
import omelet.data.IProperty;
import omelet.driver.DriverUtility;
import omelet.exception.FrameworkException;
import omelet.testng.support.SAssert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import common.DataEnum;


public class AmazonHomePage {
	
	private WebDriver driver;
	private IProperty prop;
	SAssert sa = new SAssert();
	

	@FindBy (xpath= "//*[@id='twotabsearchtextbox']")
	private WebElement searchBox;

	@FindBy (css= ".nav-input[value='Go']")
	private WebElement btnGo;
	
	@FindBy (xpath= "//*[@id='nav-link-yourAccount']/span[1]")
	private WebElement linkHelloSignIn;
	
	@FindBy (xpath= "//*[@id='nav-flyout-ya-signin']/a/span")
	private WebElement btnSignIn;
	
	@FindBy (xpath= "//*[@id='searchDropdownBox']")
	private WebElement ddlCategory;
	
	@FindBy (xpath= "//*[@id='nav-subnav']/a[1]/span")
	private WebElement tabCategory;
	
	
	
	
	
	
	
	public AmazonHomePage(WebDriver driver,IProperty prop){
		this.driver = driver;
		this.prop = prop;
		PageFactory.initElements(driver, this);
	}
		
	
	public boolean Accessurl(String url){
		driver.get(url);
		return true;
	}
	
	
	public boolean isLoaded(){
		if(null == DriverUtility.waitFor(ExpectedConditionExtended.elementToBeClickable(linkHelloSignIn), driver, 30)){
			throw new FrameworkException("Not able to load Amazon Home page in 30 seconds");
		}
		return true;
	}
	
	
	public boolean searchProduct(String productName){
		
		searchBox.sendKeys(productName);
		btnGo.click();
		return true;
	}
	
	public boolean clickSignIn(){
		
		linkHelloSignIn.click();
		sa.assertTrue(true, "Click on SignIn button");
		return true;
	}
	
	public boolean selectCategory(){
		
		Select ddCategory = new Select(ddlCategory);
		ddCategory.selectByVisibleText(prop.getValue(DataEnum.Amazon_category));
		btnGo.click();
		sa.assertTrue(true, "Select category and click Go button");
		return true;
	}
	
public boolean verifyCategory(){
		
	if(null != DriverUtility.waitFor(ExpectedConditionExtended.elementToBeClickable(tabCategory), driver, 30)){
		if(tabCategory.getText().contains(prop.getValue(DataEnum.Amazon_category))){
			sa.assertTrue(true, "Verify category tab");
			return true;
		}	
	}
	sa.assertTrue(false, "Verify category tab");		
	return false;

	}

}
