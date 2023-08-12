package com.mystore.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.pageobject.MyAccountAddressDetails;
import com.mystore.pageobject.SubmitSearch;
import com.mystore.pageobject.indexpage;
import com.mystore.pageobject.myaccount;
import com.mystore.pageobject.productcategory;

public class TC_ProductPageTest extends BaseClass {
	
	@Test(enabled=true)
	public void VerifySeachProduct() throws IOException
	{
		String searchkey="T-shirts";
		
		indexpage pg= new indexpage(driver);
		
		pg.clickOnSignIn();
		
		myaccount myacc= new myaccount(driver);
		
		myacc.EnterregstUserMail(emailaddress);
		
		myacc.EnterregstUserPwd(password);
		
		myacc.ClickOnSignBtn();
		
		myacc.ClickOnSearchBox(searchkey);
		
		myacc.ClickOnSearchButton();
		
		SubmitSearch sbmtsrch= new SubmitSearch(driver);
		
		String Searchproductname= sbmtsrch.getSearchResultProductName();
		
		MyAccountAddressDetails myaccadrdtls= new MyAccountAddressDetails(driver);
		
		if(Searchproductname.contains(searchkey))
		{
			
			logger.info("Seacrh product page passed");
			
			Assert.assertTrue(true);
			
			myaccadrdtls.ClickOnSignOut();
		}
			else
			{
				logger.info("Seacrh product page Failed");
				
				Assert.assertTrue(false);
				
				captureScreenshot(driver,"VerifySeachProduct");
			}
		logger.info("Test Case SeachProduct ends");
			
		}
	@Test
	public void VerifyAddToCartWithOutLogin()
	{
		
		indexpage pg= new indexpage(driver);
		
		pg.ClickonTshirtmenu();
		
		productcategory prdctcatgry= new productcategory(driver);
		
		prdctcatgry.mouseOverToProduct();
		
		prdctcatgry.ClickOnAddCart();
		
		}

}