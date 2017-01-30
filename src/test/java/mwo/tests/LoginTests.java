package mwo.tests;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.appium.testng.TestBase;

import mwo.pages.AdditionalDetailsPage;
import mwo.pages.CustomerSignaturePage;
import mwo.pages.HomePage;
import mwo.pages.LoginPage;
import mwo.pages.MaterialListPage;
import mwo.pages.MaterialsPage;
import mwo.pages.MySignaturePage;
import mwo.pages.ReportWebViewPage;
import mwo.pages.ReturnsPage;
import mwo.pages.SelectPartPage;
import mwo.pages.SyncMonitorPage;
import mwo.pages.WOActionsPage;
import mwo.pages.WOPreviewPage;
import mwo.pages.WOReportInPage;
import mwo.pages.WorkOrdersPage;
import com.appium.base.AppiumSingleTest;

import com.appium.base.JSonParser;

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
  public LoginTests() throws Exception {

  }

  @Test(groups = {"Final.Regression.Android", "Final.Regression.iOS"}, priority=2)
  public void returnWorkOrder() throws Exception {
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
    //previewPage = woPage.launchWOScreen(obj.getString("order_number"));
    previewPage = woPage.searchForWorkOrder(obj.getString("order_number"));
    previewPage.acceptWorkOrder();
    //previewPage = additionalDetailsPage.changeDirectiveText();
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

}
