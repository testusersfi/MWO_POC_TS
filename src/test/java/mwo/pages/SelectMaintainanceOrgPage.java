package mwo.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.PageFactory;
import com.appium.base.BasePageObjects;
import com.appium.base.PageBase;
import com.appium.base.Utils;
import com.relevantcodes.extentreports.LogStatus;
import com.appium.reports.ExtentTestManager;
import mwo.pageobjects.SelectMaintainanceOrgPageObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SelectMaintainanceOrgPage extends PageBase {
	BasePageObjects basePageObjects;
	SelectMaintainanceOrgPageObjects maintOrgScreenPageObjects = new SelectMaintainanceOrgPageObjects();

	public SelectMaintainanceOrgPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), maintOrgScreenPageObjects);
	}

	// Select Maintenance org for preparing new work order from mobile
	public NewWOPage selectMaintOrg() {
		hideKeyboardBasedOnPlatform();
		waitForPageToLoad(driver, BasePageObjects.SEARCH_TEXT_FIELD);
		Utils.captureInterimScreenshot(driver);

		assert maintOrgScreenPageObjects.SELECT_MAINT_ORG_SCREEN_HEADER.isDisplayed();
		hideKeyboardBasedOnPlatform();
		Utils.log("Select Object screen is displayed");
		if (isElementPresent(maintOrgScreenPageObjects.ORG_ITEM_DESCRIPTION)) {
			maintOrgScreenPageObjects.ORG_ITEM_DESCRIPTION.click();
		} else {
			Utils.log("No maintanance org Objects are associated with this user");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "No maintanance org Objects are associated with this user");
		}

		return new NewWOPage(driver);
	}

}
