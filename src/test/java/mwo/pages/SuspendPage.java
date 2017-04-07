package mwo.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import com.appium.base.BasePageObjects;
import com.appium.base.PageBase;
import com.appium.base.Utils;
import com.appium.reports.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;

import mwo.pageobjects.WOSuspendPageObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SuspendPage extends PageBase {
	WOSuspendPageObjects suspendPageObjects = new WOSuspendPageObjects();

	public SuspendPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), suspendPageObjects);
	}

	// Verify the suspend work order screen UI
	public void suspendScreenUIVerification() {
		waitForPageToLoad(driver, suspendPageObjects.REASON_CODE_LABEL);
		Utils.captureInterimScreenshot(driver);
		assert BasePageObjects.MORE_OPTIONS_ICON.isDisplayed();
		assert BasePageObjects.REASON_DESCRIPTION.isDisplayed();
		assert suspendPageObjects.REASON_CODE_SPINNER.isDisplayed();
		assert suspendPageObjects.REASON_CODE_LABEL.isDisplayed();
		assert suspendPageObjects.REASON_NOTES_LABEL.isDisplayed();
		assert suspendPageObjects.REASON_COMMENTS_FIELD.isDisplayed();
		assert suspendPageObjects.REASON_TYPE_LABEL.isDisplayed();
		assert suspendPageObjects.REASON_TYPE_SPINNER.isDisplayed();
		assert suspendPageObjects.REASON_TITLE.isDisplayed();
	}

	// Suspend the work order
	public WOPreviewPage suspendWorkOrder() {
		waitForPageToLoad(driver, suspendPageObjects.REASON_CODE_LABEL);
		selectReason("Customer not contacted");
		enterCommentsInNotesField();
		BasePageObjects.SAVE_BUTTON.click();
		return new WOPreviewPage(driver);
	}

	// Select the reason for suspending the work order
	public void selectReason(String reason_type) {
		waitForPageToLoad(driver, suspendPageObjects.SPINNER_DEFAULT_TEXT);
		suspendPageObjects.REASON_CODE_SPINNER.click();
		String reason_code_path = findRelativeXpath(driver, BasePageObjects.REASON_CODE_ANDROID, reason_type);
		if (isElementPresent(By.xpath(reason_code_path))) {
			driver.findElement(By.xpath(reason_code_path)).click();
			ExtentTestManager.getTest().log(LogStatus.PASS, "Given reason code is selected");
		} else {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Given reason code is not available in the list");
		}
	}

	// enter comments in Notes field
	public void enterCommentsInNotesField() {
		if (isElementPresent(suspendPageObjects.REASON_NOTES_LABEL)) {
		enterTextinCommentsFeild(suspendPageObjects.REASON_COMMENTS_FIELD, "Due to health issues suspending workorder");
		} else {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Comments text field is not visible in the screen");
		}
		
	}

}
