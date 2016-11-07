package webpages;

import java.util.Iterator;
import java.util.Set;

import omelet.common.ExpectedConditionExtended;
import omelet.data.IProperty;
import omelet.driver.DriverUtility;
import omelet.exception.FrameworkException;
import omelet.testng.support.SAssert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.DataEnum;


public class ProductsPage {
	
	private WebDriver driver;
	private IProperty prop;
	SAssert sa = new SAssert();
	

	@FindBy (xpath= "(//a/h2)[1]")
	private WebElement product;
	
	public ProductsPage(WebDriver driver,IProperty prop){
		this.driver = driver;
		this.prop = prop;
		PageFactory.initElements(driver, this);
	}
		
	
	
	public ProductsPage isLoaded(){
		if(null == DriverUtility.waitFor(ExpectedConditionExtended.elementToBeClickable(product), driver, 30)){
			throw new FrameworkException("Not able to load Products page in 30 seconds");
		}
		return this;
	}
	
	
	public boolean verifyProduct(String productName){
		boolean flag=true;
		if(!product.getText().toLowerCase().contains(productName.toLowerCase())){
			flag= false;
		}return flag;	
	}
	
	
	public void goToProductDetailsPage(){
		product.click();
		Set<String> ids = driver.getWindowHandles();
		int count =ids.size();
		if(count>1){
			System.out.println(count);
			Iterator<String> itr = ids.iterator();
			String mainwin = itr.next();
			String  tabwin = itr.next();
			driver.switchTo().window(tabwin);
		}
		sa.assertTrue(true, "Go to product details page");
	}
	
	
	
	
}
	


