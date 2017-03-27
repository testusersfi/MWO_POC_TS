package mwo.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.appium.base.BasePageObjects;
import com.appium.base.PageBase;
import com.appium.base.Utils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import mwo.pageobjects.CustomerAndObjectDetailsPageObjects;
import mwo.pageobjects.NewWorkOrderPageObjects;

public class CustomerAndObjectDetailsPage extends PageBase {
	CustomerAndObjectDetailsPageObjects coDetailsPageObjects = new CustomerAndObjectDetailsPageObjects();
	NewWorkOrderPageObjects newWOPageObjects = new NewWorkOrderPageObjects();

	public CustomerAndObjectDetailsPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), coDetailsPageObjects);
	}

	// Verify the Customer Object Details Screen UI
	public void customerObjectDetailsScreenVerification() {
		waitForPageToLoad(driver, coDetailsPageObjects.CUSTOMER_OBJECT);
		Utils.captureInterimScreenshot(driver);
		assert coDetailsPageObjects.CUSTOMER_NUMBER.isDisplayed();
		assert coDetailsPageObjects.OBJECT_ID.isDisplayed();
		assert coDetailsPageObjects.OBJECT_ID_LABEL.isDisplayed();
		// assert coDetailsPageObjects.CUSTOMER_CONTACT.isDisplayed();
		// assert coDetailsPageObjects.PHONE_NO.isDisplayed();
	}

	// Navigate to Select Object screen
	public SelectAnObjectPage launchSelectObjectScreen() {
		customerObjectDetailsScreenVerification();
		assert coDetailsPageObjects.OBJECT_ID.isDisplayed();
		coDetailsPageObjects.OBJECT_ID.click();
		return new SelectAnObjectPage(driver);
	}

	// navigate to WODates screen
	public WODatesPage navigateToWODatesScreen() {
		assert BasePageObjects.NEXT_BUTTON.isDisplayed();
		BasePageObjects.NEXT_BUTTON.click();
		return new WODatesPage(driver);
	}

}
