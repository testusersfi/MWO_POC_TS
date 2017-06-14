package mwo.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.appium.base.BasePageObjects;
import com.appium.base.PageBase;
import com.appium.base.Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import mwo.pageobjects.WOCommentObjects;

public class CommentPage extends PageBase {

	WOCommentObjects commentsObjects = new WOCommentObjects();

	public CommentPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), commentsObjects);
	}

	// Verify the Expenses screen UI
	public void CommentScreenVerification() {
		waitForPageToLoad(driver, commentsObjects.SCREEN_HEADER);
		assert commentsObjects.COMMENT_FIELD.isDisplayed();
	}

	public WOExpensesPage SaveComments(String comments) {
		hideKeyboardBasedOnPlatform();
		CommentScreenVerification();

		enterTextUsingadb(String.valueOf(comments));
		hideKeyboardBasedOnPlatform();
		Utils.captureInterimScreenshot(driver);
		assert BasePageObjects.OK_BUTTON.isDisplayed();
		assert BasePageObjects.CANCEL_BUTTON.isDisplayed();
		BasePageObjects.OK_BUTTON.click();
		return new WOExpensesPage(driver);

	}

}
