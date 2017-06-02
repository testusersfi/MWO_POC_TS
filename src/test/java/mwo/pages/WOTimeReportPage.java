package mwo.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.PageFactory;

import com.appium.base.BasePageObjects;
import com.appium.base.PageBase;
import com.appium.base.Utils;
import com.relevantcodes.extentreports.LogStatus;
import com.appium.reports.ExtentTestManager;
import mwo.pageobjects.WOTimeReportPageObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WOTimeReportPage extends PageBase {

	WOTimeReportPageObjects timeReportPageObjects = new WOTimeReportPageObjects();

	public WOTimeReportPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), timeReportPageObjects);
	}

	// Verify the TimeReport screen UI
	public void TimereportScreenVerification() {
		waitForPageToLoad(driver, timeReportPageObjects.TIME_REPORT_SCREEN_TITLE);
		Utils.captureInterimScreenshot(driver);
		assert timeReportPageObjects.END_TIME_FIELD.isDisplayed();
		assert timeReportPageObjects.END_TIME_LABEL.isDisplayed();
		assert timeReportPageObjects.QTY_FIELD.isDisplayed();
		assert timeReportPageObjects.QTY_LABEL.isDisplayed();
		assert timeReportPageObjects.START_TIME_FIELD.isDisplayed();
		assert timeReportPageObjects.START_TIME_LABEL.isDisplayed();

	}

	public WOOperationPage EnterTimeReportDetails(String quantity) {

		if (ValidateOperationCount())
			return new WOOperationPage(driver);

		else {
			EnterQuantity(quantity);
			return null;
		}

	}

	public void EnterQuantity(String quantity) {
		hideKeyboardBasedOnPlatform();
		TimereportScreenVerification();
		timeReportPageObjects.QTY_FIELD.click();
		enterTextUsingadb(String.valueOf(quantity));
		hideKeyboardBasedOnPlatform();

	}

	public void SaveTimeReport() {
		int prevalue = Integer.parseInt(BasePageObjects.PREVIOUS_BUTTON.getText().replaceAll("[^0-9]", "").trim());
		hideKeyboardBasedOnPlatform();
		assert BasePageObjects.NEXT_BUTTON.isDisplayed();
		assert BasePageObjects.ADD_BUTTON.isDisplayed();
		BasePageObjects.ADD_BUTTON.click();

		int newvalue = Integer.parseInt(BasePageObjects.PREVIOUS_BUTTON.getText().replaceAll("[^0-9]", "").trim());

		if (newvalue > prevalue) {

			ExtentTestManager.getTest().log(LogStatus.PASS,
					"Time Report Record saved successfully in TimeReport screen");

		} else {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Time Report saving failed in TimeReport screen");

		}
	}

	public boolean ValidateOperationCount() {

		if (isElementPresent(timeReportPageObjects.OPERATION_FIELD)) {
			timeReportPageObjects.OPERATION_FIELD.click();
			return true;

		} else {
			Utils.log("Opeartion is unavailable in TimeReport screen");
			return false;
		}

	}

	public WOActionsPage navigateBackToActionPage() {
		goBack();
		return new WOActionsPage(driver);
	}
	
	public void enterEmployeeName(String name) {
		hideKeyboardBasedOnPlatform();
		if(isElementPresent(BasePageObjects.LIST_ITEM_SEPERATOR)) {
			assert timeReportPageObjects.EMPLOYEE_NAME_LABEL.isDisplayed();
			hideKeyboardBasedOnPlatform();
			BasePageObjects.LIST_ITEM_SEPERATOR.click();			
		} else {
			ExtentTestManager.getTest().log(LogStatus.WARNING, "Name field is prepopulated with the value");
		}
	}
}
