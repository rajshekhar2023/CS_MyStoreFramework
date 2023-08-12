package com.mystore.testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mystore.pageobject.MyAccountAddressDetails;
import com.mystore.pageobject.UserAccountCreation;
import com.mystore.pageobject.indexpage;
import com.mystore.pageobject.myaccount;
import com.mystore.utilities.ReadConfig;
import com.mystore.utilities.ReadExcelFile;

import junit.framework.Assert;

public class TC_MyAccountPage2DataDrivenExcel extends BaseClass {
	
	
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
	
	@Test(dataProvider = "LoginDataProvider")
	public void VerifyLogin(String Email,String Passwrd,String ExpectUsernme) throws IOException
	{
		indexpage pg =new indexpage(driver);
		
		pg.clickOnSignIn();
		
		myaccount myacc= new myaccount(driver);
		
		myacc.EnterregstUserMail(Email);
		
		myacc.EnterregstUserPwd(Passwrd);
		
		myacc.ClickOnSignBtn();
		
		MyAccountAddressDetails Myaccadrdtls= new MyAccountAddressDetails(driver);
		
		String userName=Myaccadrdtls.getuser();
		
		if(userName.equals(ExpectUsernme))
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
	@DataProvider(name="LoginDataProvider")
	public String[][]LoginDataProvider()
	{
		
		String Filename=System.getProperty("user.dir") + "\\TestData\\MyStoreTestData.xlsx";
		
		int ttlrow=ReadExcelFile.getRowCount(Filename, "LoginData");
		
		int ttlcol=ReadExcelFile.getColCount(Filename, "LoginData");
		
		String data[][]= new String[ttlrow-1][ttlcol];
		
		for(int i=1;i<ttlrow;i++)
		{
			for(int j=0;j<ttlcol;j++)
			{
				data[i-1][j]=ReadExcelFile.getCellValue(Filename, "LoginData", i, j);
			}
		}
		
		return data;
	}
	

}
