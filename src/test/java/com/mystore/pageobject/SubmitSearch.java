package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubmitSearch {
	
	WebDriver ldriver;
	
	public SubmitSearch(WebDriver rdriver)
	{
		ldriver=rdriver;
		
		PageFactory.initElements(rdriver, this);
		
	}


	@FindBy(xpath = "//a[@title='Faded Short Sleeve T-shirts'][normalize-space()='Faded Short Sleeve T-shirts']")
	WebElement searchkey;
	
	public String getSearchResultProductName()
	{
	 
		return(searchkey.getText());
    
	}

}