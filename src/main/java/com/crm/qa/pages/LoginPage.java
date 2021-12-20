package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BaseClass;

public class LoginPage extends BaseClass {

	@FindBy(css = "#email")
	WebElement usernametxt;

	@FindBy(css = "input#passwd")
	WebElement pwdtxt;

	@FindBy(css = "#SubmitLogin")
	WebElement SigninBtn;

	@FindBy(css = "#email_create")
	WebElement emailtxt;

	@FindBy(css = "button#SubmitCreate")
	WebElement CreateAccountBtn;

	@FindBy(css = ".logo.img-responsive")
	WebElement logo;

	public LoginPage() {
		PageFactory.initElements(driver, this);

	}

	public String validateloginpagetitle() {
		return driver.getTitle();
	}

	public boolean logocheck() {
		return logo.isDisplayed();
	}

	public HomePage loginsuccessful(String un, String pwd) {
		usernametxt.sendKeys(un);
		pwdtxt.sendKeys(pwd);
		SigninBtn.click();
		return new HomePage();

	}

	public Signup_CreateAccountPage createaccount(String email) {
		emailtxt.sendKeys(email);
		CreateAccountBtn.click();
		return new Signup_CreateAccountPage();
	}

}
