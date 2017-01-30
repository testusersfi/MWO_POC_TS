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
import com.appium.reports.ExtentTestManager;


import mwo.pageobjects.WOPreviewPageObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WOPreviewPage extends PageBase {
	WOPreviewPageObjects previewPageObjects = new WOPreviewPageObjects();

	public WOPreviewPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), previewPageObjects);
	}

	public void previewScreenVerification() {
		waitForPageToLoad(driver, previewPageObjects.SCREEN_HEADER);
		Utils.captureInterimScreenshot(driver);
		assert previewPageObjects.DETAILS_DIRECTIVE_LABEL.isDisplayed();
		assert previewPageObjects.DETAILS_SITE_LABEL.isDisplayed();
		assert previewPageObjects.WO_DETAILS_BUTTON.isDisplayed();
	}
	
	public WOActionsPage launchWOActionsScreen() {
		assert previewPageObjects.NEXT_BUTTON.isDisplayed();
		previewPageObjects.NEXT_BUTTON.click();
		return new WOActionsPage(driver);
	}
	
	public void acceptWorkOrder() {
		waitForPageToLoad(driver, previewPageObjects.SCREEN_HEADER);
		Utils.log("WorkOrder Preview screen is shown");
		try {
		if(isElementPresent(previewPageObjects.ACCEPT_BUTTON)) {
			previewPageObjects.ACCEPT_BUTTON.click();
			ExtentTestManager.getTest().log(LogStatus.PASS, "Preview Page > Accepted the Work Order ");
		} else {
			Utils.log("Work Order is Started or Accepted Already");
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void changeStatustoOnRoute() {
		waitForPageToLoad(driver, previewPageObjects.ONROUTE_BUTTON);
		try {
		if(isElementPresent(previewPageObjects.ONROUTE_BUTTON)) {
			previewPageObjects.ONROUTE_BUTTON.click();
			ExtentTestManager.getTest().log(LogStatus.PASS, "Preview Page > Changed Work Order Status to On Route");
		} else {
			Utils.log("Work Order status is updated to OnRoute already");
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void changeStatustoOnSite() {
		waitForPageToLoad(driver, previewPageObjects.ONSITE_BUTTON);
		try {
		if(isElementPresent(previewPageObjects.ONSITE_BUTTON)) {
			previewPageObjects.ONSITE_BUTTON.click();
			ExtentTestManager.getTest().log(LogStatus.PASS, "Preview Page > Changed Work Order Status to On Site");
		} else {
			Utils.log("Work Order status is updated to ONSITE already");
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public AdditionalDetailsPage launchAdditionalDetailsScreen() {
		previewPageObjects.WO_DETAILS_BUTTON.click();
		return new AdditionalDetailsPage(driver);
	}
	
}
