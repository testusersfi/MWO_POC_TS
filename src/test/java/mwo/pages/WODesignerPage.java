package mwo.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.appium.base.PageBase;
import com.appium.base.Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import mwo.pageobjects.WOUIDesignerObjects;

public class WODesignerPage extends PageBase{
	WOUIDesignerObjects designerPageObjects = new WOUIDesignerObjects();

	public WODesignerPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), designerPageObjects);
	}

	// Verify the UI Designer screen 
	public void UIDesignerScreenVerification() {
		waitForPageToLoad(driver, designerPageObjects.UIDESIGNER_SCREEN_TITLE);
		Utils.captureInterimScreenshot(driver);
		assert designerPageObjects.UIDESIGNER_SCREEN_TITLE.isDisplayed();

	}
	
	
	public WOPreviewPage navigateBackToPreviewScreen()
	{
		goBack();
		threadSleep(3000);
		return new WOPreviewPage(driver);
	}
}
