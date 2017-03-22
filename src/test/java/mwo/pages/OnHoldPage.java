package mwo.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import com.appium.base.BasePageObjects;
import com.appium.base.PageBase;
import com.appium.base.Utils;
import com.appium.reports.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;

import mwo.pageobjects.WOOnHoldPageObjects;
import mwo.pageobjects.WOSuspendPageObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class OnHoldPage extends PageBase {
	WOOnHoldPageObjects onHoldPageObjects = new WOOnHoldPageObjects();


	public OnHoldPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), onHoldPageObjects);
	}

	public void screenUIVerification() {
		waitForPageToLoad(driver, onHoldPageObjects.REASON_CODE_LABEL);
		Utils.captureInterimScreenshot(driver);
		assert BasePageObjects.MORE_OPTIONS_ICON.isDisplayed();
		assert BasePageObjects.REASON_DESCRIPTION.isDisplayed();
		assert onHoldPageObjects.REASON_CODE_SPINNER.isDisplayed();
		assert onHoldPageObjects.REASON_CODE_LABEL.isDisplayed();
		assert onHoldPageObjects.REASON_NOTES_LABEL.isDisplayed();
		assert onHoldPageObjects.REASON_COMMENTS_FIELD.isDisplayed();
	}
	
	public void onHoldScreenUI() {
		assert onHoldPageObjects.ONHOLD_REASON_TITLE.isDisplayed();
		screenUIVerification();
	}
	
	public void rejectScreenUI() {
		assert onHoldPageObjects.REJECT_REASON_TITLE.isDisplayed();
		screenUIVerification();
	}
	public WOPreviewPage onHoldWO() {
		waitForPageToLoad(driver, onHoldPageObjects.REASON_CODE_LABEL);
		onHoldScreenUI();
		selectReasonCode("Test");
		enterCommentsInNotesField();
		BasePageObjects.SAVE_BUTTON.click();
		return new WOPreviewPage(driver);
	}
	
	public WOPreviewPage rejectWorkOrder() {
		waitForPageToLoad(driver, onHoldPageObjects.REASON_CODE_LABEL);
		rejectScreenUI();
		selectReasonCode("Test30");
		enterCommentsInNotesField();
		BasePageObjects.SAVE_BUTTON.click();
		return new WOPreviewPage(driver);
	}

	public void selectReasonCode(String reason_type) {
		waitForPageToLoad(driver, onHoldPageObjects.REASON_CODE_SPINNER);
		onHoldPageObjects.REASON_CODE_SPINNER.click();
		String reason_code_path = findRelativeXpath(driver, BasePageObjects.REASON_CODE_ANDROID, reason_type);
		if (isElementPresent(By.xpath(reason_code_path))) {
			driver.findElement(By.xpath(reason_code_path)).click();
			ExtentTestManager.getTest().log(LogStatus.PASS, "Given reason code is selected");
		} else {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Given reason code is not available in the list");
		}
	}

	public void enterCommentsInNotesField() {
		waitForPageToLoad(driver, onHoldPageObjects.REASON_NOTES_LABEL);
		enterTextinCommentsFeild(onHoldPageObjects.REASON_COMMENTS_FIELD, "Out of stock, so keeping workorder onHold / rejected");
	}

}
