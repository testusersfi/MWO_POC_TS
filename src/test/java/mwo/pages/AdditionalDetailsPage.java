package mwo.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.PageFactory;
import com.appium.base.BasePageObjects;
import com.appium.base.PageBase;
import com.appium.base.Utils;
import mwo.pageobjects.AdditionalDetailsPageObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AdditionalDetailsPage extends PageBase {
	AdditionalDetailsPageObjects additionalDetailsPageObjects = new AdditionalDetailsPageObjects();

	public AdditionalDetailsPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), additionalDetailsPageObjects);
	}

	// Verify the Additional details screen UI
	public void additionalDetailsUIVerification() {
		waitForPageToLoad(driver, additionalDetailsPageObjects.DIRECTIVE_LABEL);
		Utils.captureInterimScreenshot(driver);
		
		assert BasePageObjects.MORE_OPTIONS_ICON.isDisplayed();
		assert additionalDetailsPageObjects.ADDITIONAL_DETAILS_TITLE.isDisplayed();
		assert additionalDetailsPageObjects.ADDITIONAL_DETAILS_SUBTITLE.isDisplayed();
		assert additionalDetailsPageObjects.DIRECTIVE_LABEL.isDisplayed();
		assert additionalDetailsPageObjects.DIRECTIVE_TEXTFIELD.isDisplayed();
	}
	
	//This method can be used to change the directive description
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
