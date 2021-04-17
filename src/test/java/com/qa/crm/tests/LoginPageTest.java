package com.qa.crm.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.crm.base.BasePage;
import com.qa.crm.pages.LoginPage;
import com.qa.crm.util.Constants;

public class LoginPageTest {

	BasePage basepage;
	Properties prop;
	WebDriver driver;
	LoginPage loginpage;

	@BeforeMethod
	public void setUp() {
		basepage = new BasePage();
		prop = basepage.init_properties();
		driver = basepage.int_driver(prop);
		loginpage = new LoginPage(driver);
	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginpage.getLoginPageTitle();
		System.out.println("Login page title is :" + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}

	@Test(priority = 2)
	public void signUpLinkTest() {
		Assert.assertTrue(loginpage.signUpLinkDisplayed());
	}
	
	@Test(priority = 3)
	public void forgotPasswordLinkTest() {
		Assert.assertTrue(loginpage.forgotPasswordLinkidDisplayed());
	}

	@Test(priority = 4)
	public void loginTest() {
		loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void teamDown() {
		driver.quit();
	}
}
