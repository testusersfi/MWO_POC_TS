package mwo.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.PageFactory;

import com.appium.base.BasePageObjects;
import com.appium.base.PageBase;
import com.appium.base.Utils;
import com.relevantcodes.extentreports.LogStatus;
import com.appium.reports.ExtentTestManager;
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
  
  // Verify the MWO Home screen UI
  public void homeScreenVerification() {
	  waitForPageToLoad(driver, homePageObjects.WORK_ORDERS_BUTTON);
	  Utils.captureInterimScreenshot(driver);
	  soft_assert.assertTrue(BasePageObjects.MORE_OPTIONS_ICON.isDisplayed(), "More Options icon is not shown");
	  soft_assert.assertTrue(homePageObjects.SYSTEM_MENU_HELP.isDisplayed());
	  soft_assert.assertTrue(homePageObjects.WORK_ORDERS_BUTTON.isDisplayed());
  } 
  
  //Navigate to Work Orders screen
  public WorkOrdersPage launchWorkOrders() {
	  if(homePageObjects.WORK_ORDERS_BUTTON.isEnabled()) {
		  assert homePageObjects.WORK_ORDERS_BUTTON.isDisplayed();
		  homeScreenVerification();
		  homePageObjects.WORK_ORDERS_BUTTON.click();
		  ExtentTestManager.getTest().log(LogStatus.PASS, "Work Orders exists with this account and Work Oders button is clicked");
	  } else {
		  ExtentTestManager.getTest().log(LogStatus.FAIL, "No workorders exists with this account");
	  }
	  return new WorkOrdersPage(driver);
  }
  
  // Initiate Manual sync from the Home screen
  public SyncMonitorPage initiateManualSyncFromHomeScreen() {
	  assert homePageObjects.SYNC_BUTTON.isDisplayed();
	  homePageObjects.SYNC_BUTTON.click();
	  return new SyncMonitorPage(driver);
  }
  
  /* public SyncMonitorPage initiateManualSync() {
	  assert homePageObjects.MORE_OPTIONS_ICON.isDisplayed();
	  homePageObjects.MORE_OPTIONS_ICON.click();
	  if(isElementPresent(homePageObjects.MENU_SYNC_BUTTON)) {
		  homePageObjects.MENU_SYNC_BUTTON.click();
		  return new SyncMonitorPage(driver);
	  } else
	  {
		  ExtentTestManager.getTest().log(LogStatus.FAIL, "Launching sync monitor from Menu list is failed");
	  }
	  return null;
  } */
  
	public static SyncMonitorPage initiateManualSync() {
		  assert BasePageObjects.MORE_OPTIONS_ICON.isDisplayed();
		  BasePageObjects.MORE_OPTIONS_ICON.click();
		  if(isElementPresent(BasePageObjects.MENU_SYNC_BUTTON)) {
			  BasePageObjects.MENU_SYNC_BUTTON.click();
			  return new SyncMonitorPage(driver);
		  } else
		  {
			  ExtentTestManager.getTest().log(LogStatus.FAIL, "Launching sync monitor from Menu list is failed");
		  }
		  return null;
	 }
	
  //Navigate to New work order screen
  public NewWOPage newWorkOrder() {
	  if(homePageObjects.NEW_WORK_ORDER_BUTTON.isEnabled()) {
		  assert homePageObjects.NEW_WORK_ORDER_BUTTON.isDisplayed();
		  homePageObjects.NEW_WORK_ORDER_BUTTON.click();
		  ExtentTestManager.getTest().log(LogStatus.PASS, "Create New Work Orders with this account and New Work Orders button is clicked");
	  } else {
		  ExtentTestManager.getTest().log(LogStatus.FAIL, "Cannot create new Work Order");
	  }
	return new NewWOPage(driver);	  
  }
  
  // Navigate to options menu -> Admin screen
  public AdminPage launchAdminScreen() {
	  if(isElementPresent(homePageObjects.ADMIN_BUTTON)) {
		  assert homePageObjects.ADMIN_BUTTON.isDisplayed();
		  homePageObjects.ADMIN_BUTTON.click();
		  ExtentTestManager.getTest().log(LogStatus.PASS, "Admin button is present and button is clicked");
		  return new AdminPage(driver);
	  } else {
		  ExtentTestManager.getTest().log(LogStatus.FAIL, "Admin button is not visible in the home screen");
	  }
	  return null;
  }
  
  // Enable air plane mode
  public void switchOffInternet() {
	  turnOnAirPlaneMode();
  }
  
  // Disable air plane mode
  public void switchOnInternet() {
	  turnOffAirplaneMode();
	  threadSleep(10000);
  }
  
  // Navigate to Measures screen
  public WOMeasuresPage launchMeasuresScreen() {
	  if(homePageObjects.MEASURES_BUTTON.isEnabled()) {
		  assert homePageObjects.MEASURES_BUTTON.isDisplayed();
		  homePageObjects.MEASURES_BUTTON.click();
		  ExtentTestManager.getTest().log(LogStatus.PASS, "Measure button is present and button is clicked");
		  return new WOMeasuresPage(driver);
	  } else {
		  ExtentTestManager.getTest().log(LogStatus.FAIL, "Measure button is not visible in the home screen");
	  }
	  return null;
  }
}
