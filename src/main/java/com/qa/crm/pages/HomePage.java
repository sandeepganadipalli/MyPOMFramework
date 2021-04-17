package com.qa.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.crm.base.BasePage;
import com.qa.crm.util.Constants;
import com.qa.crm.util.ElementActions;

public class HomePage extends BasePage{
	
	WebDriver driver;
	ElementActions elementactions;
	//1. define OR/Page Objects:
	By account_name=By.xpath("//span[@class='user-display']");
	By daysProTrail= By.xpath("//span[@class='trial-indicator']");

	public HomePage(WebDriver driver) {
		this.driver=driver;
		elementactions=new ElementActions(this.driver);
	}
	public String getHomePageTitle() {
		return elementactions.waitForPageTitle(Constants.HOME_PAGE_TITLE);
	}
	
	public boolean isAccountNameVisible() {
		return elementactions.isElementDisplaye(account_name);
	}
	
	public String getAccountName() {
		return elementactions.doGetText(account_name);
	}
	
	public AccountsPage doAccountSettings() {
		elementactions.doClick(daysProTrail);
		
		return new AccountsPage(driver);
	}
	
}
