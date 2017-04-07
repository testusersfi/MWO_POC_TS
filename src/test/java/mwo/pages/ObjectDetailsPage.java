package mwo.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.appium.base.BasePageObjects;
import com.appium.base.PageBase;
import com.appium.base.Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import mwo.pageobjects.ObjectDetailsPageObjects;


public class ObjectDetailsPage extends PageBase {
	ObjectDetailsPageObjects objectDetailsPageObjects=new ObjectDetailsPageObjects();
	SelectAnObjectPage selectAnObjectPage;
	
	public ObjectDetailsPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), objectDetailsPageObjects);
	}
	
	// Verify the Object Details screen UI
		public void objectDetailsUIVerification() {
			waitForPageToLoad(driver, objectDetailsPageObjects.OBJECTID_LABEL);
			Utils.captureInterimScreenshot(driver);
			assert BasePageObjects.MORE_OPTIONS_ICON.isDisplayed();
			assert objectDetailsPageObjects.OBJECT_DETAILS_TITLE.isDisplayed();
			assert objectDetailsPageObjects.OBJECT_DETAILS_SUBTITLE.isDisplayed();
			assert objectDetailsPageObjects.OBJECTID_LABEL.isDisplayed();
			assert objectDetailsPageObjects.OBJECTID_TEXTFIELD.isDisplayed();
		}
		
	public SelectAnObjectPage launchObjectIDScreen()
	{
		objectDetailsPageObjects.OBJECTID_TEXTFIELD.click();
		//selectAnObjectPage.ObjectScreenUIVerification();
		//selectAnObjectPage.selectObject();
		//BasePageObjects.SAVE_BUTTON.click();
		return new SelectAnObjectPage(driver);	
	}
	
	public void save() {
		assert BasePageObjects.SAVE_BUTTON.isDisplayed();
		BasePageObjects.SAVE_BUTTON.click();
	}


}
