package mwo.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.PageFactory;
import com.appium.base.BasePageObjects;
import com.appium.base.PageBase;
import com.appium.base.Utils;
import com.relevantcodes.extentreports.LogStatus;
import com.appium.reports.ExtentTestManager;
import mwo.pageobjects.CustomerSignaturePageObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CustomerSignaturePage extends PageBase {
	CustomerSignaturePageObjects customerSignaturePageObjects = new CustomerSignaturePageObjects();

	public CustomerSignaturePage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), customerSignaturePageObjects);
	}

	// verify the Customer signature screen UI
	public void CustomerSignScreenUIVerification() {
		waitForPageToLoad(driver, customerSignaturePageObjects.CANVAS_SIGN_PAD_TITLE);
		Utils.captureInterimScreenshot(driver);
		assert customerSignaturePageObjects.CUSTOMER_SIGNATURE_TITLE.isDisplayed();
		assert customerSignaturePageObjects.SIGNED_BY_LABEL.isDisplayed();
		assert customerSignaturePageObjects.SIGN_BY_TEXT_FIELD.isDisplayed();
		assert customerSignaturePageObjects.CANVAS_SIGN_PAD_TITLE.isDisplayed();
		assert customerSignaturePageObjects.CLEAR_SIGN_ICON.isDisplayed();
		// assert customerSignaturePageObjects.SIGNATURE_AREA.isDisplayed();
		// assert customerSignaturePageObjects.SCREEN_HEADER.isDisplayed();
	}

	// Navigate to My signature screen
	public MySignaturePage navigateToSelfSignScreen() {
		if (isElementPresent(BasePageObjects.NEXT_BUTTON)) {
			BasePageObjects.NEXT_BUTTON.click();
			ExtentTestManager.getTest().log(LogStatus.PASS,
					"CustomerSignature Page > My Signature Screen is displayed on click of Next button");
		} else {
			Utils.log("NEXT Button is not displayed in Customer Signature screen");
			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"CustomerSignature Page > NEXT Button is not displayed in Customer Signature screen");
		}
		return new MySignaturePage(driver);
	}

	// Enter the customer name and collect the digital signature from the
	// customer
	public void enterSignature(String username) {
		waitForPageToLoad(driver, customerSignaturePageObjects.SIGN_BY_TEXT_FIELD);
		if (isElementPresent(customerSignaturePageObjects.SIGN_BY_TEXT_FIELD)) {
			//CustomerSignScreenUIVerification();
			String signature = customerSignaturePageObjects.SIGN_BY_TEXT_FIELD.getText();
			if (signature.equals("Required")) {
				customerSignaturePageObjects.SIGN_BY_TEXT_FIELD.click();
				enterTextUsingadb(username);
				hideKeyboardBasedOnPlatform();
				drawSignOntheCanvas(customerSignaturePageObjects.SIGNATURE_AREA);
				ExtentTestManager.getTest().log(LogStatus.PASS,
						"CustomerSignature Page > Customer Signature is entered");
			}
		} else {
			Utils.log("Customer signature screen is not displayed");
			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"CustomerSignature Page > Entering Customer Signature is failed");
		}
	}
}
