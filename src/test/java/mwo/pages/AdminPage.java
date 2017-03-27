package mwo.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import com.appium.base.BasePageObjects;
import com.appium.base.PageBase;
import com.appium.base.Utils;
import mwo.pageobjects.AdminPageObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AdminPage extends PageBase {
	AdminPageObjects adminPageObjects = new AdminPageObjects();

	public AdminPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), adminPageObjects);
	}

	// To verify the Sync Admin screen UI
	public void adminScreenUIVerification() {
		waitForPageToLoad(driver, adminPageObjects.SYNC_INTERVAL_SPINNER);
		Utils.captureInterimScreenshot(driver);
		assert BasePageObjects.MORE_OPTIONS_ICON.isDisplayed();
		assert adminPageObjects.SERVICE_ADDRESS.isDisplayed();
		assert adminPageObjects.SYNC_INTERVAL.isDisplayed();
		assert adminPageObjects.LOG_TYPE.isDisplayed();
		assert adminPageObjects.PUSH_ENABLED.isDisplayed();
		assert adminPageObjects.SEND_LOG_FILES.isDisplayed();
		assert adminPageObjects.SEND_MESSAGES.isDisplayed();
		assert adminPageObjects.INITIALIZE.isDisplayed();
	}

	/*	public void configureSyncInterval() throws InterruptedException {
		adminScreenUIVerification();
		adminPageObjects.SYNC_INTERVAL_SPINNER.click();
		threadSleep(1000);
		adminPageObjects.SYNC_INTERVAL_1_HOUR.click();
	}*/

	public HomePage navigateBackToHomeScreen() {
		goBack();
		return new HomePage(driver);
	}

	public void syncIntervalConfiguration(String sync_interval) throws InterruptedException {
		adminScreenUIVerification();
		adminPageObjects.SYNC_INTERVAL_SPINNER.click();
		threadSleep(1000);
		String interval_xpath = findSyncIntervalInSpinner(driver, "1 Minute");
		if (isElementPresent(By.xpath(interval_xpath))) {
			assert driver.findElement(By.xpath(interval_xpath)).isDisplayed();
			driver.findElement(By.xpath(interval_xpath)).click();
		} else {
			swipingVertical(adminPageObjects.DROP_DOWN_LISTVIEW, SWIPE_V_OPTIONS.DOWN);
			assert driver.findElement(By.xpath(interval_xpath)).isDisplayed();
			driver.findElement(By.xpath(interval_xpath)).click();
		}
	}

	public String findSyncIntervalInSpinner(AppiumDriver<MobileElement> driver, String data) {
		String result = null;
		if (Utils.getDriverPlatform(driver).equals("AndroidDriver")) {
			result = String.format(AdminPageObjects.SYNC_INTERVAL_1_MINUTE, data);
			return result;
		} else if (Utils.getDriverPlatform(driver).equals("IOSDriver")) {
			result = String.format(AdminPageObjects.SYNC_INTERVAL_1_MINUTE, data);
			return result;
		}
		Utils.log("Final XPath: " + result);
		return null;
	}

}
