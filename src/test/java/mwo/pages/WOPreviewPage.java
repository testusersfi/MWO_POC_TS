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
	OnHoldPage wo_onholdPage;
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
		changeWOStatus(previewPageObjects.ACCEPT_BUTTON);
	}

	public void changeStatustoOnRoute() {
		changeWOStatus(previewPageObjects.ONROUTE_BUTTON);
	}
	
	public void changeStatustoOnSite() {
		changeWOStatus(previewPageObjects.ONSITE_BUTTON);
	}
	
	
	public OnHoldPage changeStatusToOnHold() {
		changeStatusToOnHoldorReject(previewPageObjects.ONHOLD_BUTTON);
		return new OnHoldPage(driver);
	}
	
	public OnHoldPage changeWOStatusToReject() {
		changeStatusToOnHoldorReject(previewPageObjects.REJECT_BUTTON);
		return new OnHoldPage(driver);
	}
	
	public OnHoldPage changeStatusToOnHoldorReject(MobileElement status_button_element) {
		waitForPageToLoad(driver, status_button_element);
		try {
			if(isElementPresent(status_button_element)) {
				status_button_element.click();
				ExtentTestManager.getTest().log(LogStatus.PASS, "Preview Page >"+ status_button_element.toString() + "is displayed on click of On Hold/Reject button");
				return new OnHoldPage(driver);
			} else {
				Utils.log(status_button_element.toString() + "button is not displayed");
			}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		return null;
	}
	
	public SuspendPage changeStatusToSuspend() {
		waitForPageToLoad(driver, previewPageObjects.SUSPEND_BUTTON);
		try {
			if(isElementPresent(previewPageObjects.SUSPEND_BUTTON)) {
				previewPageObjects.SUSPEND_BUTTON.click();
				ExtentTestManager.getTest().log(LogStatus.PASS, "Preview Page > Suspend or Abort screen is displayed on click of Suspend button ");
				return new SuspendPage(driver);
			} else {
				Utils.log("Suspend button is not displayed");
			}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		return null;
	}
	
	public AdditionalDetailsPage launchAdditionalDetailsScreen() {
		previewPageObjects.WO_DETAILS_BUTTON.click();
		return new AdditionalDetailsPage(driver);
	}
	public void rejectButtonVerificationPostSuspendWO() {
		assert previewPageObjects.REJECT_BUTTON.isDisplayed();
		previewScreenVerification();
	}
	
	public void buttonOffHoldVerification() {
		assert previewPageObjects.OFFHOLD_BUTTON.isDisplayed();
	}
	public void contactDetailsVerification() throws InterruptedException {
		//String contact_button = previewPageObjects.WO_CONTACT_DETAILS_BUTTON.toString();
		scrolltoText(previewPageObjects.WO_CONTACT_DETAILS_BUTTON);
	}
	
	public void objectDetailsVerfication() throws InterruptedException {
		//String contact_button = previewPageObjects.WO_OBJECT_DETAILS_BUTTON.toString();
		scrolltoText(previewPageObjects.WO_OBJECT_DETAILS_BUTTON);
	}
	
	public void changeWOStatus(MobileElement status_button) {
		waitForPageToLoad(driver, status_button);
		try {
			if(isElementPresent(status_button)) {
				status_button.click();
				ExtentTestManager.getTest().log(LogStatus.PASS, "Preview Page > Suspend or Abort screen is displayed on click of Suspend button ");
				
			} else {
				Utils.log(status_button.toString() + "is not displayed");
			}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
	}
}
