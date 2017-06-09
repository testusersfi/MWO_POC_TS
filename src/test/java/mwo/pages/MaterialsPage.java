package mwo.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.PageFactory;
import com.appium.base.PageBase;
import com.appium.base.Utils;
import com.relevantcodes.extentreports.LogStatus;
import com.appium.reports.ExtentTestManager;
import mwo.pageobjects.MaterialsPageObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MaterialsPage extends PageBase {
	MaterialsPageObjects materialsPageObjects = new MaterialsPageObjects();

	public MaterialsPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), materialsPageObjects);
	}

	// Verify the Materials screen UI
	public void materialsScreenVerification() {
		waitForPageToLoad(driver, materialsPageObjects.PARTS_FROM_MY_STOCK_LABEL);
		Utils.captureInterimScreenshot(driver);
		assert materialsPageObjects.MATERIALS_TITLE.isDisplayed();
		assert materialsPageObjects.MATERIALS_DESCRIPTION.isDisplayed();
		assert materialsPageObjects.PARTS_FROM_MY_STOCK_DESCRIPTION.isDisplayed();
		assert materialsPageObjects.PARTS_FROM_MY_STOCK_LABEL.isDisplayed();
		assert materialsPageObjects.ISSUE_PLANNED_LABEL.isDisplayed();
		assert materialsPageObjects.ISSUE_PLANNED_DESCRIPTION.isDisplayed();
		assert materialsPageObjects.NEW_PLANNED_PART_LABEL.isDisplayed();
		assert materialsPageObjects.VIEW_PREVIOUS_LABEL.isDisplayed();
	}

	// Launch Parts from My Stock to issue parts
	public SelectPartPage launchPartsFromMyStock() {
		materialsScreenVerification();
		materialsPageObjects.PARTS_FROM_MY_STOCK_DESCRIPTION.click();
		ExtentTestManager.getTest().log(LogStatus.PASS,
				"Materials Page > Parts from MyStock screen is displayed on click of Parts from my stock button");
		return new SelectPartPage(driver);
	}

	// Navigate to MaterialList screen
	public MaterialListPage launchMaterialListPage() {
		waitForPageToLoad(driver, materialsPageObjects.ISSUE_PLANNED_LABEL);
		materialsPageObjects.ISSUE_PLANNED_LABEL.click();
		ExtentTestManager.getTest().log(LogStatus.PASS,
				"Materials Page > Material List screen is displayed on click of Issue Planned button");
		return new MaterialListPage(driver);
	}
	
	public WOActionsPage navigateBackToWOActionsScreen() {
		threadSleep(2000);
		goBack();
		return new WOActionsPage(driver);
	}

}
