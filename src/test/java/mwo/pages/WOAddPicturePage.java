package mwo.pages;

import java.util.concurrent.TimeUnit;


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
		soft_assert.assertTrue(addPicturePageObjects.ADD_PICTURE_SCREEN_TITLE.isDisplayed());
		soft_assert.assertTrue(addPicturePageObjects.ADD_PICTURE_SCREEN_DESCRIPTION.isDisplayed());
		soft_assert.assertTrue(addPicturePageObjects.PICTURE_DESCRIPTION_LABEL.isDisplayed());
		soft_assert.assertTrue(addPicturePageObjects.PICTURE_DESCRIPTION_TEXT_FIELD.isDisplayed());
		soft_assert.assertTrue(addPicturePageObjects.TAKE_PHOTO_BUTTON.isDisplayed());
		soft_assert.assertTrue(BasePageObjects.PREVIOUS_ENTRIES_BUTTON.isDisplayed());
	}

	public void captureImageToWO() {
		try {
			if(isElementPresent(addPicturePageObjects.TAKE_PHOTO_BUTTON)) {
				addPicturePageObjects.TAKE_PHOTO_BUTTON.click();
				threadSleep(2000);
				inputKeyeventUsingadb(27);
				threadSleep(2000);
				clickOKButtonPostImageCapture();
				ExtentTestManager.getTest().log(LogStatus.PASS, "Image captured using camera and added under pictures");
				Utils.captureInterimScreenshot(driver);
			} else {
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Take Photo button is not displayed in the Pictures Screen");
			}
		}catch (Exception e) {
			e.printStackTrace();
			Utils.log(e.getMessage());
		}
		
	}

	public void addImageToWO() {
		int prevalue = Integer.parseInt(BasePageObjects.PREVIOUS_BUTTON.getText().replaceAll("[^0-9]", "").trim());
		captureImageToWO();
		try {
			if (isElementPresent(addPicturePageObjects.ATTACHED_CAMERA_IMAGE)) {
				BasePageObjects.ADD_BUTTON.click();
				int newvalue = Integer.parseInt(BasePageObjects.PREVIOUS_BUTTON.getText().replaceAll("[^0-9]", "").trim());

				if (newvalue > prevalue) {
					ExtentTestManager.getTest().log(LogStatus.PASS,
							"Image is successfully added to the work order");
				} else {
					ExtentTestManager.getTest().log(LogStatus.FAIL,
							"Adding image to the work order is failed");

				}
			} else {
				ExtentTestManager.getTest().log(LogStatus.FAIL, "ImageCapture Failed using camera");
			}
		} catch (Exception e) {
			e.printStackTrace();
			Utils.log(e.getMessage());
		}
		
		

	}
	
	public void clickOKButtonPostImageCapture() {
		if(isElementPresent(addPicturePageObjects.POST_CAPTURE_OK_BUTTON)) {
			addPicturePageObjects.POST_CAPTURE_OK_BUTTON.click();
		} else if(isElementPresent(addPicturePageObjects.POST_CAPTURE_DONE_BUTTON)) {
			addPicturePageObjects.POST_CAPTURE_DONE_BUTTON.click();
		} else if(isElementPresent(addPicturePageObjects.POST_CAPTURE_V6_DONE_BUTTON)) {
			addPicturePageObjects.POST_CAPTURE_V6_DONE_BUTTON.click();
		} else {
			Utils.captureInterimScreenshot(driver);
			ExtentTestManager.getTest().log(LogStatus.FAIL, "ImageCapture Failed using camera");
		}
	}

	public WOPicturesPage navigateBackToPicturesScreen() {
		goBack();
		return new WOPicturesPage(driver);
	}
}