package com.qa.crm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author sandeep
 *
 */
public class BasePage {
	
	WebDriver driver;
	Properties prop;
	
	/**
	 * This method is used to initialize the driver on the basis of browser
	 * @return driver
	 */
	public WebDriver int_driver(Properties prop) {
		String browser=prop.getProperty("browser");
		String url=prop.getProperty("url");

		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
		}
		else {
			System.out.println("Please define the proper browser val...");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();	
		driver.get(url);
		
		return driver;
	}
	
	/**
	 * This method is used to get the properties form config prop file
	 * @return prop
	 */
	public Properties init_properties() {
		 prop= new Properties(); 
		 try {
			FileInputStream ip= new FileInputStream("C:\\Users\\sande\\eclipse-workspace\\MavenHybridApproach\\"
					+ "src\\main\\java\\com\\qa\\crm\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
		 return prop;
	}

}
