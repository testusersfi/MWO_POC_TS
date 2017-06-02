package mwo.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.appium.base.PageBase;
import com.appium.base.Utils;
import com.appium.reports.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import mwo.pageobjects.WOOperationObjects;

public class WOOperationPage extends PageBase {

	WOOperationObjects operationObjects = new WOOperationObjects();

	public WOOperationPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), operationObjects);
	}

	// Verify the Expenses screen UI
	public void OperatinSelectionScreenVerification() {
		waitForPageToLoad(driver, operationObjects.SCREEN_HEADER);
		Utils.captureInterimScreenshot(driver);
		assert operationObjects.OPERATION_SEARCH_FIELD.isDisplayed();
	}
	
	
	public WOTimeReportPage SelectOperation() {
		OperatinSelectionScreenVerification();
		if (isElementPresent(operationObjects.DEFAULT_OPERATION)) {
			operationObjects.DEFAULT_OPERATION.click();
			ExtentTestManager.getTest().log(LogStatus.PASS,
					"WO TimeReport Screen > Operation get selected on click of search button");
		} else {
			Utils.log("Operation is unavailable in TimeReport screen");
			hideKeyboardBasedOnPlatform();
			goBack();
			
		}
		return new WOTimeReportPage(driver);
	}
}
