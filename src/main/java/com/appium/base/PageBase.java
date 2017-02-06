package com.appium.base;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.invoke.SwitchPoint;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnsupportedCommandException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.annotation.values.ElementDescription;
import com.annotation.values.PageName;
import com.appium.base.Utils;
import com.relevantcodes.extentreports.LogStatus;
import com.report.factory.ExtentTestManager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.AppiumSetting;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDeviceActionShortcuts;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.HideKeyboardStrategy;

public abstract class PageBase {
	public static AppiumDriver<MobileElement> driver;
	public static Dimension size;
	BasePageObjects basePageObjects = new BasePageObjects();

	public PageBase(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), basePageObjects);
	}

	public static WebElement getElementWhenVisible(WebDriver driver, MobileElement mobileElement) {
		WebElement el = null;
		WebDriverWait wait = new WebDriverWait(driver, 20);
		el = wait.until(ExpectedConditions.visibilityOf(mobileElement));
		return el;
	}
	
	public static void getCurrentDate() {
		 DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		 Date date = new Date();
		 String date1= dateFormat.format(date);
		 System.out.println(date1);
	}

	public static void waitUntilElementsAreInvisible(List<WebElement> mobileElement) {
		WebDriverWait wait = new WebDriverWait(driver, 300);
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
			WebDriverWait wait = new WebDriverWait(driver, 30);
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
		WebDriverWait wait = new WebDriverWait(driver, 30);
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

	public void switchToWebView(String webViewName) {
		driver.manage().timeouts().implicitlyWait(
				Integer.parseInt(Utils.PROPERTIES.getProperty("IMPLICIT_WAIT_SECONDS")), TimeUnit.SECONDS);
		threadSleep(15000);

		Set<String> contextSet = driver.getContextHandles();
		Utils.log("driver.getContextHandles() ==> " + contextSet);
		Utils.log("count of contexts  => " + contextSet.toArray().length);
		if (Utils.getDriverPlatform(driver).equals("AndroidDriver")) {
			// We are in Android
			for (String contextName : contextSet) {
				if (contextName.contains(webViewName)) {
					((AndroidDriver<MobileElement>) driver).context(contextName);
					threadSleep(5000);
					Utils.log("Android Context is set to ==> " + driver.getContext());
					break;
				}
			}
		} else if (Utils.getDriverPlatform(driver).equals("IOSDriver")) {
			// We are in iOS
			String tmpCtx = contextSet.toArray()[(contextSet.toArray().length - 1)].toString();
			((IOSDriver<MobileElement>) driver)
					.context(contextSet.toArray()[(contextSet.toArray().length - 1)].toString());
			threadSleep(5000);
			Utils.log("iOS Context is set to ==> " + driver.getContext());
		}
		Utils.log("Current URL ==> '" + driver.getCurrentUrl() + "'");
		Utils.log("Page Source ==> <iframe src='" + driver.getCurrentUrl() + "' width='400' height='700'></iframe>");
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
		String[] adb_command = { "/bin/sh", "-c", "adb shell input text \"" + text + "\"" };
		executeadbcommand(adb_command);
	}

	public static void swipingVertical(MobileElement element) throws InterruptedException {
		// Get the size of screen.
		
		int offset = 1;
        Point p = element.getCenter();
        Point location = element.getLocation();
        Dimension size = element.getSize();
        int starty = location.getY() + size.getHeight() + offset;
        int y1 = (int) 0.8*starty;
        
        driver.swipe(p.getX(), y1, p.getX(), location.getY(), 4000);
/*		System.out.println(size);

		// Find swipe start and end point from screen's with and height.
		// Find starty point which is at bottom side of screen.
		int starty = (int) (size.height * 0.80);
		// Find endy point which is at top side of screen.
		int endy = (int) (size.height * 0.20);
		// Find horizontal point where you wants to swipe. It is in middle of
		// screen width.
		int startx = size.width / 2;
		System.out.println("starty = " + starty + " ,endy = " + endy + " , startx = " + startx);

		// Swipe from Top to Bottom.
		driver.swipe(startx, endy, startx, starty, 3000);*/
		Thread.sleep(2000);
	}

	public void dismissScanBarCodealert() {
		if (isElementPresent(BasePageObjects.SCAN_BAR_CODE_LONGPRESS)) {
			goBack();
		} else {
			Utils.log("SCAN BAR CODE ALERT IS NOT DISPLAYED");
		}
	}

	public void turnOnAirPlaneMode() {
		String[] put_ap_on = { "/bin/sh", "-c", "adb shell settings put global airplane_mode_on 1" };
		executeadbcommand(put_ap_on);
		threadSleep(4000);
		String[] turnon_Airplane = { "/bin/sh", "-c",
				"adb shell am broadcast -a android.intent.action.AIRPLANE_MODE --ez state true" };
		executeadbcommand(turnon_Airplane);
	}

	public void turnOffAirplaneMode() {
		String[] access_Settings = { "/bin/sh", "-c", "adb shell settings put global airplane_mode_on 0" };
		executeadbcommand(access_Settings);
		threadSleep(4000);
		String[] turnoff_Airplane = { "/bin/sh", "-c",
				"adb shell am broadcast -a android.intent.action.AIRPLANE_MODE --ez state false" };
		executeadbcommand(turnoff_Airplane);
	}

	//public static void scrollListView(String direction, String value) throws InterruptedException {
	public static void scrollListView(String value) throws InterruptedException {
/*      SwipeElementDirection dir;

      if (direction.toUpperCase().equals("DOWN")) { dir = SwipeElementDirection.DOWN; }
      else { dir = SwipeElementDirection.UP;}*/


      boolean searchElement = true;
      String lastTxtElement = null;
      String previousTxtElement;
      List<MobileElement> elements;

      while(searchElement)
      {
          previousTxtElement = (lastTxtElement != null) ? lastTxtElement : "unset";

          elements = driver.findElementsById("com.ifsworld.mworkorderapps9:id/work_order__wo_no");
          lastTxtElement = elements.get(elements.size() - 1).getText();

          //compare element's text between last index of previous swipe and last index of current swipe to detect end of scrolling
          if (lastTxtElement.equals(previousTxtElement)){
              throw new NoSuchElementException("stopperElement not found");
          }

          try
          {
              //stop when desired element is displayed
        	  Utils.log("entered try loop");
              //driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + value + "\")")).isDisplayed();
        	  driver.findElementByXPath(value);
              searchElement = false;
          }
          catch (Exception e)
          {
              //swipe up|down when desired element is not displayed
        	  Utils.log("entered exception loop");
              //driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.widget.ListView\")")).swipe(dir, 1700);
        	  MobileElement element1 = driver.findElementByXPath("//android.widget.LinearLayout/android.widget.FrameLayout");
            // driver.findElementByXPath("//android.widget.LinearLayout/android.widget.FrameLayout").swipe(SwipeElementDirection.DOWN, 2000);
        	  swipingVertical(element1);
        	 
          }
      }
	}

	public static void scrolltoText(MobileElement element_to_verify) throws InterruptedException {
		for (int i = 0; i < 4; i++) {
			boolean searchElement = true;
			if (searchElement) {
				try {
					// stop when desired element is displayed
					Utils.log("entered try loop");
					// driver.findElement(MobileBy.AndroidUIAutomator("new
					// UiSelector().text(\"" + value + "\")")).isDisplayed();
					isElementPresent(element_to_verify);
					assert element_to_verify.isDisplayed();
					searchElement = false;
					break;
				} catch (Exception e) {
					// swipe up|down when desired element is not displayed
					Utils.log("entered exception loop");
					// driver.findElement(MobileBy.AndroidUIAutomator("new
					// UiSelector().className(\"android.widget.ListView\")")).swipe(dir,
					// 1700);
					MobileElement element1 = driver
							.findElementByXPath("//android.widget.LinearLayout/android.widget.FrameLayout");
					// driver.findElementByXPath("//android.widget.LinearLayout/android.widget.FrameLayout").swipe(SwipeElementDirection.DOWN,
					// 2000);
					swipingVertical(element1);

				}
			}
		}
	}

}
