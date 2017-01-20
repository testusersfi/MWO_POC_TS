package mwo.tests;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;
import com.appium.testng.TestBase;

import mwo.pages.HomePage;
import mwo.pages.LoginPage;
import mwo.pages.SyncMonitorPage;
import mwo.pages.WOActionsPage;
import mwo.pages.WOPreviewPage;
import mwo.pages.WorkOrdersPage;

import com.appium.base.JSonParser;

public class LoginTests extends TestBase {

  LoginPage loginPage;
  SyncMonitorPage syncPage;
  HomePage homePage;
  WorkOrdersPage woPage;
  WOPreviewPage previewPage;
  WOActionsPage actionsPage;

  public LoginTests() throws Exception {

  }

  @Test(groups = {"Final.Regression.Android", "Final.Regression.iOS"})
  public void validLoginTest() throws Exception {
	JSONArray cred = JSonParser.getCredentials("Credentials");
	//JSONObject obj = new JSONObject(cred.toString());
	JSONObject obj =  cred.getJSONObject(0);
    loginPage = new LoginPage(driver);
    System.out.println("launched mwo application");
    loginPage.AppLaunchVerification();
    loginPage.validLoginFunctionality(obj.getString("username"), obj.getString("password"), obj.getString("serviceurl"), obj.getString("systemid"));
    syncPage = new SyncMonitorPage(driver);
    syncPage.syncMonitorScreenVerification();
    homePage = syncPage.syncVerification();
    homePage.homeScreenVerification();
    woPage = homePage.launchWorkOrders();
    previewPage = woPage.launchWOScreen();
    previewPage.launchWOActionsScreen();
    //actionsPage.launchTimeReportScreen();
  }
  
  
  @Test(groups = {"Test.Regression.Android", "Test.Regression.iOS"})
  public void inValidLoginTest() throws Exception {
	JSONArray cred = JSonParser.getCredentials("Credentials");
	//JSONObject obj = new JSONObject(cred.toString());
	JSONObject obj =  cred.getJSONObject(1);
    loginPage = new LoginPage(driver);
    System.out.println("launched mwo application");
    loginPage.AppLaunchVerification();
    loginPage.invalidLoginVerification(obj.getString("username"), obj.getString("password"), obj.getString("serviceurl"), obj.getString("systemid"));
  }


}
