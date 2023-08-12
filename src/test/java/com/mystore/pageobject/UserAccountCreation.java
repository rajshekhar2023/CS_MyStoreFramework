package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserAccountCreation {

	WebDriver ldriver;

	public UserAccountCreation(WebDriver rdriver)
	{
		ldriver=rdriver;

		PageFactory.initElements(rdriver, this);
	}


	@FindBy(id="id_gender1")
	WebElement usertitle;

	@FindBy(id="customer_firstname")
	WebElement custfrstname;

	@FindBy(id="customer_lastname")
	WebElement custolastname;

	@FindBy(id="passwd")
	WebElement passwrd;

	@FindBy(id="submitAccount")
	WebElement registerbtn;


	public void ClickOntitle()
	{
		usertitle.click();
	}


	public void enterfirstname(String fname)
	{
		custfrstname.sendKeys(fname);
	}
	public void enterlastname(String lstname)
	{
		custolastname.sendKeys(lstname);
	}
	public void enterpassword(String pwd)
	{
		passwrd.sendKeys(pwd);
	}
	public void clickonregster()
	{
		registerbtn.click();;
	}

}
