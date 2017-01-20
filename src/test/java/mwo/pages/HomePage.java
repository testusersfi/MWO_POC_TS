package mwo.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import com.appium.base.PageBase;
import com.appium.base.Utils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import com.report.factory.ExtentTestManager;

import mwo.pageobjects.HomePageObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage extends PageBase {
 HomePageObjects homePageObjects = new HomePageObjects();

  public HomePage(AppiumDriver<MobileElement> driver) {
    super(driver);
    PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS),
    		homePageObjects);
  }

  public void homeScreenVerification() {
	  waitForPageToLoad(driver, homePageObjects.SCREEN_HEADER);
	  Utils.captureInterimScreenshot(driver);
	  //assert homePageObjects.MORE_OPTIONS_ICON.isDisplayed();
	  assert homePageObjects.SYSTEM_MENU_HELP.isDisplayed();
	  assert homePageObjects.WORK_ORDERS_BUTTON.isDisplayed();
  } 

  public WorkOrdersPage launchWorkOrders() {
	  if(homePageObjects.WORK_ORDERS_BUTTON.isEnabled()) {
		  assert homePageObjects.WORK_ORDERS_BUTTON.isDisplayed();
		  homePageObjects.WORK_ORDERS_BUTTON.click();
	  } else {
		  ExtentTestManager.getTest().log(LogStatus.FAIL, "No workorders exists with this account");
	  }
	  return new WorkOrdersPage(driver);
  }
}
