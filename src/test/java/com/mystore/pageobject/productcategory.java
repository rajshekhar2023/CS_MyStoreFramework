package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class productcategory {
	
	WebDriver ldriver;
	
	public productcategory(WebDriver rdriver)
	{
		ldriver=rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//a[contains(.,'Faded Short Sleeve T-shirts')]")
	WebElement mouseovertoprdct;
	
	@FindBy(xpath="//a[@title='Add to cart']")
	WebElement addtocartbtn;
	
	public void mouseOverToProduct()
	{
		
		Actions actobj= new Actions(ldriver);
		actobj.moveToElement(mouseovertoprdct).build().perform();
	}
	public void ClickOnAddCart()
	{
		addtocartbtn.click();
	}

	
}
