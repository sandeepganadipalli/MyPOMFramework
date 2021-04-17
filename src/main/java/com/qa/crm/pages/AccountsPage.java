package com.qa.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.crm.util.ElementActions;

public class AccountsPage {
	
	WebDriver driver;
	ElementActions elementactions;
	//1. define OR/Page Objects:
	
	By accounts=By.xpath("//a[text()='Accounts']");
	By companyname=By.name("company_name");
	By address=By.name("address");
	By city= By.name("city");
	By postalcode=By.name("zip");
	By state=By.name("state");
	By country=By.xpath("//div[contains(@class,'visible menu transition')]//div/span");
	By saveBtn=By.xpath("//button[text()='Save']");
	By accountPageheaderText=By.xpath("//div[@class='sub header']");
	
	//2.define a constructor  
	public AccountsPage(WebDriver driver) {
		this.driver=driver;
		elementactions=new ElementActions(this.driver);
	}
	
	
	
		//3. Page Actions/Methods
	
		public String getAccountPageHeader() {
			return elementactions.doGetText(accountPageheaderText);
		}
	
		public void setAccount(String company_name,String Address,String City,String posal_code,String State) {
		
		elementactions.doClick(accounts);
		elementactions.doSendKeys(companyname, company_name);
		elementactions.doClick(address);
		elementactions.doSendKeys(accountPageheaderText, Address);
		elementactions.doClick(city);
		elementactions.doSendKeys(city, City);
		elementactions.doClick(postalcode);
		elementactions.doSendKeys(postalcode, posal_code);
		elementactions.doClick(state);
		elementactions.doSendKeys(state, State);
		elementactions.doClick(saveBtn);
		}
	

}
