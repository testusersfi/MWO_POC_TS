package mwo.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.PageFactory;
import com.appium.base.BasePageObjects;
import com.appium.base.PageBase;
import com.appium.base.Utils;
import com.relevantcodes.extentreports.LogStatus;
import com.appium.reports.ExtentTestManager;
import mwo.pageobjects.SelectObjectScreenPageObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SelectAnObjectPage extends PageBase {
	BasePageObjects basePageObjects;
	SelectObjectScreenPageObjects selectObjectScreenPageObjects = new SelectObjectScreenPageObjects();

	public SelectAnObjectPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), selectObjectScreenPageObjects);
	}

	// Select object ID to transfer the WO to Mobile
	public CustomerAndObjectDetailsPage selectObjectID() {
		hideKeyboardBasedOnPlatform();
		waitForPageToLoad(driver, BasePageObjects.SEARCH_TEXT_FIELD);
		Utils.captureInterimScreenshot(driver);
		assert selectObjectScreenPageObjects.SELECT_OBJECT_SCREEN_HEADER.isDisplayed();
		hideKeyboardBasedOnPlatform();
		Utils.log("Select Object screen is displayed");
		if (isElementPresent(selectObjectScreenPageObjects.OBJECT_DESCRIPTION)) {
			selectObjectScreenPageObjects.OBJECT_DESCRIPTION.click();
		} else {
			Utils.log("No Objects are associated with this Work Order");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "No objects are displayed to create work order");
		}

		return new CustomerAndObjectDetailsPage(driver);
	}

}
