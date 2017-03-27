package mwo.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.PageFactory;
import com.appium.base.BasePageObjects;
import com.appium.base.PageBase;
import com.appium.base.Utils;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.common.ExtentTestManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import mwo.pageobjects.NewWorkOrderPageObjects;

public class NewWOPage extends PageBase {
	NewWorkOrderPageObjects newWOPageObjects = new NewWorkOrderPageObjects();

	public NewWOPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), newWOPageObjects);
	}

	// Verify the new WO screen UI
	public void newWOScreenUIVerification() {
		waitForPageToLoad(driver, newWOPageObjects.SCREEN_HEADER);
		Utils.captureInterimScreenshot(driver);
		assert newWOPageObjects.WO_NUMBER.isDisplayed();
		assert newWOPageObjects.WO_SITE_LBL.isDisplayed();
		assert newWOPageObjects.WO_DIRECTIVE_LBL.isDisplayed();
		assert newWOPageObjects.MAINT_ORG_LBL.isDisplayed();
	}

	// Enter directive description
	public CustomerAndObjectDetailsPage enterDirectiveDescription(String description) {
		hideKeyboardBasedOnPlatform();
		newWOScreenUIVerification();
		newWOPageObjects.WO_DIRECTIVE_TXT.click();
		enterTextUsingadb(description);
		// newWOPageObjects.WO_DIRECTIVE_TXT.sendKeys(description);
		hideKeyboardBasedOnPlatform();
		assert BasePageObjects.NEXT_BUTTON.isDisplayed();
		BasePageObjects.NEXT_BUTTON.click();
		return new CustomerAndObjectDetailsPage(driver);
	}

	// Navigate back to home screen
	public HomePage navigateBackToHomeScreen() {
		goBack();
		threadSleep(3000);
		return new HomePage(driver);
	}

	// extract the system originating id from the New work order screen
	public String extractWONumber() {
		String[] wo_number = newWOPageObjects.WO_NUMBER.getText().split(" ");
		Utils.log("New Work Order screen title " + wo_number[2]);
		return wo_number[2];
	}

	// Navigate to Maintenance Org screen
	public SelectMaintainanceOrgPage launchMaintainanceOrgScreen() {
		if (isElementPresent(newWOPageObjects.MAINT_ORG_DESC)) {
			newWOPageObjects.MAINT_ORG_DESC.click();
			return new SelectMaintainanceOrgPage(driver);
		} else {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to select maintainance org");
		}
		return null;
	}

}
