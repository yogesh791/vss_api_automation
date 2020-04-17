package testcases;

import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class TestCase1 {
	
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	@BeforeTest
	public void setReport() {
		
		sparkReporter=new ExtentSparkReporter("./reports/extent.html");
		sparkReporter.config().setEncoding("utf-8");
		sparkReporter.config().setDocumentTitle("VSS Automation Report");
		sparkReporter.config().setReportName("API Automation Results");
		sparkReporter.config().setTheme(Theme.STANDARD);
		
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("Automation Tester", "Yogesh Tiwari");
		extent.setSystemInfo("Organization", "Virtual Software Solution");
		extent.setSystemInfo("Build Number", "VSS-12345");
	}
	
	@AfterTest
	public void endReport() {
		extent.flush();
	}
	
	@Test
	public void doLogin() {
		test=extent.createTest("Login Test");
		System.out.println("Executing login test");
	}
	
	@Test
	public void userReg() {
		test=extent.createTest("User Reg Test");
		System.out.println("Executing User Reg Test");
	}
	
	@Test
	public void isSkip() {
		test=extent.createTest("Skip Test");
		//throw new SkipException("Skipping test case");
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		
		if(result.getStatus()==ITestResult.SKIP) {
			
		}else if(result.getStatus()==ITestResult.FAILURE) {
			
		}else if(result.getStatus()==ITestResult.SUCCESS) {
			String methodName=result.getMethod().getMethodName();
			String logText="<b>"+"TEST CASE: - "+methodName.toUpperCase()+"  PASSED"+"</b>";
			Markup m=MarkupHelper.createLabel(logText, ExtentColor.GREEN);
			test.pass(m);
		}
		
	}
	

}
