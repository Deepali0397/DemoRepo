package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.qa.base.BaseClass;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.Signup_CreateAccountPage;
import com.crm.qa.pages.StartMainPage;
import com.crm.qa.util.TestUtilClass;

public class LoginPageTest extends BaseClass {
	SoftAssert softassert=new SoftAssert();
	
	TestUtilClass testutil;
	StartMainPage mainpage;
	LoginPage loginpage;
	HomePage homepage;
	Signup_CreateAccountPage createaccountpage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		testutil=new TestUtilClass();
		
		mainpage = new StartMainPage();
		loginpage = mainpage.clickonsiginbtn();
		createaccountpage=new Signup_CreateAccountPage();
	}

	@Test(priority = 1)
	public void loginpagetitle() {
		String title = loginpage.validateloginpagetitle();
		softassert.assertEquals(title, "Login - My Store","HOME page title not matching");
		softassert.assertAll();
	}

	@Test(priority = 2)
	public void Logocheck() {
		boolean flag = loginpage.logocheck();
		Assert.assertTrue(flag);
	}

	@Test(priority = 3)
	public void successfullogin() {
		homepage = loginpage.loginsuccessful(prop.getProperty("username"), prop.getProperty("pwd"));
	}

	@Test(priority = 4)
	public void accountcreation() {
		createaccountpage = loginpage.createaccount(prop.getProperty("email"));
	}

	@AfterMethod
	public void teardown() {
		
		driver.quit();
	}
	

}
