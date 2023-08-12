package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class indexpage {

	WebDriver ldriver;

	public indexpage(WebDriver rdriver) 
	{
		ldriver=rdriver;

		PageFactory.initElements(rdriver, this);

	}

	@FindBy(linkText="Sign in")
	WebElement signin;

	@FindBy(xpath="(//a[@title='T-shirts'])[2]")
	WebElement tshirtmenu;

	public void clickOnSignIn()
	{
		signin.click();
	}

	public String getpagetitle()
	{
		return(ldriver.getTitle());
	}
	public void ClickonTshirtmenu()
	{
		tshirtmenu.click();
	}

}
