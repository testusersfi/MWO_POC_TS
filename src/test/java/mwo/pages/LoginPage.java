package mwo.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import com.appium.base.PageBase;
import com.appium.base.Utils;
import com.relevantcodes.extentreports.LogStatus;
import com.appium.reports.ExtentTestManager;

import mwo.pageobjects.LoginPageObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage extends PageBase {
	LoginPageObjects loginPageObjects = new LoginPageObjects();

	public LoginPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), loginPageObjects);
	}

	public void validLoginFunctionality(String Email, String Pwd, String Serviceurl, String Systemid)
			throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOf(loginPageObjects.ACTION_BAR_TITLE),
				ExpectedConditions.visibilityOf(loginPageObjects.LOGIN_ALERT_MESSAGE)));
		Utils.captureInterimScreenshot(driver);
		activationAlertDisplay(Email, Pwd);
		if (isElementPresent(loginPageObjects.LOGIN_SIGNIN_BUTTON)) {
			loginPageObjects.LOGIN_SIGNIN_BUTTON.click();
			Utils.log("Login Page > Log In Button is Clicked");
			if (isElementPresent(loginPageObjects.INVALID_LOGIN_ERROR)) {
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Login is failed with invalid credentials");
			} else {
				ExtentTestManager.getTest().log(LogStatus.PASS, "MWO Home screen is displayed");
			}
		} else if (isElementPresent(loginPageObjects.LOGIN_ACTIVATE_BUTTON)) {
			enterStringIntoTextField(Serviceurl, loginPageObjects.LOGIN_SERVICEURL_FIELD);
			enterStringIntoTextField(Systemid, loginPageObjects.LOGIN_SYSTEMID_FIELD);
			loginPageObjects.LOGIN_ACTIVATE_BUTTON.click();
			waitUntilElementsAreInvisible(loginPageObjects.ACTIVATING_MESSAGE);
			if (isElementPresent(loginPageObjects.INVALID_ACTIVATION_ERROR)) {
				assert loginPageObjects.INVALID_LOGIN_ERROR.isDisplayed();
				Utils.captureInterimScreenshot(driver);
				loginPageObjects.ALERT_OK_BUTTON.click();
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Login is failed");
			} else {
				waitForElementsVisible(driver, loginPageObjects.SYNC_INITIALIZING_MESSAGE);
				waitUntilElementsAreInvisible(loginPageObjects.SYNC_INITIALIZING_MESSAGE);
			}
		}

	}

	public void activationAlertDisplay(String Email, String Password) {
		if (isElementPresent(loginPageObjects.LOGIN_ALERT_MESSAGE)) {
			assert loginPageObjects.LOGIN_ALERT_TITLE.isDisplayed();
			assert loginPageObjects.ALERT_CONTINUE_BUTTON.isDisplayed();
			loginPageObjects.ALERT_CONTINUE_BUTTON.click();
		} else {
			Utils.log("IFS Activate alert message is not shown ");
		}
		enterStringIntoTextField(Email, loginPageObjects.LOGIN_USERID_FIELD);
		enterStringIntoTextField(Password, loginPageObjects.LOGIN_PASSWORD_FIELD);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void enterStringIntoTextField(String inputText, MobileElement element) {
		waitForPageToLoad(driver, element);
		element.clear();
		element.click();
		element.sendKeys(inputText);
		Utils.log("Login Page " + element + "Textfield is Clicked and entered");
		hideKeyboardBasedOnPlatform();
	}

	public void invalidLoginVerification(String Email, String Pwd, String Serviceurl, String Systemid)
			throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOf(loginPageObjects.ACTION_BAR_TITLE),
				ExpectedConditions.visibilityOf(loginPageObjects.LOGIN_ALERT_MESSAGE)));
		Utils.captureInterimScreenshot(driver);
		activationAlertDisplay(Email, Pwd);
		if (isElementPresent(loginPageObjects.LOGIN_SIGNIN_BUTTON)) {
			loginPageObjects.LOGIN_SIGNIN_BUTTON.click();
			Utils.log("Login Page > Log In Button is Clicked");
			if (isElementPresent(loginPageObjects.INVALID_LOGIN_ERROR)) {
				ExtentTestManager.getTest().log(LogStatus.PASS, "Login is failed with invalid credentials");
			} else {
				ExtentTestManager.getTest().log(LogStatus.FAIL, "app might be not responding");
			}
		} else if (isElementPresent(loginPageObjects.LOGIN_ACTIVATE_BUTTON)) {
			enterStringIntoTextField(Serviceurl, loginPageObjects.LOGIN_SERVICEURL_FIELD);
			enterStringIntoTextField(Systemid, loginPageObjects.LOGIN_SYSTEMID_FIELD);
			loginPageObjects.LOGIN_ACTIVATE_BUTTON.click();
			waitUntilElementsAreInvisible(loginPageObjects.ACTIVATING_MESSAGE);
			if (loginPageObjects.INVALID_ACTIVATION_ERROR.isDisplayed()) {
				assert loginPageObjects.INVALID_ACTIVATION_ERROR.isDisplayed();
				Utils.captureInterimScreenshot(driver);
				loginPageObjects.ALERT_OK_BUTTON.click();
				ExtentTestManager.getTest().log(LogStatus.PASS, "Login is failed with invalid credentials");
			} else {
				waitForElementsVisible(driver, loginPageObjects.SYNC_INITIALIZING_MESSAGE);
				waitUntilElementsAreInvisible(loginPageObjects.SYNC_INITIALIZING_MESSAGE);
			}
		}

	}

	public void AppLaunchVerification() {
		LoginPage loginPage = new LoginPage(driver);
		if (Utils.getDriverPlatform(driver).equals("AndroidDriver")) {
			Reporter.log("We are in Android, now checking for Alert messages...");
		} else if (Utils.getDriverPlatform(driver).equals("IOSDriver")) {
			Reporter.log("We are in IOS, now checking for Alert messages...");

		}
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOf(loginPageObjects.ACTION_BAR_TITLE),
				ExpectedConditions.visibilityOf(loginPageObjects.LOGIN_ALERT_MESSAGE)));
		Utils.log("mwo app Login screen displayed...");
	}

}
