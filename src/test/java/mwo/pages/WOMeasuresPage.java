package mwo.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.appium.base.BasePageObjects;
import com.appium.base.PageBase;
import com.appium.base.Utils;
import com.appium.base.PageBase.SWIPE_V_OPTIONS;
import com.appium.reports.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import mwo.pageobjects.MeasuresScreenPageObjects;
import mwo.pageobjects.WOExpensesPageObjects;

public class WOMeasuresPage extends PageBase{
	MeasuresScreenPageObjects measurePageObjects = new MeasuresScreenPageObjects();

	public WOMeasuresPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), measurePageObjects);
	}

	// Verify the Measure screen UI
	public void MeasureScreenVerification() {
		waitForPageToLoad(driver, measurePageObjects.MEASURES_SCREEN_HEADER);
		Utils.captureInterimScreenshot(driver);
		assert measurePageObjects.MEASURES_SCREEN_SUB_TITLE.isDisplayed();
		assert measurePageObjects.OBJECTS_SEARCH_TEXT_FIELD.isDisplayed();
		}
	
	
	public void SearchforObjects(String recoredValue)throws InterruptedException {
		MeasureScreenVerification();
		if (isElementPresent(measurePageObjects.LIST_ITEM_SEPERATOR)) {
			measurePageObjects.LIST_ITEM_SEPERATOR.click();
			ExtentTestManager.getTest().log(LogStatus.PASS,
					"WO Measure Screen > objects selected on click of search button");
			
			RegisterMeasurements(recoredValue);
			
		} else {
			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"WO Measure Screen > objects are not available to select in lookup");
			hideKeyboardBasedOnPlatform();
			goBack();
			
		}
		//return new HomePage(driver);
	}
	
	public HomePage navigateBackToHomePage() throws InterruptedException {
		goBack();
		Thread.sleep(2000);
		goBack();
		Thread.sleep(2000);
		return new HomePage(driver);
	}
	
	
	public void RegisterMeasurements(String recoredValue)  throws InterruptedException
	{
		scrolltoText(measurePageObjects.RECORDED_VALUE_NEW);
		
		Utils.captureInterimScreenshot(driver);
		
		if (isElementPresent(measurePageObjects.RECORDED_VALUE_NEW_FIELD)) {
			
			hideKeyboardBasedOnPlatform();
			measurePageObjects.RECORDED_VALUE_NEW_FIELD.click();
			enterTextUsingadb(String.valueOf(recoredValue));
			hideKeyboardBasedOnPlatform();
			assert BasePageObjects.SAVE_BUTTON.isDisplayed();
			BasePageObjects.SAVE_BUTTON.click();
			
		      
			if(recoredValue.trim().equals(measurePageObjects.RECORDED_VALUE_OLD_FIELD.getText().trim()))
				{
		    	   ExtentTestManager.getTest().log(LogStatus.PASS,
							"WO Measure Screen > objects registered successfully");
				}
		       else
		       {
		    	   ExtentTestManager.getTest().log(LogStatus.FAIL,
							"WO Measure Screen > objects failed to register");
		       }
			
		}
		
	}
	
}
