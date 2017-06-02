package mwo.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.appium.base.PageBase;
import com.appium.base.Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import mwo.pageobjects.WOMenuObjects;

public class WOMenuPage extends PageBase {
	WOMenuObjects menuPageObjects = new WOMenuObjects();

	public WOMenuPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), menuPageObjects);
	}

	// Verify the Menu screen UI
	public void MenuScreenVerification() {
		waitForPageToLoad(driver, menuPageObjects.UI_DESIGNER_MENU_ITEM);
		Utils.captureInterimScreenshot(driver);
		assert menuPageObjects.UI_DESIGNER_MENU_ITEM.isDisplayed();

	}

	// Navigate to WO designer screen
	public WODesignerPage launchWODesignerScreen() {
		MenuScreenVerification();
		menuPageObjects.UI_DESIGNER_MENU_ITEM.click();
		return new WODesignerPage(driver);
	}
}
