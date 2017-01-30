package mwo.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.appium.base.BasePageObjects;
import com.appium.base.PageBase;
import com.appium.base.Utils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import com.appium.reports.ExtentTestManager;

import mwo.pageobjects.CustomerSignaturePageObjects;
import mwo.pageobjects.HomePageObjects;
import mwo.pageobjects.WOReportInPageObjects;
import mwo.pageobjects.WOReportWebViewPageObjects;
import mwo.pageobjects.WorkOrdersPageObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ReportWebViewPage extends PageBase {
	WOReportWebViewPageObjects reportWebViewPageObjects = new WOReportWebViewPageObjects();

	public ReportWebViewPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), reportWebViewPageObjects);
	}

	public void reportWebViewScreenVerification() {
		waitForPageToLoad(driver, reportWebViewPageObjects.REPORT_WEBVIEW);
		Utils.captureInterimScreenshot(driver);
		assert reportWebViewPageObjects.REPORT_WEBVIEW.isDisplayed();
		assert reportWebViewPageObjects.SEND_BUTTON.isDisplayed();
		assert reportWebViewPageObjects.NEXT_BUTTON.isDisplayed();
	}

	public CustomerSignaturePage navigateToCustomerSignatureScreen() {
		reportWebViewScreenVerification();
		reportWebViewPageObjects.NEXT_BUTTON.click();
		return new CustomerSignaturePage(driver);
	}
	
	public void reportScreenUIVerificationPostSignature() {
		waitForPageToLoad(driver, reportWebViewPageObjects.REPORT_WEBVIEW);
		
		Utils.captureInterimScreenshot(driver);
		assert reportWebViewPageObjects.REPORT_WEBVIEW.isDisplayed();
		assert reportWebViewPageObjects.SEND_BUTTON.isDisplayed();
		assert reportWebViewPageObjects.COMPLETE_BUTTON.isDisplayed();
	}
	
	public WorkOrdersPage completeWorkOrder() {
		waitForPageToLoad(driver, reportWebViewPageObjects.COMPLETE_BUTTON);
		reportWebViewPageObjects.COMPLETE_BUTTON.click();
		assert reportWebViewPageObjects.COMPLETE_WO_ALERT_MESSSAGE.isDisplayed();
		assert reportWebViewPageObjects.COMPLETE_WO_ALERT_BUTTON_KEEP.isDisplayed();
		assert reportWebViewPageObjects.COMPLETE_WO_ALERT_BUTTON_RETURN.isDisplayed();
		assert reportWebViewPageObjects.COMPLETE_WO_ALERT_BUTTON_RETURN_TRAVEL.isDisplayed();
		reportWebViewPageObjects.COMPLETE_WO_ALERT_BUTTON_RETURN.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "Report Web View Page > Work Orders screen is displayed on return of selected work order");
		return new WorkOrdersPage(driver);
		
	}
}
