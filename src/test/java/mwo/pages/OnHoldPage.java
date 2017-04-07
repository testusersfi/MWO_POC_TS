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
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class OnHoldPage extends PageBase {
	WOOnHoldPageObjects onHoldPageObjects = new WOOnHoldPageObjects();

	public OnHoldPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), onHoldPageObjects);
	}

	public void onHoldScreenUIVerification() {
		waitForPageToLoad(driver, onHoldPageObjects.REASON_CODE_LABEL);
		Utils.captureInterimScreenshot(driver);
		assert BasePageObjects.MORE_OPTIONS_ICON.isDisplayed();
		assert BasePageObjects.REASON_DESCRIPTION.isDisplayed();
		assert onHoldPageObjects.REASON_CODE_SPINNER.isDisplayed();
		assert onHoldPageObjects.REASON_CODE_LABEL.isDisplayed();
		assert onHoldPageObjects.REASON_NOTES_LABEL.isDisplayed();
		assert onHoldPageObjects.REASON_COMMENTS_FIELD.isDisplayed();
	}

	// Verify the OnHold screen UI
	public void onHoldScreenUI() {
		assert onHoldPageObjects.ONHOLD_REASON_TITLE.isDisplayed();
		onHoldScreenUIVerification();
	}

	// Verify the Reject screen UI
	public void rejectScreenUI() {
		assert onHoldPageObjects.REJECT_REASON_TITLE.isDisplayed();
		onHoldScreenUIVerification();
	}

	// Update the WO status as OnHold
	public WOPreviewPage onHoldWO(String reason_code) {
		waitForPageToLoad(driver, onHoldPageObjects.REASON_CODE_LABEL);
		onHoldScreenUI();
		selectReasonCode(reason_code);
		enterCommentsInNotesField();
		BasePageObjects.SAVE_BUTTON.click();
		return new WOPreviewPage(driver);
	}

	// Reject the work order
	public WOPreviewPage rejectWorkOrder(String reason_code) {
		waitForPageToLoad(driver, onHoldPageObjects.REASON_CODE_LABEL);
		rejectScreenUI();
		selectReasonCode(reason_code);
		enterCommentsInNotesField();
		BasePageObjects.SAVE_BUTTON.click();
		return new WOPreviewPage(driver);
	}

	// Select the reason code to reject / OnHold the work order
	public void selectReasonCode(String reason_type) {
		waitForPageToLoad(driver, onHoldPageObjects.REASON_CODE_SPINNER);
		onHoldPageObjects.REASON_CODE_SPINNER.click();
		// uncomment the below lines (72, 73, 75) for selecting the proper reason code
		//String reason_code_path = findRelativeXpath(driver, BasePageObjects.REASON_CODE_ANDROID, reason_type);		
		//if (isElementPresent(By.xpath(reason_code_path))) {
		if(isElementPresent(BasePageObjects.REASON_CODE)) {
			//driver.findElement(By.xpath(reason_code_path)).click();
			BasePageObjects.REASON_CODE.click();
			ExtentTestManager.getTest().log(LogStatus.PASS, "Given reason code is selected");
		} else {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Given reason code is not available in the list");
		}
	}

	// Enter comments in Notes field
	public void enterCommentsInNotesField() {
		waitForPageToLoad(driver, onHoldPageObjects.REASON_NOTES_LABEL);
		enterTextinCommentsFeild(onHoldPageObjects.REASON_COMMENTS_FIELD,
				"Out of stock, so keeping workorder onHold / rejected");
	}

}
