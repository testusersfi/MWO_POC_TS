package mwo.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.PageFactory;
import com.appium.base.PageBase;
import com.appium.base.Utils;
import com.relevantcodes.extentreports.LogStatus;
import com.appium.reports.ExtentTestManager;
import mwo.pageobjects.MySignaturePageObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MySignaturePage extends PageBase {
	MySignaturePageObjects mySignaturePageObjects = new MySignaturePageObjects();

	public MySignaturePage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), mySignaturePageObjects);
	}

	public void mySignatureScreenUIVerification() {
		waitForPageToLoad(driver, mySignaturePageObjects.MY_SIGNATURE_TITLE);
		Utils.captureInterimScreenshot(driver);
		// assert mySignaturePageObjects.SCREEN_HEADER.isDisplayed();
		assert mySignaturePageObjects.MY_SIGNATURE_TITLE.isDisplayed();
		assert mySignaturePageObjects.SIGNATURE_DESCRIPTION.isDisplayed();
		assert mySignaturePageObjects.DIRECTIVE_LABEL.isDisplayed();
		assert mySignaturePageObjects.DIRECTIVE_TEXT_FIELD.isDisplayed();
		assert mySignaturePageObjects.ACTUAL_START_LABEL.isDisplayed();
		assert mySignaturePageObjects.ACTUAL_START_TEXT_FIELD.isDisplayed();
		assert mySignaturePageObjects.CANVAS_SIGN_PAD_TITLE.isDisplayed();
		assert mySignaturePageObjects.CLEAR_SIGN_ICON.isDisplayed();
		assert mySignaturePageObjects.SIGNATURE_AREA.isDisplayed();
		assert mySignaturePageObjects.NEXT_BUTTON.isDisplayed();
	}

	public ReportWebViewPage collectSelfSignature() {
		mySignatureScreenUIVerification();
		drawSignOntheCanvas(mySignaturePageObjects.SIGNATURE_AREA);
		mySignaturePageObjects.NEXT_BUTTON.click();
		ExtentTestManager.getTest().log(LogStatus.PASS,
				"MySignature Page > Report web view Page is displayed on click of Next button");
		return new ReportWebViewPage(driver);
	}
}
