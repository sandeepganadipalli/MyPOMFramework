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
	
	public static  WebDriver driver;
	public static Properties prop;
	
	
	
	/**
	 * This method is used to get the properties form config prop file
	 * @return prop
	 */
	public Properties init_properties() {
		
		 try {
			 prop= new Properties(); 
//			FileInputStream ip= new FileInputStream("C:\\Users\\sande\\eclipse-workspace\\MavenHybridApproach\\"
//					+ "src\\main\\java\\com\\qa\\crm\\config\\config.properties");
//			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\com\\qa\\crm"
//					+ "\\config\\config.properties");
			 
			 FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/qa/crm"
						+ "/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
		 return prop;
	}
	/**
	 * This method is used to initialize the driver on the basis of browser
	 * @return driver
	 */
	public WebDriver int_driver(Properties prop) {
		String browser=prop.getProperty("browser");
		String url=prop.getProperty("url");

		if(browser.equals("chrome")) {
			//WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver", "C:/Users/sande/OneDrive/Desktop/Automation/chromedriver_win32/chromedriver.exe");	
			 driver = new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			//WebDriverManager.firefoxdriver().setup();
			System.setProperty("webdriver.gecko.driver", "C:/Users/sande/OneDrive/Desktop/Automation/geckodriver-v0.29.0-win64/geckodriver");	
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
}
