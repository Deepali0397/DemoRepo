package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BaseClass;

public class StartMainPage extends BaseClass {

	@FindBy(css = ".logo.img-responsive")
	WebElement logo;

	@FindBy(css = "a.login")
	WebElement SigninBtn;

	// Initializing the Page Object
	public StartMainPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public String validateStartMainPageTitle() {
		return driver.getTitle();
	}

	public boolean validateLogo() {
		return logo.isDisplayed();
	}
	
	public LoginPage clickonsiginbtn() {
		SigninBtn.click();
		return new LoginPage();
	}
	
}
 