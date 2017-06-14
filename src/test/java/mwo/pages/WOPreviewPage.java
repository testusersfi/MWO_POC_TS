package mwo.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.PageFactory;
import com.appium.base.PageBase;
import com.appium.base.Utils;
import com.relevantcodes.extentreports.LogStatus;
import com.appium.reports.ExtentTestManager;
import mwo.pageobjects.WOPreviewPageObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WOPreviewPage extends PageBase {
	OnHoldPage wo_onholdPage;
	WOPreviewPageObjects previewPageObjects = new WOPreviewPageObjects();

	public WOPreviewPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), previewPageObjects);
	}

	// Verify the WO preview screen UI
	public void previewScreenVerification() {
		waitForPageToLoad(driver, previewPageObjects.SCREEN_HEADER);
		Utils.captureInterimScreenshot(driver);
		soft_assert.assertTrue(previewPageObjects.DETAILS_DIRECTIVE_LABEL.isDisplayed());
		soft_assert.assertTrue(previewPageObjects.DETAILS_SITE_LABEL.isDisplayed());
		soft_assert.assertTrue(previewPageObjects.WO_DETAILS_BUTTON.isDisplayed());
	}

	// Navigate to WO Actions screen
	public WOActionsPage launchWOActionsScreen() {
		assert previewPageObjects.NEXT_BUTTON.isDisplayed();
		previewPageObjects.NEXT_BUTTON.click();
		return new WOActionsPage(driver);
	}
	
	// Navigate to WO Menu screen
		public WOMenuPage launchWOAMenuScreen() {
			assert previewPageObjects.WO_OBJECT_MENU.isDisplayed();
			previewPageObjects.WO_OBJECT_MENU.click();
			return new WOMenuPage(driver);
		}

	// Accept the work order
	public void acceptWorkOrder() {
		changeWOStatus(previewPageObjects.ACCEPT_BUTTON);
	}

	// Change the work order status to OnRoute
	public void changeStatustoOnRoute() {
		changeWOStatus(previewPageObjects.ONROUTE_BUTTON);
	}

	// Change the work order status to OnSite
	public void changeStatustoOnSite() {
		changeWOStatus(previewPageObjects.ONSITE_BUTTON);
	}

	// Change the work order status to OnHold
	public OnHoldPage changeStatusToOnHold() {
		changeStatusToOnHoldorReject(previewPageObjects.ONHOLD_BUTTON);
		return new OnHoldPage(driver);
	}

	// Reject the work order
	public OnHoldPage changeWOStatusToReject() {
		changeStatusToOnHoldorReject(previewPageObjects.REJECT_BUTTON);
		return new OnHoldPage(driver);
	}

	// Change the work order status to OnRoute or Reject
	public OnHoldPage changeStatusToOnHoldorReject(MobileElement status_button_element) {
		waitForPageToLoad(driver, status_button_element);
		try {
			if (isElementPresent(status_button_element)) {
				status_button_element.click();
				ExtentTestManager.getTest().log(LogStatus.PASS, "Preview Page >" + status_button_element.toString()
						+ "is displayed on click of On Hold/Reject button");
				return new OnHoldPage(driver);
			} else {
				Utils.log(status_button_element.toString() + "button is not displayed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// Suspend the work order
	public SuspendPage changeStatusToSuspend() {
		waitForPageToLoad(driver, previewPageObjects.SUSPEND_BUTTON);
		try {
			if (isElementPresent(previewPageObjects.SUSPEND_BUTTON)) {
				previewPageObjects.SUSPEND_BUTTON.click();
				ExtentTestManager.getTest().log(LogStatus.PASS,
						"Preview Page > Suspend or Abort screen is displayed on click of Suspend button ");
				return new SuspendPage(driver);
			} else {
				Utils.log("Suspend button is not displayed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// Navigate to additional details screen of the work order
	public AdditionalDetailsPage launchAdditionalDetailsScreen() {
		previewPageObjects.WO_DETAILS_BUTTON.click();
		return new AdditionalDetailsPage(driver);
	}

	// Verify that button status is changed to reject on suspending the work
	// order
	public void rejectButtonVerificationPostSuspendWO() {
		assert previewPageObjects.REJECT_BUTTON.isDisplayed();
		previewScreenVerification();
	}

	// Verify that button status is changed to Off Hold on changing the work
	// order status to OnHold
	public void buttonOffHoldVerification() {
		assert previewPageObjects.OFFHOLD_BUTTON.isDisplayed();
	}

	// Verify the contact details of the work order
	public void contactDetailsVerification() throws InterruptedException {
		// String contact_button =
		// previewPageObjects.WO_CONTACT_DETAILS_BUTTON.toString();
		scrolltoText(previewPageObjects.WO_CONTACT_DETAILS_BUTTON);
	}

	// Verify the Object details associated with the work order
	public void objectDetailsVerfication() throws InterruptedException {
		// String contact_button =
		// previewPageObjects.WO_OBJECT_DETAILS_BUTTON.toString();
		scrolltoText(previewPageObjects.WO_OBJECT_DETAILS_BUTTON);
	}

	// Reusable method to change the WO status
	public void changeWOStatus(MobileElement status_button) {
		waitForPageToLoad(driver, status_button);
		try {
			if (isElementPresent(status_button)) {
				status_button.click();
				ExtentTestManager.getTest().log(LogStatus.PASS,
						"Preview Page > Suspend or Abort screen is displayed on click of Suspend button ");

			} else {
				Utils.log(status_button.toString() + "is not displayed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ObjectDetailsPage launchObjectDetailsScreen() {
		previewPageObjects.WO_OBJECT_DETAILS_BUTTON.click();
		return new ObjectDetailsPage(driver);
	}

	public ContactDetailsPage launchContactDetailsScreen() {
		previewPageObjects.WO_CONTACT_DETAILS_BUTTON.click();
		return new ContactDetailsPage(driver);
	}
	
	public WorkOrdersPage navigateBackToWorkOrdersPage() throws InterruptedException {
		goBack();
		return new WorkOrdersPage(driver);
	}

}
