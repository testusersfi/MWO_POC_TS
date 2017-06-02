package mwo.pages;

import java.util.concurrent.TimeUnit;

import org.bouncycastle.jcajce.provider.symmetric.ARC4.Base;
import org.openqa.selenium.support.PageFactory;

import com.appium.base.BasePageObjects;
import com.appium.base.PageBase;
import com.appium.base.Utils;
import com.relevantcodes.extentreports.LogStatus;
import com.appium.reports.ExtentTestManager;

import mwo.pageobjects.WOAddPicturePageObjects;
import mwo.pageobjects.WOExpensesPageObjects;
import mwo.pageobjects.WOPicturesPageObjects;
import mwo.pageobjects.WOPreviewPageObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WOAddPicturePage extends PageBase {

	WOAddPicturePageObjects addPicturePageObjects = new WOAddPicturePageObjects();

	public WOAddPicturePage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), addPicturePageObjects);
	}

	public void picturesScreenUIVerification() {
		waitForPageToLoad(driver, addPicturePageObjects.ATTACH_FILE_BUTTON);
		Utils.captureInterimScreenshot(driver);
		assert addPicturePageObjects.ADD_PICTURE_SCREEN_TITLE.isDisplayed();
		assert addPicturePageObjects.ADD_PICTURE_SCREEN_DESCRIPTION.isDisplayed();
		assert addPicturePageObjects.PICTURE_DESCRIPTION_LABEL.isDisplayed();
		assert addPicturePageObjects.PICTURE_DESCRIPTION_TEXT_FIELD.isDisplayed();
		assert addPicturePageObjects.TAKE_PHOTO_BUTTON.isDisplayed();
		assert BasePageObjects.PREVIOUS_ENTRIES_BUTTON.isDisplayed();
	}

	public void captureImageToWO() {
		try {
			if(isElementPresent(addPicturePageObjects.TAKE_PHOTO_BUTTON)) {
				addPicturePageObjects.TAKE_PHOTO_BUTTON.click();
				threadSleep(2000);
				inputKeyeventUsingadb(27);
				threadSleep(2000);
				addPicturePageObjects.POST_CAPTURE_OK_BUTTON.click();
			} else {
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Take Photo button is not displayed in the Pictures Screen");
			}
		}catch (Exception e) {
			e.printStackTrace();
			Utils.log(e.getMessage());
		}
		
	}

	public void addImageToWO() {
		captureImageToWO();
		try {
			if (isElementPresent(addPicturePageObjects.ATTACHED_CAMERA_IMAGE)) {
				BasePageObjects.ADD_BUTTON.click();
			} else {
				ExtentTestManager.getTest().log(LogStatus.FAIL, "ImageCapture Failed using camera");
			}
		} catch (Exception e) {
			e.printStackTrace();
			Utils.log(e.getMessage());
		}
	}

	public WOPicturesPage navigateBackToPicturesScreen() {
		goBack();
		return new WOPicturesPage(driver);
	}
}