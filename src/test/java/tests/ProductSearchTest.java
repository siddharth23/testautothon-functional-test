package tests;

import omelet.data.IProperty;
import omelet.data.driverconf.IBrowserConf;
import omelet.testng.support.SAssert;
import org.testng.annotations.Test;

import common.DataEnum;
import common.PageObjectFactory;


public class ProductSearchTest {
	
	SAssert sassert = new SAssert();

	@Test (dataProviderClass = omelet.data.DataProvider.class, dataProvider = "XmlData")
	public void productSearchTest(IBrowserConf browserConf, IProperty prop) {
		
		PageObjectFactory pof = new PageObjectFactory(browserConf, prop);
		sassert.assertTrue(pof.amazonHomePage().Accessurl(prop.getValue(DataEnum.Amazon_url)), "Access url");
		sassert.assertTrue(pof.amazonHomePage().searchProduct(prop.getValue(DataEnum.Amazon_product)), "Search a product");
		sassert.assertTrue(pof.productsPage().verifyProduct(prop.getValue(DataEnum.Amazon_product)), "Verify resulting product");
		sassert.assertAll();
	}
	
}
