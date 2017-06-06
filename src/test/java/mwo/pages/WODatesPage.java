package mwo.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.PageFactory;
import com.appium.base.BasePageObjects;
import com.appium.base.PageBase;
import com.appium.base.Utils;
import com.relevantcodes.extentreports.LogStatus;
import com.appium.reports.ExtentTestManager;
import mwo.pageobjects.WODatesPageObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WODatesPage extends PageBase {
	BasePageObjects basePageObjects;
	WODatesPageObjects woDatesPageObjects = new WODatesPageObjects();

	public WODatesPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), woDatesPageObjects);
	}

	// Verify WO dates screen UI
	public void woDatesScreenUIVerification() {
		waitForPageToLoad(driver, woDatesPageObjects.WODATES_TITLE);
		Utils.captureInterimScreenshot(driver);
		//assert woDatesPageObjects.ATTCHMENT_ICON.isDisplayed();
		assert woDatesPageObjects.PLANNING_SECTION_TITLE.isDisplayed();
		assert woDatesPageObjects.REQUESTED_SECTION_TITLE.isDisplayed();
		assert woDatesPageObjects.SCREEN_HEADER.isDisplayed();
	}

	// Click on Save button to keep or return the WO
	public HomePage prepareWorkOrder() {
		woDatesScreenUIVerification();
		assert BasePageObjects.SAVE_BUTTON.isDisplayed();
		BasePageObjects.SAVE_BUTTON.click();
		if (isElementPresent(woDatesPageObjects.COMPLETE_WO_ALERT_MESSSAGE)) {
			assert woDatesPageObjects.COMPLETE_WO_ALERT_MESSSAGE.isDisplayed();
			assert BasePageObjects.COMPLETE_WO_ALERT_BUTTON_RETURN.isDisplayed();
			assert BasePageObjects.COMPLETE_WO_ALERT_BUTTON_KEEP.isDisplayed();
			BasePageObjects.COMPLETE_WO_ALERT_BUTTON_KEEP.click();
			ExtentTestManager.getTest().log(LogStatus.PASS, "work Order is prepared from Mobile");
			return new HomePage(driver);
		} else {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to display WO alert message");
		}
		return null;
	}

}
