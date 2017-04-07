package mwo.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.appium.base.BasePageObjects;
import com.appium.base.PageBase;
import com.appium.base.Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import mwo.pageobjects.ContactDetailsPageObjects;

public class ContactDetailsPage extends PageBase {
	ContactDetailsPageObjects contactDetailsPageObjects = new ContactDetailsPageObjects();
	
	public ContactDetailsPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), contactDetailsPageObjects);
	}
	
	//Verify Contact Details screen UI
	public void contactDetailsUIVerification()
	{
		waitForPageToLoad(driver, contactDetailsPageObjects.CONTACT_DETAILS_TITLE);
		Utils.captureInterimScreenshot(driver);
		assert BasePageObjects.MORE_OPTIONS_ICON.isDisplayed();
		assert contactDetailsPageObjects.CONTACT_DETAILS_TITLE.isDisplayed();
		assert contactDetailsPageObjects.CONTACT_DETAILS_SUBTITLE.isDisplayed();
		assert contactDetailsPageObjects.CONTACTNAME_LABEL.isDisplayed();
		assert contactDetailsPageObjects.CONTACTNAME_TEXTFIELD.isDisplayed();
		assert contactDetailsPageObjects.PHONENO_LABEL.isDisplayed();
		assert contactDetailsPageObjects.PHONENO_TEXTFIELD.isDisplayed();
		assert contactDetailsPageObjects.CUSTOMERNO_LABEL.isDisplayed();
		assert contactDetailsPageObjects.CUSTOMERNO_TEXTFIELD.isDisplayed();
	}
	
	public WOPreviewPage enterContactDetails(String name, String number) {
		enterTextInTextField(contactDetailsPageObjects.CONTACTNAME_TEXTFIELD, name);
		enterTextInTextField(contactDetailsPageObjects.PHONENO_TEXTFIELD, number);
		BasePageObjects.SAVE_BUTTON.click();
		return new WOPreviewPage(driver);
	}
	
	public void enterTextInTextField(MobileElement edit_text_field, String input_text){
		edit_text_field.clear();
		hideKeyboardBasedOnPlatform();
		edit_text_field.click();
		enterTextUsingadb(input_text);
	}

}
