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

import mwo.pageobjects.HomePageObjects;
import mwo.pageobjects.WOReportInPageObjects;
import mwo.pageobjects.WorkOrdersPageObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WOReportInPage extends PageBase {
	WOReportInPageObjects reportinPageObjects = new WOReportInPageObjects();

	public WOReportInPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), reportinPageObjects);
	}

	public void ReportScreenUIVerification() {
		waitForPageToLoad(driver, reportinPageObjects.REPORTIN_TITLE);
		Utils.captureInterimScreenshot(driver);
		assert reportinPageObjects.REPORTIN_TITLE.isDisplayed();
		assert reportinPageObjects.REPORTIN_DESCRIPTION.isDisplayed();
		//assert reportinPageObjects.SCREEN_HEADER.isDisplayed();
	}
	
	public ReportWebViewPage navigateToWOReportScreen() {
		ReportScreenUIVerification();
		assert BasePageObjects.NEXT_BUTTON.isDisplayed();
		assert BasePageObjects.SAVE_BUTTON.isDisplayed();
		BasePageObjects.NEXT_BUTTON.click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "Report In Screen > Report web View page is displayed on click of Next button");
		return new ReportWebViewPage(driver);
	}

}
