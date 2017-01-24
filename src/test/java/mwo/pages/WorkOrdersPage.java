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
import mwo.pageobjects.WorkOrdersPageObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WorkOrdersPage extends PageBase {
	WorkOrdersPageObjects woPageObjects = new WorkOrdersPageObjects();

	public WorkOrdersPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), woPageObjects);
	}

	public void homeScreenVerification() {
		waitForPageToLoad(driver, woPageObjects.SCREEN_HEADER);
		Utils.captureInterimScreenshot(driver);
		assert BasePageObjects.MORE_OPTIONS_ICON.isDisplayed();
		assert woPageObjects.BAR_CODE_SCAN.isDisplayed();
	}

	public WOPreviewPage launchWOScreen() {
	  MobileElement workOrder = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()" + ".resourceId(\"com.ifsworld.mworkorderapps9:id/work_order__wo_no\")).scrollIntoView(" + "new UiSelector().text(\"669\"));"));
	  workOrder.click();
	  return new WOPreviewPage(driver);
  }
}
