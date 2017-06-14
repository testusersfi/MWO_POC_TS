package mwo.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import com.appium.base.BasePageObjects;
import com.appium.base.PageBase;
import com.appium.base.Utils;
import com.relevantcodes.extentreports.LogStatus;
import com.appium.reports.ExtentTestManager;
import mwo.pageobjects.WOActionPageObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WOActionsPage extends PageBase {
	WOActionPageObjects woactionPageObjects = new WOActionPageObjects();

	public WOActionsPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), woactionPageObjects);
	}

	// Verify WO Actions screen UI
	public void woActionsScreenVerification() {
		waitForPageToLoad(driver, woactionPageObjects.SCREEN_HEADER);
		Utils.captureInterimScreenshot(driver);
		soft_assert.assertTrue(woactionPageObjects.WOACTIONS_TITLE.isDisplayed());
		soft_assert.assertTrue(woactionPageObjects.WOACTIONS_SUBTITLE.isDisplayed());
	}

	// Navigate to Materials screen
	public MaterialsPage launchMaterialsScreen() {
		woActionsScreenVerification();
		if (isElementPresent(woactionPageObjects.WOACTIONS_MATERIAL)) {
			woactionPageObjects.WOACTIONS_MATERIAL.click();
			ExtentTestManager.getTest().log(LogStatus.PASS,
					"WO Actions Screen > Matrials Screen is displayed on click of Materials button");
		} else {
			Utils.log("Materials is unavailable in WO Actiions screen");
		}
		return new MaterialsPage(driver);
	}

	// Navigate to WO ReportIn screen
	public WOReportInPage navigatetoReportInScreen() {
		if (isElementPresent(BasePageObjects.NEXT_BUTTON)) {
			BasePageObjects.NEXT_BUTTON.click();
			ExtentTestManager.getTest().log(LogStatus.PASS,
					"WO Actions > Report In Screen is displayed on click of Next button");
		} else {
			Utils.log("Failed to Navigate to Report In screen");
		}

		return new WOReportInPage(driver);
	}

	// Navigate to WO TimeReport screen
	public WOTimeReportPage navigatetoTimeReportScreen() {
		if (isElementPresent(woactionPageObjects.WOACTIONS_TIME_REPORT)) {
			woactionPageObjects.WOACTIONS_TIME_REPORT.click();
			ExtentTestManager.getTest().log(LogStatus.PASS,
					"WO Actions > Time Report Screen is displayed on click of Time Report button");
		} else {
			Utils.log("Failed to Navigate to Report In screen");
		}

		return new WOTimeReportPage(driver);
	}

	// Navigate to WO Expenses screen
	public WOExpensesPage navigatetoExpensesScreen() {
		if (isElementPresent(woactionPageObjects.WOACTIONS_TIME_EXPENCE)) {
			woactionPageObjects.WOACTIONS_TIME_EXPENCE.click();
			ExtentTestManager.getTest().log(LogStatus.PASS,
					"WO Actions > Expenses Screen is displayed on click of Expenses button");
		} else {
			Utils.log("Failed to Navigate to Report In screen");
		}

		return new WOExpensesPage(driver);
	}


	// Search for the time report in WO action List
	public WOTimeReportPage searchForTimeReport(String actionName) throws InterruptedException {
		String number_Xpath = findRelativeXpath(driver, woactionPageObjects.ActionList, actionName);
		Utils.log("Entered scroll view method");
		scrollListView(number_Xpath);
		driver.findElement(By.xpath(number_Xpath)).click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "Time Report is present and cliked on the relevant action");
		return new WOTimeReportPage(driver);

	}

	// Search for the expenses in WO action List
	public WOExpensesPage searchForExpence(String actionName) throws InterruptedException {
		String number_Xpath = findRelativeXpath(driver, woactionPageObjects.ActionList, actionName);
		Utils.log("Entered scroll view method");
		scrollListView(number_Xpath);
		driver.findElement(By.xpath(number_Xpath)).click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "Expenses is present and cliked on the relevant action");
		return new WOExpensesPage(driver);

	}
	
	// Search for the expenses in WO action List
	public WOPicturesPage searchForPictures(String actionName) throws InterruptedException {
		String number_Xpath = findRelativeXpath(driver, woactionPageObjects.ActionList, actionName);
		Utils.log("Entered scroll view method");
		scrollListView(number_Xpath);
		driver.findElement(By.xpath(number_Xpath)).click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "Expenses is present and cliked on the relevant action");
		return new WOPicturesPage(driver);

	}

	public WOPreviewPage navigateBackToPreviewPage() throws InterruptedException {
		threadSleep(1000);
		goBack();
		return new WOPreviewPage(driver);
	}
	
	public static SyncMonitorPage initiateManualSync() {
		  assert BasePageObjects.MORE_OPTIONS_ICON.isDisplayed();
		  BasePageObjects.MORE_OPTIONS_ICON.click();
		  if(isElementPresent(BasePageObjects.MENU_SYNC_BUTTON)) {
			  BasePageObjects.MENU_SYNC_BUTTON.click();
			  return new SyncMonitorPage(driver);
		  } else
		  {
			  ExtentTestManager.getTest().log(LogStatus.FAIL, "Launching sync monitor from Menu list is failed");
		  }
		  return null;
	 }
}
