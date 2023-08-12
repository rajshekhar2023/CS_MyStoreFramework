package com.mystore.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportListner implements ITestListener {
	
	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;
	ReadConfig readconfig = new ReadConfig();
	public void configureReport()
	{
		String timestamp= new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		String reportname= "MyStoreReportname-" + timestamp + ".html";
		htmlReporter= new ExtentSparkReporter(System.getProperty("user.dir") + "//Reports//" + reportname);
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		reports.setSystemInfo("Machine", "testpc1");
		reports.setSystemInfo("OS", "Window");
		reports.setSystemInfo("browser", readconfig.getbrowser());
		reports.setSystemInfo("username", "Raj");
		
		htmlReporter.config().setDocumentTitle("Extent Listner Report Demo");
		htmlReporter.config().setReportName("This is my first Report");
		htmlReporter.config().setTheme(Theme.DARK);
		
		
	}
	
	public void onStart(ITestContext Result)
	{
		configureReport();
		System.out.println("On start method invoked");
	}
	
	public void onFinish(ITestContext Result)
	{
		System.out.println("On finish method invoked");
		reports.flush();
	}
	
	public void onTestFailure(ITestResult Result)
	{
		System.out.println("Name of test method failed " + Result.getName());
		test = reports.createTest(Result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test case is: " +  Result.getName(), ExtentColor.RED));
	   
		String Screenshotpath= System.getProperty("user.dir") + "\\Screenshorts\\" + Result.getName() + ".png";
		
		File filescreenshot= new File(Screenshotpath);
		
		if(filescreenshot.exists())
		{
			test.fail("Captured below screenshot " + test.addScreenCaptureFromPath(Screenshotpath));
		}
		// test.addScreenCaptureFromPath(null);
	
	}
	public void onTestSkipped(ITestResult Result)
	{
		System.out.println("Name of test method Skipped " + Result.getName());
		test = reports.createTest(Result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("Name of the Skipped test case is: " +  Result.getName(), ExtentColor.YELLOW));
	}
	public void onTestStart(ITestResult Result)
	{
		System.out.println("Name of test method started " + Result.getName());
	}
	public void onTestSuccess(ITestResult Result)
	{
		System.out.println("Name of test method Successfully executed " + Result.getName());
		test = reports.createTest(Result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Name of the Passed test case is: " +  Result.getName(), ExtentColor.GREEN));
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult Result)
	{
		
	}
}
