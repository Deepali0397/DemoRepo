package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BaseClass;

public class HomePage extends BaseClass {
	@FindBy(css = ".page-heading")
	WebElement pageheading;

	@FindBy(xpath = "//a[@title='Women']")
	WebElement womentab;

	@FindBy(xpath = "//a[@title='Tops']")
	WebElement topsbtn;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public boolean validatehomepage() {
		return pageheading.isDisplayed();
	}
	
	public TopsPage womentabhover() {
		Actions action=new Actions(driver);
		action.moveToElement(womentab).build().perform();
		topsbtn.click();
		return new TopsPage();
	}
	
	
	
	
	
	
}
