package mwo.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.appium.base.BasePageObjects;
import com.appium.base.PageBase;
import com.appium.base.Utils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import com.appium.reports.ExtentTestManager;

import mwo.pageobjects.WOReturnsPageObjects;

import io.appium.java_client.AppiumDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ReturnsPage extends PageBase {
	WOReturnsPageObjects returnsPageObjects = new WOReturnsPageObjects();

	public ReturnsPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), returnsPageObjects);
	}

	// Verify the Materials screen UI
	public void ReturnsScreenUIVerification() {
		waitForPageToLoad(driver, returnsPageObjects.QUANTITY_TO_RETURN_FIELD_LABEL);
		Utils.captureInterimScreenshot(driver);
		assert returnsPageObjects.SCREEN_HEADER.isDisplayed();
		assert returnsPageObjects.PART_NUMBER_LABEL.isDisplayed();
		assert returnsPageObjects.PART_NUMBER_TEXT_FIELD.isDisplayed();
		assert returnsPageObjects.QUANTITY_TO_RETURN_FIELD_LABEL.isDisplayed();
		assert returnsPageObjects.QUANTITY_TO_RETURN_TEXT_FIELD.isDisplayed();
	}

	public SelectPartPage selectPartToReturn() {
		assert returnsPageObjects.PART_NUMBER_TEXT_FIELD.isDisplayed();
		returnsPageObjects.PART_NUMBER_TEXT_FIELD.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "Parts from My Stock Page > Part selection screen is displayed ");
		return new SelectPartPage(driver);
	}
	
	public WOActionsPage confirmItemReturn() throws InterruptedException {
		if(isElementPresent(returnsPageObjects.SERIAL_NUMBER_LABEL)) {
			BasePageObjects.SAVE_BUTTON.click();
			Thread.sleep(2000);
			ReturnsScreenUIVerification();
			Thread.sleep(2000);
			goBack();
			Thread.sleep(2000);
			goBack();
			Thread.sleep(2000);
			goBack();
		} else {
			Utils.log("Return parts are not selected");
		}
		return new WOActionsPage(driver);
	}
}
