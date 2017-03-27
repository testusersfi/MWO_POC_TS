package mwo.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.PageFactory;
import com.appium.base.BasePageObjects;
import com.appium.base.PageBase;
import com.appium.base.Utils;
import com.relevantcodes.extentreports.LogStatus;
import com.appium.reports.ExtentTestManager;
import mwo.pageobjects.MaterialListPageObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MaterialListPage extends PageBase {
	MaterialListPageObjects materialListPageObjects = new MaterialListPageObjects();

	public MaterialListPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), materialListPageObjects);
	}

	// Verify the Materials screen UI
	public void materialListUIVerification() {
		waitForPageToLoad(driver, materialListPageObjects.MATERIALS_LIST_TITLE);
		Utils.captureInterimScreenshot(driver);
		assert BasePageObjects.MORE_OPTIONS_ICON.isDisplayed();
		assert materialListPageObjects.MATERIALS_LIST_TITLE.isDisplayed();
		assert materialListPageObjects.MATERIALS_LIST_SUBTITLE.isDisplayed();
	}

	// Navigate to WO returns screen
	public ReturnsPage launchReturnsScreen() {
		assert BasePageObjects.NEXT_BUTTON.isDisplayed();
		materialListUIVerification();
		BasePageObjects.NEXT_BUTTON.click();
		ExtentTestManager.getTest().log(LogStatus.PASS,
				"MaterialList Page > Returns Screen is displayed on click of Next button");
		return new ReturnsPage(driver);
	}

}
