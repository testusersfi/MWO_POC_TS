package mwo.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.appium.base.BasePageObjects;
import com.appium.base.PageBase;
import com.appium.base.Utils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import com.report.factory.ExtentTestManager;


import mwo.pageobjects.WOPreviewPageObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WOPreviewPage extends PageBase {
	WOPreviewPageObjects previewPageObjects = new WOPreviewPageObjects();

	public WOPreviewPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), previewPageObjects);
	}

	public void homeScreenVerification() {
		waitForPageToLoad(driver, previewPageObjects.SCREEN_HEADER);
		Utils.captureInterimScreenshot(driver);
		//assert BasePageObjects.MORE_OPTIONS_ICON.isDisplayed();
		//assert woPageObjects.BAR_CODE_SCAN.isDisplayed();
		// assert homePageObjects.WORK_ORDERS_BUTTON.isDisplayed();
	}
	
	public void launchWOActionsScreen() {
		waitForPageToLoad(driver, previewPageObjects.SCREEN_HEADER);
		Utils.log("WorkOrder Preview screen is shown");
		if(isElementPresent(previewPageObjects.ACCEPT_BUTTON)) {
			previewPageObjects.ACCEPT_BUTTON.click();
		} else {
			Utils.log("Work Order is Started or Accepted Already");
		}
		assert previewPageObjects.NEXT_BUTTON.isDisplayed();
		previewPageObjects.NEXT_BUTTON.click();
		//return new WOActionsPage(driver);
	}

}
