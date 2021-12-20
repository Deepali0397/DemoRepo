package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.BaseClass;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.StartMainPage;
import com.crm.qa.pages.TopsPage;
import com.crm.qa.util.TestUtilClass;

public class HomePageTest extends BaseClass {

	TestUtilClass testutil;
	StartMainPage mainpage;
	LoginPage loginpage;
	HomePage homepage;
	TopsPage topspage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		
		initialization();
		
		testutil = new TestUtilClass();
		mainpage = new StartMainPage();
		loginpage=new LoginPage();
		homepage = new HomePage();
		topspage = new TopsPage();
		loginpage = mainpage.clickonsiginbtn();
        homepage = loginpage.loginsuccessful(prop.getProperty("username"), prop.getProperty("pwd"));
	}

	@Test(priority=1)
	public void validatehomepagetitle() {
	boolean title=homepage.validatehomepage();
	Assert.assertTrue(title);
	}

	@Test(priority=2)
	public void womentabhoverclick() {
	topspage=homepage.womentabhover();
	}
	@AfterMethod
	public void teardown() {
		
		driver.quit();
	}

}
