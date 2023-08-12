package com.mystore.testcases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.mystore.pageobject.MyAccountAddressDetails;
import com.mystore.pageobject.UserAccountCreation;
import com.mystore.pageobject.indexpage;
import com.mystore.pageobject.myaccount;

import junit.framework.Assert;

public class TC_MyAccountPage extends BaseClass {


	@Test(enabled=false)
	public void verifyRegistationAndLogin()
	{


		indexpage pg =new indexpage(driver);

		pg.clickOnSignIn();

		myaccount myacc= new myaccount(driver);

		myacc.enterMailID("shekhar1234567@gmail.com");

		myacc.ClickonSubmit();

		UserAccountCreation UsrAccCrt= new UserAccountCreation(driver);

		UsrAccCrt.ClickOntitle();

		UsrAccCrt.enterfirstname("Raja");

		UsrAccCrt.enterlastname("Shetya");

		UsrAccCrt.enterpassword("123456");

		UsrAccCrt.clickonregster();


		MyAccountAddressDetails Myaccadrdtls= new MyAccountAddressDetails(driver);

		Myaccadrdtls.ClickonAddressLink();

		Myaccadrdtls.EnterAdrsFrstName("Rajas");

		Myaccadrdtls.EnterAdrsLstName("Shetyak");

		Myaccadrdtls.EnterAddress("12/98 Pimpari");

		Myaccadrdtls.EnterCity("Pune");

		Myaccadrdtls.SelectState("Alabama");

		Myaccadrdtls.EnterPostCode("00000");

		Myaccadrdtls.SelectCountry("United States");

		Myaccadrdtls.EnterPhomeNumber("1234567");

		Myaccadrdtls.EnterMobileNumber("1230456789");

		Myaccadrdtls.EnterAlias("Home");

		Myaccadrdtls.ClickOnSave();

		String userName=Myaccadrdtls.getuser();

		Assert.assertEquals("Raja Shetya", userName);

	}

	@Test
	public void VerifyLogin() throws IOException
	{
		indexpage pg =new indexpage(driver);

		pg.clickOnSignIn();

		myaccount myacc= new myaccount(driver);

		myacc.EnterregstUserMail("shekhar1234567@gmail.com");

		myacc.EnterregstUserPwd("123456");

		myacc.ClickOnSignBtn();

		MyAccountAddressDetails Myaccadrdtls= new MyAccountAddressDetails(driver);

		String userName=Myaccadrdtls.getuser();

		if(userName.equals("Raja Shetya"))
		{
			logger.info("Verify Login: Passed");
			Assert.assertTrue(true);
			Myaccadrdtls.ClickOnSignOut();

		}
		else
		{
			logger.info("Verify Login: Failed");

			captureScreenshot(driver, "VerifyLogin");

			Assert.assertTrue(false);
		}




	}
	@Test

	public void VerifyLogout() throws IOException
	{

		indexpage pg =new indexpage(driver);

		pg.clickOnSignIn();

		myaccount myacc= new myaccount(driver);

		myacc.EnterregstUserMail("shekhar1234567@gmail.com");

		myacc.EnterregstUserPwd("123456");

		myacc.ClickOnSignBtn();

		MyAccountAddressDetails Myaccadrdtls= new MyAccountAddressDetails(driver);

		Myaccadrdtls.ClickOnSignOut();

		if(pg.getpagetitle().equals("Login - My Shop"))
		{
			logger.info("Verify logout passed");

			Assert.assertTrue(true);

		}
		else
		{
			logger.info("Verify logout failed");

			captureScreenshot(driver,"VerifyLogout");

			Assert.assertTrue(false);

		}

	}


}
