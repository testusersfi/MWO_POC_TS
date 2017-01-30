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

import mwo.pageobjects.AdditionalDetailsPageObjects;
import mwo.pageobjects.HomePageObjects;
import mwo.pageobjects.MaterialListPageObjects;
import mwo.pageobjects.MaterialsPageObjects;
import mwo.pageobjects.WOActionPageObjects;
import mwo.pageobjects.WorkOrdersPageObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AdditionalDetailsPage extends PageBase {
	AdditionalDetailsPageObjects additionalDetailsPageObjects = new AdditionalDetailsPageObjects();

	public AdditionalDetailsPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), additionalDetailsPageObjects);
	}

	// Verify the Materials screen UI
	public void additionalDetailsUIVerification() {
		waitForPageToLoad(driver, additionalDetailsPageObjects.DIRECTIVE_LABEL);
		Utils.captureInterimScreenshot(driver);
		
		assert BasePageObjects.MORE_OPTIONS_ICON.isDisplayed();
		assert additionalDetailsPageObjects.ADDITIONAL_DETAILS_TITLE.isDisplayed();
		assert additionalDetailsPageObjects.ADDITIONAL_DETAILS_SUBTITLE.isDisplayed();
		assert additionalDetailsPageObjects.DIRECTIVE_LABEL.isDisplayed();
		assert additionalDetailsPageObjects.DIRECTIVE_TEXTFIELD.isDisplayed();
	}
	
	public WOPreviewPage changeDirectiveText() {
		additionalDetailsPageObjects.DIRECTIVE_TEXTFIELD.clear();
		threadSleep(2000);
		dismissScanBarCodealert();
		additionalDetailsPageObjects.DIRECTIVE_TEXTFIELD.click();
		threadSleep(2000);
		dismissScanBarCodealert();
		additionalDetailsPageObjects.DIRECTIVE_TEXTFIELD.sendKeys("Repair Electricity Meter");
		threadSleep(2000);
		dismissScanBarCodealert();
		BasePageObjects.SAVE_BUTTON.click();
		assert BasePageObjects.NEXT_BUTTON.isDisplayed();
		BasePageObjects.NEXT_BUTTON.click();
		return new WOPreviewPage(driver);
	}
	

	
}
