package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class myaccount {

	WebDriver ldriver;

	public myaccount(WebDriver rdriver) 
	{
		ldriver=rdriver;

		PageFactory.initElements(rdriver, this);

	}
	@FindBy(id="email_create")
	WebElement createemail;
	
	@FindBy(id="SubmitCreate")
	WebElement SubmitMailId;
	
		@FindBy(id="email")
	WebElement RegsrUSerEmail;
	
	@FindBy(id="passwd")
	WebElement RegsrUSerPwd;
	
	//SubmitLogin
	@FindBy(id="SubmitLogin")
	WebElement SignInbtn;
	
	@FindBy(id="search_query_top")
	WebElement searchbox;
	
	@FindBy(xpath="//button[@name='submit_search']")
	WebElement searchbtn;
	


	public void enterMailID(String emailid)
	{
		createemail.sendKeys(emailid);
	}
	public void ClickonSubmit()
	{
		SubmitMailId.click();
	}
	public void EnterregstUserMail(String regemailid)
	{
		RegsrUSerEmail.sendKeys(regemailid);
	}
	public void EnterregstUserPwd(String regeuserpwd)
	{
		RegsrUSerPwd.sendKeys(regeuserpwd);
	}
	public void ClickOnSignBtn()
	{
		SignInbtn.click();;
	}
	public void ClickOnSearchBox(String searchkey)
	{
		searchbox.sendKeys(searchkey);
	}
	public void ClickOnSearchButton()
	{
		searchbtn.click();
	}
	
	

}