package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MyAccountAddressDetails {
	
	WebDriver ldriver;
	
	public MyAccountAddressDetails(WebDriver rdriver)
	{
		ldriver=rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//a[@title='Add my first address']")
	WebElement adressbtn;
	
	//firstname
	@FindBy(id="firstname")
	WebElement userfrtname;
	
	//lastname
	
	@FindBy(id="lastname")
	WebElement userlstname;
	
	//address1
	@FindBy(id="address1")
	WebElement address;

	//city
	@FindBy(id="city")
	WebElement cty;
	
	//id_state
	@FindBy(id="id_state")
	WebElement state;
	
	//postcode
	@FindBy(id="postcode")
	WebElement pstcode;
	
	//id_country
	@FindBy(id="id_country")
	WebElement cntry;
	
	//phone
	@FindBy(id="phone")
	WebElement phne;
	
	@FindBy(id="phone_mobile")
	WebElement mobile;
	
	@FindBy(id="alias")
	WebElement alis;
	
	@FindBy(id="submitAddress")
	WebElement sbmitAddres;
	
	@FindBy(xpath="//a[@title='View my customer account']")
	WebElement username;
	
	@FindBy(linkText="Sign out")
	WebElement Sgnout;
	
	public void ClickonAddressLink()
	{
		adressbtn.click();
	}
	public void EnterAdrsFrstName(String userFname)
	{
		userfrtname.sendKeys(userFname);
	}
	public void EnterAdrsLstName(String userLname)
	{
		userlstname.sendKeys(userLname);
	}
	public void EnterAddress(String Adrs)
	{
		address.sendKeys(Adrs);
	}
	public void EnterCity(String City)
	{
		cty.sendKeys(City);
	}
	public void SelectState(String text)
	{
		Select dropdown= new Select(state);
		 
		dropdown.selectByVisibleText(text);
	}
	public void EnterPostCode(String pstcde)
	{
		pstcode.sendKeys(pstcde);
	}
	public void SelectCountry(String text1)
	{
		Select dropdown2= new Select(cntry);
		
		dropdown2.selectByVisibleText(text1);
		
	}
	public void EnterPhomeNumber(String phon)
	{
		phne.sendKeys(phon);
	}
	public void EnterMobileNumber(String Moble)
	{
		mobile.sendKeys(Moble);
	}
	public void EnterAlias(String Als)
	{
		alis.sendKeys(Als);
	}
	public void ClickOnSave()
	{
		sbmitAddres.click();
	}
	
	public String getuser()
	{
		String text= username.getText();
		
		return text;
	}
	
	public void ClickOnSignOut()
	{
		Sgnout.click();
	}
	


}
