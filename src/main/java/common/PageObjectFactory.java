package common;


import omelet.data.IProperty;
import omelet.data.driverconf.IBrowserConf;
import omelet.driver.Driver;

import org.openqa.selenium.WebDriver;
import webpages.AmazonHomePage;
import webpages.CartPage;
import webpages.LoginPage;
import webpages.ProductDetailsPage;
import webpages.ProductsPage;


public class PageObjectFactory  {

	
	private WebDriver driver;
	private IProperty prop;
	
	private AmazonHomePage	amazonHomePage;
	private ProductsPage	productsPage;
	private ProductDetailsPage productDetailsPage;
	private CartPage cartPage;
	private LoginPage loginPage;
	
	
	public PageObjectFactory(IBrowserConf browserConf, IProperty prop){
		this.prop = prop;
		driver = Driver.getDriver(browserConf);
		driver.manage().window().maximize();
		
	}
	
	
	public AmazonHomePage amazonHomePage(){
		if(null==amazonHomePage)
			amazonHomePage = new AmazonHomePage(driver,prop);
		return amazonHomePage;
	}
	
	public ProductsPage productsPage(){
		if(null==productsPage)
			productsPage = new ProductsPage(driver,prop);		
		return productsPage;
	}
	
	public ProductDetailsPage productDetailsPage(){
		if(null==productDetailsPage)
			productDetailsPage = new ProductDetailsPage(driver,prop);		
		return productDetailsPage;
	}
	public CartPage cartPage(){
		if(null==cartPage)
			cartPage = new CartPage(driver,prop);		
		return cartPage;
	}
	
	public LoginPage loginPage(){
		if(null==loginPage)
			loginPage = new LoginPage(driver,prop);		
		return loginPage;
	}

	
	
	
	
	
}
