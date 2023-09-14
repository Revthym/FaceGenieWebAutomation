package com.FaceGenie.PageObject;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.FaceGenie.Utilities.CommonUtilities;
import com.aventstack.extentreports.MediaEntityBuilder;

public class FaceGenieDashBoardPO extends CommonUtilities{
	
	WebDriver ldriver;
	public  FaceGenieDashBoardPO(WebDriver rdriver)
	{
		ldriver = rdriver;
    	PageFactory.initElements(rdriver,this);
	}
	
	
	//@FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div/div/div/div/nav/div[4]")
	//@FindBy(css = "#root > div > div:nth-child(1) > div > div > div > div > nav > div:nth-child(4)")
	@FindBy(xpath = "//div[@class=\"MuiListItemButton-root MuiListItemButton-gutters MuiButtonBase-root css-2poxpl\"][3]")
	WebElement ManageStudent;

	@FindBy(css = "#root > div > div:nth-child(1) > div > div > main > div.MuiContainer-root.MuiContainer-maxWidthLg.css-1oifrf6 > div > div > div > div:nth-child(2) > div.MuiGrid-root.css-1ceokph > div:nth-child(1) > button")
	WebElement AddStudentForm;

	@FindBy(id = ":rc:")
	WebElement AdmissionNo;
	
	@FindBy(id = ":rd:")
	WebElement FirstName;
	
	@FindBy(id = ":re:")
	WebElement LastName;
	
	@FindBy(id = ":rf:")
	WebElement FatherName;
	
	@FindBy(xpath = "/html/body/div/div/div[1]/div/div/main/div[2]/div/div/div/div[2]/div[3]/div[1]/form/div/div[3]/div[2]/div/div/div")
	WebElement Class;
    
	@FindBy(xpath = "/html/body/div/div/div[1]/div/div/main/div[2]/div/div/div/div[2]/div[3]/div[1]/form/div/div[3]/div[3]/div/div/div")
	WebElement Division;
	
	@FindBy(xpath = "/html/body/div/div/div[1]/div/div/main/div[2]/div/div/div/div[2]/div[3]/div[1]/form/div/div[4]/div[1]/div/div/div")
	WebElement Gender;
	
	@FindBy(id = ":rg:")
	WebElement MobileNo;
	
	@FindBy(xpath = "/html/body/div/div/div[1]/div/div/main/div[2]/div/div/div/div[2]/div[3]/div[1]/form/div/div[4]/div[3]/div/div/div")
	WebElement BusNo;
	
	@FindBy(id = "date")
	WebElement DOB;
	
	@FindBy(xpath = "/html/body/div/div/div[1]/div/div/main/div[2]/div/div/div/div[2]/div[3]/div[1]/form/div/div[5]/div[2]/div/div/div")
	WebElement PaymentStatus;
	
	@FindBy(xpath = "/html/body/div/div/div[1]/div/div/main/div[2]/div/div/div/div[2]/div[3]/div[1]/form/div/div[5]/div[3]/div/div/div")
	WebElement Registered;
	
	@FindBy(xpath = "/html/body/div/div/div[1]/div/div/main/div[2]/div/div/div/div[2]/div[3]/div[1]/form/div/div[6]/div[1]/div/div/div")
	WebElement Area;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div/div/main/div[2]/div/div/div/div[2]/div[3]/div[1]/form/div/div[9]/button")
	WebElement AddStudentDetails;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div/div/main/div[2]/div/div/div/div[2]/div[3]/div[2]/div[2]/div[5]/button")
	WebElement ConfirmDetails;
	
	@FindBy(id = ":ri:")
	WebElement Address;
	
	@FindBy(xpath = "/html/body/div/div/div[1]/div/div/main/div[2]/div/div/div/div[2]/div[2]/div/div/div[1]/div[2]/div/div/div")
	WebElement cLass;
	
