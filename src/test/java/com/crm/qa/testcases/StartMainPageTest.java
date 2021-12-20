package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.BaseClass;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.StartMainPage;

public class StartMainPageTest extends BaseClass {

	StartMainPage mainpage;
	LoginPage loginpage;

	public StartMainPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		mainpage = new StartMainPage();
	}

	@Test(priority = 0)
	public void StartMainPageTitle() {
		String title = mainpage.validateStartMainPageTitle();
		Assert.assertEquals(title, "My Store");
	}

	@Test(priority = 1)
	public void Logocheck() {
		boolean flag = mainpage.validateLogo();
		Assert.assertTrue(flag);
	}

	@Test(priority = 2)
	public void siginbtnclick() {
	loginpage= mainpage.clickonsiginbtn();

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
