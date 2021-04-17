package com.qa.crm.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.crm.base.BasePage;
import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;
import com.qa.crm.util.Constants;

public class HomePageTest {
	
	BasePage  basepage;
	Properties prop;
	WebDriver driver;
	LoginPage loginpage;
	HomePage homepage;
	
	@BeforeMethod
	public void setUp() {
		basepage=new BasePage();
		prop=basepage.init_properties();
		driver=basepage.int_driver(prop);
		loginpage= new LoginPage(driver);
		homepage=loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
		
	}
	
	@Test(priority = 1)
	public void homePageTitleTest() {
		String homePageTitle=homepage.getHomePageTitle();
		System.out.println("Home page title is:"+homePageTitle);
		Assert.assertEquals(homePageTitle, Constants.HOME_PAGE_TITLE);
	}
	
	@Test(priority = 2)
	public void accounntNameTest() {
		Assert.assertTrue(homepage.isAccountNameVisible());
		
		String accountNameText=homepage.getAccountName();
		System.out.println("Account name is:"+accountNameText);
		Assert.assertEquals(accountNameText, prop.getProperty("accountname"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
