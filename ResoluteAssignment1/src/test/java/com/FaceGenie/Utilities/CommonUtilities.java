package com.FaceGenie.Utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
//import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.FaceGenie.TestCases.BaseClass;

import lombok.var;




public class CommonUtilities extends BaseClass{
	
	//Performing Single Click operation using the xpath locator.
	
	 public static void ClickingbyXpath(WebElement element)
	    {
	    	element.click();
	    }
	 public static void click(WebElement element)
	    {
	    	element.click();
	    }
	 
	 //Performing Single Click Operation using LinkText Locator
	 public static void LinkText(WebElement element) 
	 	{
		 element.click();
	 	}
	 
	 
	 public static void Navigation(WebElement element)
	  	{
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(element));
			Actions act = new Actions(driver);
		//	System.out.println(element);
			act.moveToElement(element);
			act.perform();
	  	}
	 
	 //Handling drop downs using Select class
	 public static void DropDown(WebElement element, String Text)
	 {
		
		 
		 Select stat = new Select(element);
         stat.selectByVisibleText(Text);
	 }
	 
	 //Implicit wait
	 public static void waits()
     {
   	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     }
	 
	 //Explicit wait
	 public static void explicitwait(WebElement id)
	    {
	    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(id));
			//wait.until(ExpectedConditions.elementSelectionStateToBe(null, false));
	    }
	 public static void cwait(String locator)
     {
		
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		 WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id(locator)));
		 element.click();
     }
	 
	 //Scrolling the page
	 public static void scroll() 
	 {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,0)");
	 }
	  public static void scroll1()
	  {
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
	  }
	 
	 //For taking screenshot
	 public static String Screenshot1(WebDriver driver,String filename) throws IOException 
	    {
	         
	    	File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  //  FileHandler.copy(srcfile, new File(System.getProperty("./ScreenShots"+tname+".png")));
		    String path = System.getProperty("user.dir")+"/Screenshots/" +filename +System.currentTimeMillis()+ ".png";
			File destination = new File(path);
			
			try {
				FileUtils.copyFile(src, destination);
				logger.info("Screenshot Captured");
			}catch(IOException e)
			{
				System.out.println("Capture failed"+ e.getMessage());
			}
			return path;
	    
	    }
	 
	 public static String Screenshot(WebDriver driver) throws IOException 
	    {
	         
	    	File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  //  FileHandler.copy(srcfile, new File(System.getProperty("./ScreenShots"+tname+".png")));
		    String path = System.getProperty("user.dir")+"/ScreenShots/"+System.currentTimeMillis()+ ".png";
			File destination = new File(path);
			try {
				FileUtils.copyFile(src, destination);
			}catch(IOException e)
			{
				System.out.println("Capture failed"+ e.getMessage());
			}
			return path;
	    
	    }
	 public static void Textbox(WebElement element, String value)
	 {
		 element.sendKeys(value);	  
	 }
	 
	 
	 //Clearing the text box and then entering the values
	 public static void TextboxbyIdClear(WebElement element, String value)
	   {
		   element.clear();
		   element.sendKeys(value);	  
		   element.click();
	   }
	 
	 public static void TextboxClear(WebElement element, String value)
	   {
		   element.clear();
		   element.sendKeys(value);	  
		   element.click();
	   }
	 
	 //Switching the window
	 public static void SwitchWindow()
	 {
		 Set<String>totalopenwindow = driver.getWindowHandles();
		   List<String>win = new ArrayList<String>(totalopenwindow);
		   driver.switchTo().window(win.get(0));
	 }
	 public static void DropDown(WebElement locator)
	 {
	 WebElement dd =  driver.findElement((By)locator);
		Select value = new Select(dd);
		value.selectByIndex(1);
		//value.selectByVisibleText("Cuddalore");
	 }
	 public void dropdown(WebElement element) throws AWTException
	 {
		element.click();
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_ENTER);
		
		 // driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/main/div[2]/div/div/div/div[2]/div[3]/div[1]/form/div/div[3]/div[2]/div/div/div")).click();
	 }
	 public int RandomNumber()
	 {
		
		 Random rand = new Random();
		 int value = rand.nextInt(10000);
		 System.out.println("Random value: " + value);
		return value;
	 }
	 public int RandomPhNumber()
	 {
		
		 Random rand = new Random();
		 int value = rand.nextInt(1000000000);
		 System.out.println("Random value: " + value);
		return value;
	 }
	 public String RandomNames()
	 {
		 String randomLetters = RandomStringUtils.random(5, true, false);
		 System.out.println("Random letters: " + randomLetters);
		return randomLetters;

	 }
	 
	 public void FileUpload() throws AWTException
	 {
		 StringSelection ss = new StringSelection("C:\\Users\\srevy\\OneDrive\\WriteData.xlxs");
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);
			Robot rb = new Robot();
			//Thread.sleep(5000);
			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_V);
			rb.keyRelease(KeyEvent.VK_CONTROL);
			rb.keyRelease(KeyEvent.VK_V);
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
	 }
	
}
