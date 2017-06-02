package mwo.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.PageFactory;

import com.appium.base.BasePageObjects;
import com.appium.base.PageBase;
import com.appium.base.Utils;
import com.relevantcodes.extentreports.LogStatus;
import com.appium.reports.ExtentTestManager;

import mwo.pageobjects.WOExpensesPageObjects;
import mwo.pageobjects.WOPreviewPageObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WOExpensesPage extends PageBase {

	WOExpensesPageObjects expensePageObjects = new WOExpensesPageObjects();

	public WOExpensesPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), expensePageObjects);
	}

	// Verify the Expenses screen UI
	public void ExpensesScreenVerification() {
		waitForPageToLoad(driver, expensePageObjects.EXPENSES_SCREEN_TITLE);
		Utils.captureInterimScreenshot(driver);
		assert expensePageObjects.COST_FIELD.isDisplayed();
		assert expensePageObjects.COST_LABEL.isDisplayed();
		assert expensePageObjects.QUANTITY_FIELD.isDisplayed();
		assert expensePageObjects.QUANTITY_LABEL.isDisplayed();
		assert expensePageObjects.SALES_PART_FIELD.isDisplayed();
		assert expensePageObjects.SALES_PART_LABEL.isDisplayed();
		assert expensePageObjects.COMMENT_FIELD.isDisplayed();
		assert expensePageObjects.COMMENT_LABEL.isDisplayed();

	}

	// Enter Expenses Details
	public CommentPage EnterExpenseDetails(String quantity, String cost) {
		hideKeyboardBasedOnPlatform();
	    ExpensesScreenVerification();
		expensePageObjects.QUANTITY_FIELD.click();
		enterTextUsingadb(String.valueOf(quantity));
		hideKeyboardBasedOnPlatform();
		expensePageObjects.COST_FIELD.click();
		enterTextUsingadb(String.valueOf(cost));
		hideKeyboardBasedOnPlatform();
		expensePageObjects.COMMENT_FIELD.click();
		return new CommentPage(driver);
	}

	public void SaveExpenseDetails() {
		int prevalue = Integer.parseInt(BasePageObjects.PREVIOUS_BUTTON.getText().replaceAll("[^0-9]", "").trim());

		hideKeyboardBasedOnPlatform();
		assert BasePageObjects.NEXT_BUTTON.isDisplayed();
		assert BasePageObjects.ADD_BUTTON.isDisplayed();
		BasePageObjects.ADD_BUTTON.click();

		int newvalue = Integer.parseInt(BasePageObjects.PREVIOUS_BUTTON.getText().replaceAll("[^0-9]", "").trim());

		if (newvalue > prevalue) {
			ExtentTestManager.getTest().log(LogStatus.PASS,
					"Expence details saved successfully in Expenses screen");
		} else {
			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"Expence details not saved  in Expenses screen");

		}

	}

	public WOActionsPage navigateBackToActionPage() {
		goBack();
		threadSleep(3000);
		return new WOActionsPage(driver);
	}

}