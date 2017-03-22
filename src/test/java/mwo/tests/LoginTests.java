package mwo.tests;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;
import com.appium.testng.TestBase;
import mwo.apiresponses.PLSQLQueries;
import mwo.pages.AdditionalDetailsPage;
import mwo.pages.CustomerSignaturePage;
import mwo.pages.HomePage;
import mwo.pages.LoginPage;
import mwo.pages.MaterialListPage;
import mwo.pages.MaterialsPage;
import mwo.pages.MySignaturePage;
import mwo.pages.OnHoldPage;
import mwo.pages.ReportWebViewPage;
import mwo.pages.ReturnsPage;
import mwo.pages.SelectPartPage;
import mwo.pages.SuspendPage;
import mwo.pages.SyncMonitorPage;
import mwo.pages.WOActionsPage;
import mwo.pages.WOPreviewPage;
import mwo.pages.WOReportInPage;
import mwo.pages.WorkOrdersPage;
import mwo.apiresponses.PLSQLQueries;


import com.appium.base.JSonParser;
import com.appium.base.PageBase;
import com.appium.base.Utils;


public class LoginTests extends TestBase {

  LoginPage loginPage;
  SyncMonitorPage syncPage;
  HomePage homePage;
  WorkOrdersPage woPage;
  WOPreviewPage previewPage;
  WOActionsPage actionsPage;
  SelectPartPage selectPartPage;
  MaterialsPage materialsPage;
  MaterialListPage materialListPage;
  ReturnsPage returnsPage;
  WOReportInPage reportInPage;
  ReportWebViewPage reportWebViewPage;
  CustomerSignaturePage	customerSignaturePage;
  MySignaturePage mySignaturePage;
  AdditionalDetailsPage additionalDetailsPage;
  SuspendPage wo_suspendPage;
  OnHoldPage wo_onholdPage;
  
  public LoginTests() throws Exception {

  }

  @Test(groups = {"Final.Regression.Android", "Final.Regression.iOS"}, priority=2)
 //@Test(groups = {"Testing"}, priority=2)
  public void returnWorkOrder() throws Exception {
	final String order_number = PLSQLQueries.createWorkOrder();
	Utils.log("WO created using PLSQL" + order_number);
	JSONArray cred = JSonParser.getCredentials("Credentials");
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
    previewPage = woPage.searchForWorkOrder(order_number);
    previewPage.acceptWorkOrder();
    previewPage.changeStatustoOnRoute();
    previewPage.changeStatustoOnSite();
    actionsPage = previewPage.launchWOActionsScreen();
    materialsPage = actionsPage.launchMaterialsScreen();
    selectPartPage = materialsPage.launchPartsFromMyStock();
	JSONArray part = JSonParser.getCredentials("Part_details");
	JSONObject part_info =  part.getJSONObject(0);
    materialsPage = selectPartPage.issueParts(part_info.getString("part_description"), part_info.getString("lot_batch_number"), part_info.getString("serial_number"));
    materialListPage = materialsPage.launchMaterialListPage();
    returnsPage = materialListPage.launchReturnsScreen();
    selectPartPage = returnsPage.selectPartToReturn();
    returnsPage = selectPartPage.returnParts(part_info.getString("part_description"), part_info.getString("lot_batch_number"), part_info.getString("serial_number"));
    actionsPage = returnsPage.confirmItemReturn();
    reportInPage = actionsPage.navigatetoReportInScreen();
    reportWebViewPage = reportInPage.navigateToWOReportScreen();
    customerSignaturePage = reportWebViewPage.navigateToCustomerSignatureScreen();
    customerSignaturePage.enterSignature(obj.getString("username"));
    mySignaturePage = customerSignaturePage.navigateToSelfSignScreen();
    reportWebViewPage = mySignaturePage.collectSelfSignature();
    woPage = reportWebViewPage.completeWorkOrder();
    homePage = woPage.navigateBackToHomeScreen();
    //syncPage = homePage.initiateManualSync();
    //syncPage.syncVerification();
  }
  
  
  @Test(groups = {"Final.Regression.Android", "Final.Regression.iOS"}, priority=1)  
  public void inValidLoginTest() throws Exception {
	JSONArray cred = JSonParser.getCredentials("Credentials");
	//JSONObject obj = new JSONObject(cred.toString());
	JSONObject obj =  cred.getJSONObject(1);
    loginPage = new LoginPage(driver);
    System.out.println("launched mwo application");
    loginPage.AppLaunchVerification();
    loginPage.invalidLoginVerification(obj.getString("username"), obj.getString("password"), obj.getString("serviceurl"), obj.getString("systemid"));
  }

  
  @Test(groups = {"Final.Regression.Android", "Final.Regression.iOS"}, priority=3) 
  public void launchInvalidWorkOrder() throws Exception {
	JSONArray cred = JSonParser.getCredentials("Credentials");
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
    //previewPage = woPage.launchWOScreen(obj.getString("order_number"));
    previewPage = woPage.searchForWorkOrder(obj.getString("wrong_order"));
  }
	
	//@Test(groups = { "Final.Regression.Android", "Final.Regression.iOS" }, priority = 2)
	@Test(groups = {"Testing"}, priority=2)
	public void suspendWorkOrder() throws Exception {
		final String order_number = "714";
		Utils.log("WO created using PLSQL" + order_number);
		JSONArray cred = JSonParser.getCredentials("Credentials");
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
	    previewPage = woPage.searchForWorkOrder(order_number);
	    //previewPage.acceptWorkOrder();
	    //previewPage.changeStatustoOnRoute();
	    //previewPage.changeStatustoOnSite();
	    wo_suspendPage = previewPage.changeStatusToSuspend();
	    previewPage = wo_suspendPage.suspendWorkOrder();
	    previewPage.rejectButtonVerificationPostSuspendWO();
	    wo_onholdPage = previewPage.changeWOStatusToReject();
	    previewPage = wo_onholdPage.rejectWorkOrder();
	}
	
	
	@Test(groups = { "Final.Regression.Android", "Final.Regression.iOS" }, priority = 2)
	//@Test(groups = {"Testing"}, priority=2)
	public void onHoldWorkOrder() throws Exception {
		final String order_number = "713";
		Utils.log("WO created using PLSQL" + order_number);
		JSONArray cred = JSonParser.getCredentials("Credentials");
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
	    previewPage = woPage.searchForWorkOrder(order_number);
	    previewPage.acceptWorkOrder();
	    previewPage.changeStatustoOnRoute();
	    previewPage.changeStatustoOnSite();
	    wo_onholdPage= previewPage.changeStatusToOnHold();
	    previewPage = wo_onholdPage.onHoldWO();
	    previewPage.buttonOffHoldVerification();
	}
}
