package com.FaceGenie.TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.FaceGenie.Utilities.CommonUtilities;
import com.FaceGenie.Utilities.ReadConfig;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	static ReadConfig readconfig = new ReadConfig();
	 public static WebDriver driver;
	 public static String url = readconfig.getApplicationURL();
	 public static String email= readconfig.getEmail();
	 public static String password = readconfig.getPassword();
	 
	 public static ExtentReports extent;
	 public static ExtentTest logger;
	// public static Logger logger;
	 
		
      @BeforeSuite
		public static void SetupSuite()
		{
      	
      	ExtentSparkReporter reporter = new ExtentSparkReporter("./Reports/ResoluteAIReport");
  		extent = new ExtentReports();
  		extent.attachReporter(reporter);
  		reporter.config().setReportName("FaceGenieReport");
  		reporter.config().setTheme(Theme.STANDARD);

  		
  		extent.setSystemInfo("Hostname", "LocalHost");
  		extent.setSystemInfo("OS", "Windows");
  		extent.setSystemInfo("Tester Name", "Revathy");
  		extent.setSystemInfo("Browser", "Chrome");
      	
          //logger = extent.createTest("AutomatingRecruitnxt Application for Updating Candidate Status");
	    	PropertyConfigurator.configure("log4j.properties");	
			
  		
	    	//WebDriverManager.chromedriver().setup();
		//	 driver = WebDriverManager.chromedriver().create();
	    	 driver = new ChromeDriver();
	 
			 driver.manage().window().maximize();
			//logger.info("Launched the Browser Succesfully");
			
			 driver.get(url);
			// logger.info("URL Launched");		
			 
			 driver.findElement(By.id("email")).sendKeys(email);
			    // logger.info("Entered Email");
			     
				 driver.findElement(By.id("password")).sendKeys(password);
			//	 logger.info("Entered Password");
				 
				 driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/div[2]/div/div[1]/form[2]/button")).click();
			//	 logger.info("Clicked Submit");
		}
    
    @AfterMethod
		public void teardownmethod(ITestResult result) throws IOException{
			if(result.getStatus() == ITestResult.FAILURE) {
				String Screenshotpath = CommonUtilities.Screenshot(driver);
		
				logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(Screenshotpath).build());
				logger.log(Status.FAIL, "Testcase failed is :" + " " + result.getName());
				logger.fail(result.getThrowable().getMessage());
				
				
			} else if(result.getStatus() == ITestResult.SKIP) {
				logger.log(Status.SKIP, "Testcase skipped is :"+ " " + result.getName());
			}else if(result.getStatus() == ITestResult.SUCCESS) {
				logger.log(Status.PASS, "Testcase passed is :"+ " " + result.getName());
				
			}
      }
    
      
   
    @AfterMethod
  	public void close() {
  		extent.flush();
  	}
      
      
      @AfterSuite
  	public void quit() throws InterruptedException {
  		driver.findElement(By.id("fullNameHeader")).click();
  		driver.findElement(By.xpath("//a[@onclick=\"document.getElementById('logout_form').submit.click()\"]")).click();
  		Thread.sleep(3000);
  		driver.close();

  	}


}
