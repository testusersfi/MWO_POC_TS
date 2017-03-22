package mwo.pages;

import java.io.FileNotFoundException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;

import javax.swing.plaf.basic.BasicSliderUI.ScrollListener;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.appium.base.BasePageObjects;
import com.appium.base.PageBase;
import com.appium.base.Utils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import com.appium.reports.ExtentTestManager;

import mwo.pageobjects.HomePageObjects;
import mwo.pageobjects.WorkOrdersPageObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import mwo.apiresponses.PLSQLQueries;

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

	public WOPreviewPage launchWOScreen(String wo_number) {
		MobileElement workOrder = (MobileElement) driver.findElements(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()" + ".resourceId(\"com.ifsworld.mworkorderapps9:id/work_order__wo_no\")).scrollIntoView(" + "new UiSelector().text(\"655\"));"));
		//scrollToElement(woPageObjects.WORKORDER_NUMBER);
		workOrder.click();
		return new WOPreviewPage(driver);
	}
	
	private void scrollToElement(MobileElement el) {
	    if (driver instanceof JavascriptExecutor) {
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", el);
	    }
	}

	
	public String findWorkOrder(AppiumDriver<MobileElement> driver, String data) {
		String result = null;
		if (Utils.getDriverPlatform(driver).equals("AndroidDriver")) {
			result = String.format(woPageObjects.WORKORDER_NUMBER, data);
		} else if (Utils.getDriverPlatform(driver).equals("IOSDriver")) {
			result = String.format(woPageObjects.WORKORDER_NUMBER, data);
		}
		Utils.log("Final XPath: " + result);
		return result;
	}

	public WOPreviewPage searchForWorkOrder(String wo_number) throws InterruptedException  {
	//	if(wo_number != null) {
			String number_Xpath = findWorkOrder(driver, wo_number);
			Utils.log("Entered scroll view method");
			scrollListView(number_Xpath);
			driver.findElement(By.xpath(number_Xpath)).click();
			ExtentTestManager.getTest().log(LogStatus.PASS, "Work Order is present and cliked on the relevant workorder");
		//} else {
		//	ExtentTestManager.getTest().log(LogStatus.FAIL, "Work order number is empty");
		//}
		return new WOPreviewPage(driver);
	}

	public void scrollVertical(String wo_number_xpath) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				driver.findElement(By.xpath(wo_number_xpath)));
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,80)");
	}
	
	public HomePage navigateBackToHomeScreen() {
		goBack();
		threadSleep(3000);
		return new HomePage(driver);
	}

}
