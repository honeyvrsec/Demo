package com.MyFirstProject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sun.istack.internal.logging.Logger;

public class AppTest {
	static WebDriver driver;
	static Logger logger = Logger.getLogger(AppTest.class);
	static Properties Prop;

	@BeforeMethod

	public void main() throws IOException {
		System.setProperty("webdriver.chrome.driver", "\\Users\\91949\\Downloads\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		Properties Prop=new Properties();
		FileInputStream ip = new FileInputStream("C:\\Users\\91949\\eclipse-workspace\\myproject\\Config.properties");
		Prop.load(ip);
		System.out.println("File loaded");
		if("Chrome".equals(Prop.getProperty("Browser"))) {
		driver.get("https://www.facebook.com");
		}
		// System.out.println("Chrome launched successfully");
		logger.info("Chrome launched successfully");
	}

	@Test
	public void Validating() {

		String expectedvalue = driver.getTitle();

		if (expectedvalue.equals("Facebook – log in or sign up")) {
			logger.info("TEST IS PASSED");
		} else {
			logger.info("TEST IS FAILED");
		}
	}

	@AfterMethod
	public void teardown() {
		driver.close();
	}
}
