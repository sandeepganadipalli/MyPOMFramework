package com.qa.crm.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.crm.base.BasePage;
import com.qa.crm.pages.AccountsPage;
import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;
import com.qa.crm.util.Constants;
import com.qa.crm.util.ExcelUtil;

public class AccountPageTest {
	

	BasePage  basepage;
	Properties prop;
	WebDriver driver;
	LoginPage loginpage;
	HomePage homepage;
	AccountsPage accountpage;
	
	@BeforeMethod
	public void setUp() {
		basepage=new BasePage();
		prop=basepage.init_properties();
		driver=basepage.int_driver(prop);
		loginpage= new LoginPage(driver);
		homepage=loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		accountpage=homepage.doAccountSettings();
	}

	@Test(priority = 1)
	public void accountPageHeaderTest() {
		String accountPageHeaderText=accountpage.getAccountPageHeader();
		System.out.println("Account page header text is :"+accountPageHeaderText);
		Assert.assertEquals(accountPageHeaderText, Constants.ACCOUNT_PAGE_HEADER);
	}
	
	@DataProvider
	public Object[][] getContactsData() {
		Object data[][]=ExcelUtil.getTestData("Accounts");
		return data;
	}
	@Test(priority = 2,dataProvider = "getContactsData")
	public void accountAddTest(String company_name,String Address,String City,String posal_code,String State) {
		accountpage.setAccount(company_name, Address, City, posal_code, State);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
