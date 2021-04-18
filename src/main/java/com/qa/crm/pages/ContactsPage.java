package com.qa.crm.pages;

import org.openqa.selenium.WebDriver;

import com.qa.crm.base.BasePage;

public class ContactsPage extends  BasePage{

	WebDriver driver;
	
	public ContactsPage(WebDriver driver) {
		
		this.driver=driver;
	}
	
	public void CreateContact() {
		System.out.println("Create contact..");
	}

	public String getContactPageTitile() {
		System.out.println("Create contact..");
		return driver.getTitle();
	}
	
}
