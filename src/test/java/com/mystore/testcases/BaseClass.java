package com.mystore.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import com.mystore.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	ReadConfig readconfig = new ReadConfig();

	String url= readconfig.getbaseurl();

	String browser= readconfig.getbrowser();

	public String emailaddress= readconfig.getemail();

	String password = readconfig.getpassword();



	public static WebDriver driver;
	public static Logger logger;

	@BeforeClass
	public void SetUp()
	{
		//launch browser
		switch(browser.toLowerCase())
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			driver = null;
			break;

		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		logger=LogManager.getLogger("MyStoreV1");

		driver.get(url);

		logger.info("url opened");
	}
	/* @AfterClass
	public void teardown()
	{
		driver.close();
		driver.quit();
	}*/

	public void captureScreenshot(WebDriver driver, String testname)throws IOException
	{
		TakesScreenshot screenshot=((TakesScreenshot)driver);

		File src=screenshot.getScreenshotAs(OutputType.FILE);

		File dst= new File(System.getProperty("user.dir") + "//Screenshorts//" + testname + ".png");

		FileUtils.copyFile(src, dst);		
	}

}