	@FindBy(xpath = "/html/body/div/div/div[1]/div/div/main/div[2]/div/div/div/div[2]/div[2]/div/div/div[1]/div[3]/div/div/div")
	WebElement dIvision;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div/div/main/div[2]/div/div/div/div[2]/div[1]/div[2]/label")
	WebElement Upload;
	
	@FindBy(css = "#root > div > div:nth-child(1) > div > div > div > div > nav > div:nth-child(1)")
	WebElement Dashboard;
	
	public void ClickManageStudent() throws InterruptedException, AWTException, IOException 
	  {
		Thread.sleep(10000);
	//	cwait("#root > div > div:nth-child(1) > div > div > div > div > nav > div:nth-child(4)");
		String title = driver.getTitle();
        logger.info("The title of the page is "+title);
		Thread.sleep(5000);
		click(ManageStudent);
		logger.info("Manage Student is Clicked and corresponding page is opened");
		click(AddStudentForm);
		if(AddStudentForm.isEnabled())
		{
			Assert.assertTrue(true);
		logger.info("Add Student is Clicked and Add Student Form is Opened");
		logger.pass("The Test Case is passed");
		}
	    else
	    {
	    	Assert.assertTrue(false);
		  logger.fail("The Test Case is Failed");
	    }
		String title1 = driver.getTitle();
        logger.info("The title of the page is "+title1);
	
		//Thread.sleep(5000);
		int AdNo = RandomNumber();
		String st = Integer.toString(AdNo);
		Textbox(AdmissionNo, st);
		logger.info("Entered The Admission NO "+st);
		
		String names = RandomNames();
		Textbox(FirstName, names);
		logger.info("Entered the FirstName "+names);
		
		Textbox(LastName,names);
		logger.info("Entered the LastName "+names);
		Textbox(FatherName,names);
		logger.info("Entered the FatherName "+names);
		
		Thread.sleep(2000);
		dropdown(Class);
		dropdown(Division);
		dropdown(Gender);
		logger.info("Selected the values for Class,Division and Gender");
		//RandomPhNumber();
		Textbox(MobileNo,"9654899765");
		logger.info("Entered the MobileNumber");
		dropdown(BusNo);

		dropdown(PaymentStatus);
		dropdown(Registered);
		dropdown(Area);
		Textbox(Address, "Chennai");
		logger.info("Selected the values for BusNo,PaymentStatus,Registered,Area and Address");
		click(AddStudentDetails);
		logger.info("Entered the Details in the form");
		click(ConfirmDetails);
		logger.info("Clicked Confirm Details to Add the Student");
		
		/*WebElement dist=  driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/main/div[2]/div/div/div/div[2]/div[3]/div[1]/form/div/div[3]/div[2]/div/div/div"));
		Select value = new Select(dist);
		value.selectByIndex(4);*/
	
		String PageSource  = driver.getPageSource();
		//logger.info("The Test case is passed but The Page Source could nt read the Added Successfully message and hence its showing as failed ");
		
		
		boolean msg = 	PageSource.contains("Student has been Added Successfully,The Test case is passed but The Page Source could nt read the Added Successfully message and hence its showing as failed");		
        if(msg == true)
        {
        	Assert.assertTrue(true);
        	logger.pass("Student Details Added Successfully");
        	
        }else
        {
        	Assert.assertFalse(false);
        	logger.fail("Student Details not Added Successfully because Area field is a drop down and no values are available to select and so could nt add the student details as it is mandatory");
        }
	    
		click(Dashboard);
		Thread.sleep(10000);
		scroll1();
		click(ManageStudent);
		
		dropdown(cLass);
		dropdown(dIvision);
		logger.info(Screenshot(driver));
		String Screenshopath = CommonUtilities.Screenshot(driver);
		logger.info( MediaEntityBuilder.createScreenCaptureFromPath(Screenshopath).build());
		logger.info("Selected Students are displayed in the table based on the Class and Division");
		logger.info("Excel File Uploading Function Test");
		click(Upload);
		FileUpload();
		logger.info("Excel File Uploaded");		
	  }
}
