package com.FaceGenie.TestCases;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.FaceGenie.PageObject.FaceGenieDashBoardPO;
import com.FaceGenie.PageObject.FaceGeniePO;

public class TC_Dashboard extends BaseClass{
	
	@Test(enabled = true)
	public static void Dashboard() throws InterruptedException, AWTException, IOException
	{
	FaceGenieDashBoardPO fc =  new FaceGenieDashBoardPO(driver);
			logger = extent.createTest("Dasboard");
			logger.info("Logged in to the appliaction");
			logger.info("Welcome to Dashboard");
			fc.ClickManageStudent();
			
	        	//	WebDriverWait wait = new WebDriverWait(driver, 30);
			    // WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#root > div > div:nth-child(1) > div > div > div > div > nav > div:nth-child(4)")));
			    //element.click();		
	}
}
