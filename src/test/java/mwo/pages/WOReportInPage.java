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
import com.report.factory.ExtentTestManager;

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

	public void homeScreenVerification() {
		waitForPageToLoad(driver, reportinPageObjects.SCREEN_HEADER);
		Utils.captureInterimScreenshot(driver);
		//assert BasePageObjects.MORE_OPTIONS_ICON.isDisplayed();
		//assert woPageObjects.BAR_CODE_SCAN.isDisplayed();
		// assert homePageObjects.WORK_ORDERS_BUTTON.isDisplayed();
	}

}
