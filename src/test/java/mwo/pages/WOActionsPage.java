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
import mwo.pageobjects.WOActionPageObjects;
import mwo.pageobjects.WorkOrdersPageObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WOActionsPage extends PageBase {
	WOActionPageObjects woactionPageObjects = new WOActionPageObjects();

	public WOActionsPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), woactionPageObjects);
	}

	public void woActionsScreenVerification() {
		waitForPageToLoad(driver, woactionPageObjects.SCREEN_HEADER);
		Utils.captureInterimScreenshot(driver);
		assert woactionPageObjects.WOACTIONS_TITLE.isDisplayed();
		assert woactionPageObjects.WOACTIONS_SUBTITLE.isDisplayed();
		waitForPageToLoad(driver, woactionPageObjects.WOACTIONS_MATERIAL);
		assert woactionPageObjects.WOACTIONS_MATERIAL.isDisplayed();
		assert woactionPageObjects.WOACTIONS_MATERIAL_SUBTITLE.isDisplayed();
	}

	public MaterialsPage launchMaterialsScreen() {
		woActionsScreenVerification();
		if(isElementPresent(woactionPageObjects.WOACTIONS_MATERIAL)) {
			woactionPageObjects.WOACTIONS_MATERIAL.click();
			ExtentTestManager.getTest().log(LogStatus.PASS, "WO Actions Screen > Matrials Screen is displayed on click of Materials button");
		} else {
			Utils.log("Materials is unavailable in WO Actiions screen");
		}
		return new MaterialsPage(driver);
	}
	
	public WOReportInPage navigatetoReportInScreen() {
		if(isElementPresent(BasePageObjects.NEXT_BUTTON)) {
			BasePageObjects.NEXT_BUTTON.click();
			ExtentTestManager.getTest().log(LogStatus.PASS, "WO Actions > Report In Screen is displayed on click of Next button");
		} else {
			Utils.log("Failed to Navigate to Report In screen");
		}
		
		return new WOReportInPage(driver);
	}
}
