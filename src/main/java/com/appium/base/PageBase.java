package com.appium.base;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnsupportedCommandException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.annotation.values.ElementDescription;
import com.annotation.values.PageName;
import com.appium.base.Utils;
import com.relevantcodes.extentreports.LogStatus;
import com.report.factory.ExtentTestManager;

import io.appium.java_client.AppiumDriver;

import io.appium.java_client.MobileElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDeviceActionShortcuts;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.HideKeyboardStrategy;


public abstract class PageBase {
	public static AppiumDriver<MobileElement> driver;
	public static Dimension size;
	
	
	//public static 
	BasePageObjects basePageObjects = new BasePageObjects();
	public SoftAssert soft_assert = new SoftAssert();
	public PageBase(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), basePageObjects);
	}

	public enum SWIPE_V_OPTIONS {
		UP, DOWN
	}

	public static WebElement getElementWhenVisible(WebDriver driver, MobileElement mobileElement) {
		WebElement el = null;
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(25, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS);
		//WebDriverWait wait = new WebDriverWait(driver, 20);
		el = wait.until(ExpectedConditions.visibilityOf(mobileElement));
		return el;
	}

	public static void getCurrentDate() {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date = new Date();
		String date1 = dateFormat.format(date);
		System.out.println(date1);
	}

	public static void waitUntilElementsAreInvisible(List<WebElement> mobileElement) {
		//WebDriverWait wait = new WebDriverWait(driver, 300);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(300, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.invisibilityOfAllElements(mobileElement));
	}	
	

	  
	protected static boolean isElementPresent(MobileElement mobileElement) {
		Boolean elementPresent = true;
		try {
			elementPresent = mobileElement.isDisplayed();
		} catch (UnsupportedCommandException | NoSuchElementException ignored) {
			elementPresent = false;
		}
		return elementPresent;
	}

	public static boolean isElementPresent(By by) {
		Boolean iselementpresent = driver.findElements(by).size() != 0;
		return iselementpresent;
	}

	public static void acceptPermissionAlertAndroid() {
		try {
			String alertText = driver.findElementById("com.android.packageinstaller:id/permission_message").getText();
			driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
			Reporter.log("Alert Text: " + alertText);
		} catch (Exception e) {
			Reporter.log("Exception while Accepting Alert: " + e.getStackTrace());
		}
	}

	public void takeScreenShot(String fileName) {
		File file = new File(fileName + ".png");
		File tmpFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(tmpFile, file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static boolean waitForPageToLoad(AppiumDriver<MobileElement> driver, WebElement mobileElement) {
		try {
			//WebDriverWait wait = new WebDriverWait(driver, 10);
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
					.withTimeout(20, TimeUnit.SECONDS)
					.pollingEvery(2, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.visibilityOf(mobileElement));
			return true;
		} catch (TimeoutException | NoSuchElementException e) {
			return false;
		}
	}

	public static MobileElement waitForElement(AppiumDriver<MobileElement> driver, MobileElement mobileElement) {
		waitForPageToLoad(driver, mobileElement);
		MobileElement el = mobileElement;
		return el;
	}

	public static void waitForElementsVisible(AppiumDriver<MobileElement> driver, List<WebElement> mobileElement) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(10, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOfAllElements(mobileElement));
	}

	public void threadSleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void hideKeyboardBasedOnPlatform() {
		if (Utils.getDriverPlatform(driver).equals("AndroidDriver")) {
			try {
				Utils.log("Android > Trying to hide Keyboard");
				driver.hideKeyboard();
			} catch (Exception ea) {
				ea.printStackTrace();
			}
		} else if (Utils.getDriverPlatform(driver).equals("IOSDriver")) {
			try {
				Utils.log("iOS > Trying to hide Keyboard using 'PRESS_KEY > Done'");
				((IOSDriver<MobileElement>) driver).hideKeyboard(HideKeyboardStrategy.PRESS_KEY, "Done");
			} catch (Exception ei1) {
				try {
					Utils.log("iOS > Trying to hide Keyboard using 'PRESS_KEY > Go'");
					((IOSDriver<MobileElement>) driver).hideKeyboard(HideKeyboardStrategy.PRESS_KEY, "Go");
				} catch (Exception ei2) {
					try {
						Utils.log("iOS > Trying to hide Keyboard using 'TAP_OUTSIDE'");
						((IOSDriver<MobileElement>) driver).hideKeyboard(HideKeyboardStrategy.TAP_OUTSIDE, "");
					} catch (Exception ei3) {
						try {
							Utils.log("iOS > Trying to hide Keyboard using native means");
							driver.hideKeyboard();
						} catch (Exception ei4) {
							ei4.printStackTrace();
						}
					}
				}
			}
		}
	}

	public void logStepIntoExtentReport(String elementDescription, String action, String typeString) {
		ExtentTestManager.getTest().log(LogStatus.INFO, withBoldHTML(action),
				elementDescription + "; " + withBoldHTML("Text") + ": " + typeString);
	}

	public String withBoldHTML(String string) {
		if (!string.trim().isEmpty()) {
			return "<b>" + string + "</b>";
		} else {
			return "";
		}
	}

	public String getPageObjectElementDescription(Object pageObject, String fieldName) {
		try {
			return this.getClass().getAnnotation(PageName.class).value() + "::"
					+ pageObject.getClass().getField(fieldName).getAnnotation(ElementDescription.class).value();
		} catch (NoSuchFieldException e) {

			e.printStackTrace();
		}
		return "";
	}

	public void goBack() {
		if (Utils.getDriverPlatform(driver).equals("AndroidDriver")) {
			((AndroidDeviceActionShortcuts) driver).pressKeyCode(AndroidKeyCode.BACK);
		} else if (Utils.getDriverPlatform(driver).equals("IOSDriver")) {
			if (isElementPresent(basePageObjects.IOS_DONE)) {
				basePageObjects.IOS_DONE.click();
			} else {
				basePageObjects.IOS_BACK.click();
			}
		}
	}

	public void switchToNativeView() {
		driver.context("NATIVE_APP");
	}

	public void executeadbcommand(String[] command) {
		Object returnValue = null;
		String line;
		try {
			final Process process = Runtime.getRuntime().exec(command);
			InputStream inStream = process.getInputStream();
			final BufferedReader br = new BufferedReader(new InputStreamReader(inStream));

			while ((line = br.readLine()) != null) {
				returnValue = returnValue + line + "\n";
			}
			br.close();
			try {
				process.waitFor();
			} catch (final InterruptedException e) {
				System.out.println(e.getMessage());
			}
		} catch (final Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(returnValue);
	}

	public void enterTextUsingadb(String text) {
		String[] adb_command = { "sh", "-c", "adb shell input text \"" + text + "\"" };
		executeadbcommand(adb_command);
	}
	
	public void inputKeyeventUsingadb(int  key_code) {
		String[] adb_command = { "sh", "-c", "adb shell input keyevent \"" + key_code + "\"" };
		executeadbcommand(adb_command);
	}

	public void swipingVertical(MobileElement element, SWIPE_V_OPTIONS swipeOptions) throws InterruptedException {
		// Get the size of screen.

		int offset = 1;
		Point p = element.getCenter();
		Point location = element.getLocation();
		Dimension size = element.getSize();
		int starty = location.getY() + size.getHeight() + offset;
		int y1 = (int) 0.8 * starty;

		// driver.swipe(p.getX(), y1, p.getX(), location.getY(), 4000);
		/*
		 * System.out.println(size);
		 * 
		 * // Find swipe start and end point from screen's with and height. //
		 * Find starty point which is at bottom side of screen. int starty =
		 * (int) (size.height * 0.80); // Find endy point which is at top side
		 * of screen. int endy = (int) (size.height * 0.20); // Find horizontal
		 * point where you wants to swipe. It is in middle of // screen width.
		 * int startx = size.width / 2; System.out.println("starty = " + starty
		 * + " ,endy = " + endy + " , startx = " + startx);
		 * 
		 * // Swipe from Top to Bottom. driver.swipe(startx, endy, startx,
		 * starty, 3000);
		 */

		if (swipeOptions == SWIPE_V_OPTIONS.UP) {
			// Swipe Up from Bottom to Top.
			driver.swipe(p.getX(), y1, p.getX(), location.getY(), 4000);
		} else {
			// Swipe Down from Top to Bottom.
			driver.swipe(p.getX(), location.getY(), p.getX(), y1, 3000);
		}
		threadSleep(2000);
	}


	public void turnOnAirPlaneMode() {
		String[] put_ap_on = { "sh", "-c", "adb shell settings put global airplane_mode_on 1" };
		executeadbcommand(put_ap_on);
		threadSleep(4000);
		String[] turnon_Airplane = { "sh", "-c",
				"adb shell am broadcast -a android.intent.action.AIRPLANE_MODE --ez state true" };
		executeadbcommand(turnon_Airplane);
	}

	public void turnOffAirplaneMode() {
		String[] access_Settings = { "sh", "-c", "adb shell settings put global airplane_mode_on 0" };
		executeadbcommand(access_Settings);
		threadSleep(4000);
		String[] turnoff_Airplane = { "sh", "-c",
				"adb shell am broadcast -a android.intent.action.AIRPLANE_MODE --ez state false" };
		executeadbcommand(turnoff_Airplane);
	}

	public void scrollListView(String value) throws InterruptedException {

		boolean searchElement = true;
		String lastTxtElement = null;
		String previousTxtElement;
		List<MobileElement> elements;

		while (searchElement) {
			previousTxtElement = (lastTxtElement != null) ? lastTxtElement : "unset";

			if (value.contains("work_order__wo_no"))
				elements = driver.findElementsById("com.ifsworld.mworkorderapps9:id/work_order__wo_no");
			else
				elements = driver.findElementsById("com.ifsworld.mworkorderapps9:id/debrief_menu_option_name");
			
			lastTxtElement = elements.get(elements.size() - 1).getText();

			// compare element's text between last index of previous swipe and
			// last index of current swipe to detect end of scrolling
			if (lastTxtElement.equals(previousTxtElement)) {
				throw new NoSuchElementException("stopperElement not found");
				// ExtentTestManager.getTest().log(LogStatus.FAIL, "Given work
				// order does not exist in the List");
			}

			try {
				// stop when desired element is displayed
				Utils.log("entered try loop");
					driver.findElementByXPath(value);
				searchElement = false;
			} catch (Exception e) {
				// swipe up|down when desired element is not displayed
				Utils.log("entered exception loop");
				MobileElement element1 = driver
						.findElementByXPath("//android.widget.LinearLayout/android.widget.FrameLayout");
				swipingVertical(element1, SWIPE_V_OPTIONS.UP);

			}

		}
	}

	public void scrolltoText(MobileElement element_to_verify) throws InterruptedException {
		for (int i = 0; i < 4; i++) {
			boolean searchElement = true;
			if (searchElement) {
				try {
					// stop when desired element is displayed
					Utils.log("entered try loop");
					isElementPresent(element_to_verify);
					assert element_to_verify.isDisplayed();
					searchElement = false;
					break;
				} catch (Exception e) {
					// swipe up|down when desired element is not displayed
					Utils.log("entered exception loop");
					MobileElement element1 = driver
							.findElementByXPath("//android.widget.LinearLayout/android.widget.FrameLayout");
					swipingVertical(element1, SWIPE_V_OPTIONS.UP);

				}
			}
		}
	}

	public static void drawSignOntheCanvas(WebElement element) {
		TouchAction builder = new TouchAction(driver);
		TouchAction drawAction = builder.longPress(element).moveTo(100, 100).moveTo(150, 150).release().perform();
		drawAction.perform();
	}

	public void enterTextinCommentsFeild(MobileElement comments_field, String comments) {
		if (isElementPresent(comments_field)) {
			comments_field.click();
			enterTextUsingadb(comments);
			// comments_field.sendKeys(comments);
			hideKeyboardBasedOnPlatform();
		} else {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Comments field is not available");
		}
	}

	public String findRelativeXpath(AppiumDriver<MobileElement> driver, String page_object, String verification_text) {
		String result = null;
		if (Utils.getDriverPlatform(driver).equals("AndroidDriver")) {
			result = String.format(page_object, verification_text);
			return result;
		} else if (Utils.getDriverPlatform(driver).equals("IOSDriver")) {
			result = String.format(page_object, verification_text);
		}
		Utils.log("Final XPath: " + result);
		return null;

	}
	
	public String findRelativeXpath1(AppiumDriver<MobileElement> driver, String page_object) {
		String result = null;
		if (Utils.getDriverPlatform(driver).equals("AndroidDriver")) {
			result = String.format(page_object);
			return result;
		} else if (Utils.getDriverPlatform(driver).equals("IOSDriver")) {
			result = String.format(page_object);
		}
		Utils.log("Final XPath: " + result);
		return null;

	}
	
	
	

}
