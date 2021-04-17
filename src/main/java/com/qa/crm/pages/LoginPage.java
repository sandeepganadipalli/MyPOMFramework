package com.qa.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.crm.base.BasePage;
import com.qa.crm.util.Constants;
import com.qa.crm.util.ElementActions;

public class LoginPage extends BasePage{
	
	WebDriver driver;
	ElementActions elementactions;
	//1. define OR/Page Objects:
	By email_id=By.name("email");
	By password=By.name("password");
	By login_Btn=By.xpath("//div[text()='Login']");
	By sign_Up=By.linkText("Sign Up");
	By Forgot_password=By.linkText("Forgot your password?");
	
	//2.define a constructor  
	public LoginPage(WebDriver driver){
		this.driver=driver;
		elementactions=new ElementActions(this.driver);
	}
	
	//3. Page Actions/Methods
	public String getLoginPageTitle() {
		return elementactions.waitForPageTitle(Constants.LOGIN_PAGE_TITLE);
	}
	
	public HomePage doLogin(String username,String pwd) {
		
		elementactions.doSendKeys(email_id, username);
		elementactions.doSendKeys(password, pwd);
		elementactions.doClick(login_Btn);
		
		return new HomePage(driver);
		
	}
	
	public boolean signUpLinkDisplayed() {
	return elementactions.isElementDisplaye(sign_Up);
	}
	public boolean forgotPasswordLinkidDisplayed() {
		return elementactions.isElementDisplaye(Forgot_password);
	}
	
	
}
