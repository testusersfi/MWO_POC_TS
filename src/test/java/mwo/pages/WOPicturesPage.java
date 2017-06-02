package mwo.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.PageFactory;

import com.appium.base.BasePageObjects;
import com.appium.base.PageBase;
import com.appium.base.Utils;
import com.relevantcodes.extentreports.LogStatus;
import com.appium.reports.ExtentTestManager;

import mwo.pageobjects.WOExpensesPageObjects;
import mwo.pageobjects.WOPicturesPageObjects;
import mwo.pageobjects.WOPreviewPageObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WOPicturesPage extends PageBase {
	
	WOPicturesPageObjects picturePageObjects = new WOPicturesPageObjects();

	public WOPicturesPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), picturePageObjects);
	}
	
	public void picturesScreenUIVerification() {
		waitForPageToLoad(driver, picturePageObjects.PICTURES_SCREEN_SUBTITLE);
		Utils.captureInterimScreenshot(driver);
		assert picturePageObjects.IMAGES_LIST_VIEW.isDisplayed();
		assert picturePageObjects.PICTURES_SCREEN_TITLE.isDisplayed();
	}
	
	public WOAddPicturePage navigateToAddPictureScreen() {
		Boolean add_button_status = BasePageObjects.ADD_BUTTON.isEnabled();
		picturesScreenUIVerification();
		try {
			if(add_button_status) {
				BasePageObjects.ADD_BUTTON.click();
				return new WOAddPicturePage(driver);
			} else {
				ExtentTestManager.getTest().log(LogStatus.FAIL, "User can not add images to the WO, Because the Add button is disabled in Pictures screen");
			}
		}catch (Exception e) {
			e.printStackTrace();
			Utils.log(e.getMessage());
		}
		return null;
	}
	
	public WOActionsPage navigateBackToActionsScreen() {
		goBack();
		return new WOActionsPage(driver);
	}
}