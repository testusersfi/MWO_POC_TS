package mwo.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import com.appium.base.PageBase;
import com.appium.base.Utils;
import com.relevantcodes.extentreports.ExtentReports;
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

	public void syncMonitorScreenVerification() {
		if (isElementPresent(syncPageObjects.ACTION_BAR_TITLE)) {
			Utils.log("SyncMonitor screen is displayed");
		} else {
			Utils.log("Sync Monitor screen is not shown");
		}
		Utils.captureInterimScreenshot(driver);
	}

	public HomePage syncVerification() {
		syncMonitorScreenVerification();
		if (isElementPresent(syncPageObjects.SYNC_FAILURE_ERROR)) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Sync is failed");
		} else {
			ExtentTestManager.getTest().log(LogStatus.PASS, "Sync is successful and MWO Homescreen is displayed");
		}
		return new HomePage(driver);
	}

}
