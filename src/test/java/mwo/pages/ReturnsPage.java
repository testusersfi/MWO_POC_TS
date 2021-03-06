package mwo.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.PageFactory;
import com.appium.base.BasePageObjects;
import com.appium.base.PageBase;
import com.appium.base.Utils;
import com.relevantcodes.extentreports.LogStatus;
import com.appium.reports.ExtentTestManager;
import mwo.pageobjects.WOReturnsPageObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ReturnsPage extends PageBase {
	WOReturnsPageObjects returnsPageObjects = new WOReturnsPageObjects();

	public ReturnsPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), returnsPageObjects);
	}

	// Verify the return materials screen UI
	public void ReturnsScreenUIVerification() {
		waitForPageToLoad(driver, returnsPageObjects.QUANTITY_TO_RETURN_FIELD_LABEL);
		Utils.captureInterimScreenshot(driver);
		assert returnsPageObjects.SCREEN_HEADER.isDisplayed();
		assert returnsPageObjects.PART_NUMBER_LABEL.isDisplayed();
		assert returnsPageObjects.PART_NUMBER_TEXT_FIELD.isDisplayed();
		assert returnsPageObjects.QUANTITY_TO_RETURN_FIELD_LABEL.isDisplayed();
		assert returnsPageObjects.QUANTITY_TO_RETURN_TEXT_FIELD.isDisplayed();
	}

	// select parts to return
	public SelectPartPage selectPartToReturn() {
		assert returnsPageObjects.PART_NUMBER_TEXT_FIELD.isDisplayed();
		returnsPageObjects.PART_NUMBER_TEXT_FIELD.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "Parts from My Stock Page > Part selection screen is displayed ");
		return new SelectPartPage(driver);
	}
	
	// Confirm the part returns and navigate to WO preview screen
	public WOActionsPage confirmItemReturn() throws InterruptedException {
		if(isElementPresent(returnsPageObjects.QUANTITY_TO_RETURN_TEXT_FIELD)) {
			BasePageObjects.SAVE_BUTTON.click();
			threadSleep(2000);
			ReturnsScreenUIVerification();
			threadSleep(1000);
			goBack();
			threadSleep(1000);
			goBack();
			threadSleep(1000);
			goBack();
			return new WOActionsPage(driver);
		} else {
			Utils.log("Return parts are not selected");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Return parts are not associated with the user");
		}
		return null;
	}
}
