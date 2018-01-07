package com.test.automation.Guru99BankProject.baseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;


public class TestBase {
	
	public WebDriverEventListener eventListener;
	public Properties OR = new Properties();
	//public static ExtentReports extent;
	//public static ExtentTest test;
	//public ITestResult result;


	public static final Logger log = Logger.getLogger(TestBase.class.getName());
	public WebDriver driver;
	public void getUrl(String url) {
		log.info("navigating to :-" + url);
		driver.get(url);
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	public void setDriver(EventFiringWebDriver driver) {
		this.driver = driver;
	}

	
	public void loadData() throws IOException {
		File file = new File(System.getProperty("user.dir") + "/src/main/java/com/test/automation/Guru99BankProject/config/config.properties");
		FileInputStream f = new FileInputStream(file);
		OR.load(f);

	}
	public void init() throws IOException {
		loadData();
		String log4jConfPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		System.out.println(OR.getProperty("browser"));
		selectBrowser(OR.getProperty("browser"));
		getUrl(OR.getProperty("url"));
	}
}
