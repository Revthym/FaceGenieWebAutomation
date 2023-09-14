package com.FaceGenie.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.FaceGenie.Utilities.CommonUtilities;

public class FaceGeniePO extends CommonUtilities {
	
	WebDriver ldriver;
	public  FaceGeniePO(WebDriver rdriver)
	{
		ldriver = rdriver;
    	PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(id = "email-label")
	WebElement Email;
	 
	@FindBy(id = "password-label")
	WebElement Password;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div/div/div[2]/div/div[1]/form[2]/button")
	WebElement LogIn;
	
}
