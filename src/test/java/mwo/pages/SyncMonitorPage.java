package mwo.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.appium.base.PageBase;
import com.appium.base.Utils;
import com.relevantcodes.extentreports.LogStatus;
import com.appium.reports.ExtentTestManager;
import mwo.pageobjects.SyncMonitorPageObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SyncMonitorPage extends PageBase {
	SyncMonitorPageObjects syncPageObjects = new SyncMonitorPageObjects();

	public SyncMonitorPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), syncPageObjects);
	}

	// Verify Sync Monitor screen UI
	public void syncMonitorScreenVerification() {
		if (isElementPresent(syncPageObjects.ACTION_BAR_TITLE)) {
			Utils.log("SyncMonitor screen is displayed");
		} else {
			Utils.log("Sync Monitor screen is not shown");
		}
		Utils.captureInterimScreenshot(driver);
	}

	// First time sync verification on post activation
	public HomePage syncVerification() {
		syncMonitorScreenVerification();
		if (isElementPresent(syncPageObjects.SYNC_FAILED_MESSAGE)) {
			Utils.captureInterimScreenshot(driver);
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Sync is failed");
		} else {
			ExtentTestManager.getTest().log(LogStatus.PASS, "Sync is successful and MWO Homescreen is displayed");
		}
		return new HomePage(driver);
	}

	// Wait time to make sure that device is connected while switching on the
	// internet
	public void syncWaitTime() {
		threadSleep(40000);
	}

	// Verification of Sync failure
	public void syncFailureVerification() {
		if (isElementPresent(syncPageObjects.SYNC_FAILED_MESSAGE)) {
			Utils.captureInterimScreenshot(driver);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Sync is failed");
		} else {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Sync is completed before switching off internet");
		}
	}

	// Verification of successful Sync
	public void syncCompletedVerification() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(
				ExpectedConditions.and(ExpectedConditions.invisibilityOfAllElements(syncPageObjects.SYNC_FAILURE_ERROR),
						ExpectedConditions.visibilityOf(syncPageObjects.SYNC_COMPLETED_MESSAGE)));
		if (isElementPresent(syncPageObjects.SYNC_COMPLETED_MESSAGE)) {
			Utils.captureInterimScreenshot(driver);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Sync is Ended");
		} else {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Sync failed due to network issues");
		}
	}

	// Navigate back to home screen
	public HomePage navigateBacktoHomePage() {
		goBack();
		return new HomePage(driver);
	}
}
