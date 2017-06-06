package mwo.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.PageFactory;
import com.appium.base.PageBase;
import com.appium.base.Utils;
import com.relevantcodes.extentreports.LogStatus;
import com.appium.reports.ExtentTestManager;
import mwo.pageobjects.SelectPartScreenPageObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SelectPartPage extends PageBase {
	SelectPartScreenPageObjects selectPartScreenPageObjects = new SelectPartScreenPageObjects();

	public SelectPartPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), selectPartScreenPageObjects);
	}

	// Select part serial number for the serialized part
	public void selectSerialNumberScreenUI(String part_serial_number) {
		hideKeyboardBasedOnPlatform();
		if (isElementPresent(selectPartScreenPageObjects.SERIAL_NUMBER_SCREEN_HEADER)
				&& isElementPresent(selectPartScreenPageObjects.PART_DESCRIPTION)) {
			assert selectPartScreenPageObjects.SERIAL_NUMBER_SCREEN_HEADER.isDisplayed();
			singleItemUIVerification();
			//enterSearchText(part_serial_number);
			selectPartScreenPageObjects.PART_DESCRIPTION.click();
			ExtentTestManager.getTest().log(LogStatus.PASS, "Part Selection Screen > Serialized part is selected and issued");
		} else {
			Utils.log("No serialized parts are associated with this Work Order");
			ExtentTestManager.getTest().log(LogStatus.WARNING, "No serialized parts are associated with this Work Order");
		}
	}

	// Select part lot batch number for the serialized part
	public void selectLotBatchScreenUI(String lot_batch_number) {
		hideKeyboardBasedOnPlatform();
		if (isElementPresent(selectPartScreenPageObjects.SELECT_LOT_BATCH_NUMBER_SCREEN_HEADER)
				&& isElementPresent(selectPartScreenPageObjects.PART_DESCRIPTION)) {
			assert selectPartScreenPageObjects.SELECT_LOT_BATCH_NUMBER_SCREEN_HEADER.isDisplayed();
			singleItemUIVerification();
			//enterSearchText(lot_batch_number);
			selectPartScreenPageObjects.PART_DESCRIPTION.click();
			ExtentTestManager.getTest().log(LogStatus.PASS, "Part Selection Screen > Part batch number is selected and serial number selection screen is displayed");
		} else {
			Utils.log("No Batch Lots are avaialble with the associated parts of this Work Order");
			ExtentTestManager.getTest().log(LogStatus.WARNING, "No Batch Lots are avaialble with the associated parts of this Work Order");
		}
	}

	// Issue parts for the selected work order
	public MaterialsPage issueParts(String part_desc, String batch_number, String serial_number) {
		waitForPageToLoad(driver, selectPartScreenPageObjects.SEARCH_TEXT_FIELD);
		Utils.captureInterimScreenshot(driver);
		assert selectPartScreenPageObjects.SELECT_PART_SCREEN_HEADER.isDisplayed();
		Utils.log("Select Part screen is displayed");
		threadSleep(2000);
		if (isElementPresent(selectPartScreenPageObjects.PART_DESCRIPTION)) {
			Utils.log("Entered if loop to issue parts");
			Utils.captureInterimScreenshot(driver);
			//enterSearchText(part_desc);
			selectPartScreenPageObjects.PART_DESCRIPTION.click();
			selectLotBatchScreenUI(batch_number);
			selectSerialNumberScreenUI(serial_number);
			Utils.captureInterimScreenshot(driver);
			return new MaterialsPage(driver);
		} else {
			Utils.log("No Parts are associated with this Work Order");
			goBack();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "No Parts are associated with this Work Order");
		}

		return null;
	}
	
	// return the parts for the work order
	public ReturnsPage returnParts(String part_desc, String batch_number, String serial_number) {
		waitForPageToLoad(driver, selectPartScreenPageObjects.SEARCH_TEXT_FIELD);
		Utils.captureInterimScreenshot(driver);
		assert selectPartScreenPageObjects.SELECT_PART_SCREEN_HEADER.isDisplayed();
		hideKeyboardBasedOnPlatform();
		if (isElementPresent(selectPartScreenPageObjects.PART_DESCRIPTION)) {
			//enterSearchText(part_desc);
			selectPartScreenPageObjects.PART_DESCRIPTION.click();
			selectLotBatchScreenUI(batch_number);
			selectSerialNumberScreenUI(serial_number);
			return new ReturnsPage(driver);
		} else {
			Utils.log("No Parts are associated with this Work Order");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "No Parts are associated with this Work Order");
		}

		return null;
	}
	
	// Verify the Item details UI
	public void singleItemUIVerification() {
		assert selectPartScreenPageObjects.PART_DESCRIPTION.isDisplayed();
		assert selectPartScreenPageObjects.PART_ITEM1.isDisplayed();
		assert selectPartScreenPageObjects.PART_ITEM2.isDisplayed();
	}

	// Enter search text to select the relevant Part
	public void enterSearchText(String search_text) {
		Utils.log("Search Text field is clicked");
		selectPartScreenPageObjects.SEARCH_TEXT_FIELD.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Utils.log("Enter the search text");
		enterTextUsingadb(search_text);
		hideKeyboardBasedOnPlatform();
	}
}
