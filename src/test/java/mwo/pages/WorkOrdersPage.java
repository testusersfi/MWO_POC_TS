package mwo.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import com.appium.base.BasePageObjects;
import com.appium.base.PageBase;
import com.appium.base.Utils;
import com.relevantcodes.extentreports.LogStatus;
import com.appium.reports.ExtentTestManager;
import mwo.pageobjects.WorkOrdersPageObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WorkOrdersPage extends PageBase {
	WorkOrdersPageObjects woPageObjects = new WorkOrdersPageObjects();

	public WorkOrdersPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), woPageObjects);
	}

	// Verify the Work Orders List UI
	public void WOListScreenHeaderUIVerification() {
		waitForPageToLoad(driver, woPageObjects.SCREEN_HEADER);
		Utils.captureInterimScreenshot(driver);
		assert BasePageObjects.MORE_OPTIONS_ICON.isDisplayed();
		assert woPageObjects.BAR_CODE_SCAN.isDisplayed();
	}

	// Search for the relevant work order from the WO list
	public WOPreviewPage searchForWorkOrder(String wo_number) throws InterruptedException {
		WOListScreenHeaderUIVerification();
		// String number_Xpath = findWorkOrder(driver, wo_number);
		String number_Xpath = findRelativeXpath(driver, woPageObjects.WORKORDER_NUMBER, wo_number);
		Utils.log("Entered scroll view method");
		scrollListView(number_Xpath);
		driver.findElement(By.xpath(number_Xpath)).click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "Work Order is present and cliked on the relevant workorder");
		return new WOPreviewPage(driver);
	}

	// Navigate back to Home screen
	public HomePage navigateBackToHomeScreen() {
		goBack();
		return new HomePage(driver);
	}

}
