package mwo.tests;

import java.util.Map;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;
import com.appium.testng.TestBase;
import com.relevantcodes.extentreports.LogStatus;

import mwo.apiresponses.PLSQLQueries;
import mwo.pageobjects.AdminPageObjects;
import mwo.pages.AdditionalDetailsPage;
import mwo.pages.AdminPage;
import mwo.pages.CommentPage;
import mwo.pages.ContactDetailsPage;
import mwo.pages.CustomerAndObjectDetailsPage;
import mwo.pages.CustomerSignaturePage;
import mwo.pages.HomePage;
import mwo.pages.LoginPage;
import mwo.pages.MaterialListPage;
import mwo.pages.MaterialsPage;
import mwo.pages.MySignaturePage;
import mwo.pages.NewWOPage;
import mwo.pages.ObjectDetailsPage;
import mwo.pages.OnHoldPage;
import mwo.pages.ReportWebViewPage;
import mwo.pages.ReturnsPage;
import mwo.pages.SelectAnObjectPage;
import mwo.pages.SelectMaintainanceOrgPage;
import mwo.pages.SelectPartPage;
import mwo.pages.SuspendPage;
import mwo.pages.SyncMonitorPage;
import mwo.pages.WOActionsPage;
import mwo.pages.WODatesPage;
import mwo.pages.WODesignerPage;
import mwo.pages.WOExpensesPage;
import mwo.pages.WOMeasuresPage;
import mwo.pages.WOMenuPage;
import mwo.pages.WOOperationPage;
import mwo.pages.WOPreviewPage;
import mwo.pages.WOReportInPage;
import mwo.pages.WOTimeReportPage;
import mwo.pages.WorkOrdersPage;
import com.appium.base.JSonParser;
import com.appium.base.PageBase;
import com.appium.base.Utils;
import com.appium.reports.ExtentTestManager;
//import mwo.apiresponses.PLSQLQueries;

public class SyncTests extends TestBase {


	NewWOPage newWOPage;
	CustomerAndObjectDetailsPage coDetailsPage;
	PageBase basePage;
	SelectAnObjectPage selectObjectPage;
	WODatesPage woDatesPage;
	AdminPage adminPage;
	AdminPageObjects adminPageObjects;
	SelectMaintainanceOrgPage maintOrgPage;
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
	CustomerSignaturePage customerSignaturePage;
	MySignaturePage mySignaturePage;
	AdditionalDetailsPage additionalDetailsPage;
	SuspendPage wo_suspendPage;
	OnHoldPage wo_onholdPage;
	ObjectDetailsPage objectPage;
	ContactDetailsPage contactPage;
	WOTimeReportPage timeReportPage;
	WOExpensesPage expensesPage;
	CommentPage commentPage;
	WOOperationPage operationSelectionPage;
	WODesignerPage designerPage;
	WOMenuPage menupage;
	WOMeasuresPage measuresPage;

	public SyncTests() throws Exception {

	}

	@Test(groups = {"Final.Regression.Android"}, priority = 1)
	// @Test(groups = { "Testing" }, priority = 1)
	public void offlineToOnlineSyncVerification() throws Exception {
		Map<String, Object[]> data = new TreeMap<String, Object[]>();
		data.put("1", new Object[] { "S.NO", "WO_NUMBER", "DIRECTIVE_TEXT" });
		JSONArray cred = JSonParser.getCredentials("Credentials");
		JSONObject obj = cred.getJSONObject(0);
		loginPage = new LoginPage(driver);
		System.out.println("launched mwo application");
		loginPage.AppLaunchVerification();
		loginPage.validLoginFunctionality(obj.getString("username"), obj.getString("password"),
				obj.getString("serviceurl"), obj.getString("systemid"));
		syncPage = new SyncMonitorPage(driver);
		syncPage.syncMonitorScreenVerification();
		homePage = syncPage.syncVerification();
		adminPage = homePage.launchAdminScreen();
		adminPage.syncIntervalConfiguration("1 Hour");
		homePage = adminPage.navigateBackToHomeScreen();
		homePage.switchOffInternet();
		for (int i = 1; i <= 3; i++) {
			newWOPage = homePage.newWorkOrder();
			String wo_number = newWOPage.extractWONumber();
			ExtentTestManager.getTest().log(LogStatus.PASS, "System originating id: " + wo_number);
			String directive_text = "Automation_Test_WO" + Utils.getCurrentDateAndTime();
			coDetailsPage = newWOPage.enterDirectiveDescription(directive_text);
			selectObjectPage = coDetailsPage.launchSelectObjectScreen();
			coDetailsPage = selectObjectPage.selectObjectID();
			woDatesPage = coDetailsPage.navigateToWODatesScreen();
			homePage = woDatesPage.prepareWorkOrder();
			data.put("1" + i, new Object[] { String.valueOf(i), wo_number, directive_text });
		}
		new Utils().writeDataToExcel("MWO_OFFLINE", data);
		homePage.switchOnInternet();
		syncPage = homePage.initiateManualSync();
		syncPage.syncWaitTime();
	}

	@Test(groups = { "Final.Regression.Android"}, priority = 2)
	//@Test(groups = { "Testing" }, priority = 2)
	public void syncInterruption() throws Exception {
		// Load the Test Data
		Map<String, Object[]> data = new TreeMap<String, Object[]>();
		data.put("1", new Object[] { "S.NO", "WO_NUMBER", "DIRECTIVE_TEXT" });
		JSONArray cred = JSonParser.getCredentials("Credentials");
		JSONObject obj = cred.getJSONObject(0);
		// Login to the mwo app
		loginPage = new LoginPage(driver);
		System.out.println("launched mwo application");
		loginPage.AppLaunchVerification();
		loginPage.validLoginFunctionality(obj.getString("username"), obj.getString("password"), obj.getString("serviceurl"), obj.getString("systemid"));
		syncPage = new SyncMonitorPage(driver);
		syncPage.syncMonitorScreenVerification();
		homePage = syncPage.syncVerification();
		// Disable the Internet, since sync will be initiated on every Save
		homePage.switchOffInternet();
		// Create multiple work orders
		for (int i = 1; i <= 25; i++) {
			newWOPage = homePage.newWorkOrder();
			String wo_number = newWOPage.extractWONumber();
			ExtentTestManager.getTest().log(LogStatus.PASS, "System originating id: " + wo_number);
			String directive_text = "Automation_Test_WO" + Utils.getCurrentDateAndTime();
			maintOrgPage = newWOPage.launchMaintainanceOrgScreen();
			newWOPage = maintOrgPage.selectMaintOrg();
			coDetailsPage = newWOPage.enterDirectiveDescription(directive_text);
			selectObjectPage = coDetailsPage.launchSelectObjectScreen();
			coDetailsPage = selectObjectPage.selectObjectID();
			woDatesPage = coDetailsPage.navigateToWODatesScreen();
			homePage = woDatesPage.prepareWorkOrder();
			data.put("1" + i, new Object[] { String.valueOf(i), wo_number, directive_text });
		}
		new Utils().writeDataToExcel("MWO_SyncInterruption", data);
		// Switch on the Internet and initiate Manual Sync
		homePage.switchOnInternet();
		syncPage.syncWaitTime();
		syncPage = homePage.initiateManualSync();
		// Interrupt Sync by disabling Internet and failure verification
		homePage.switchOffInternet();
		syncPage.syncFailureVerification();
		homePage = syncPage.navigateBacktoHomePage();
		// Switch on the Internet and initiate sync
		homePage.switchOnInternet();
		syncPage.syncWaitTime();
		syncPage = homePage.initiateManualSync();
		syncPage.syncCompletedVerification();

	}

	@Test(groups = { "Final.Regression.Android" }, priority = 4)
	// @Test(groups = { "Testing" }, priority = 3)
	public void searchForInvalidWO() throws Exception {
		JSONArray cred = JSonParser.getCredentials("Credentials");
		JSONObject obj = cred.getJSONObject(0);
		loginPage = new LoginPage(driver);
		System.out.println("launched mwo application");
		loginPage.AppLaunchVerification();
		loginPage.validLoginFunctionality(obj.getString("username"), obj.getString("password"),
				obj.getString("serviceurl"), obj.getString("systemid"));
		syncPage = new SyncMonitorPage(driver);
		syncPage.syncMonitorScreenVerification();
		homePage = syncPage.syncVerification();
		homePage.homeScreenVerification();
		woPage = homePage.launchWorkOrders();
		previewPage = woPage.searchForWorkOrder(obj.getString("wrong_order"));
	}

	@Test(groups = { "Final.Regression.Android" }, priority = 5)
	// @Test(groups = { "Testing" }, priority = 2)
	public void suspendWorkOrder() throws Exception {
		final String order_number = PLSQLQueries.createWorkOrder();
		Utils.log("WO created using PLSQL" + order_number);
		JSONArray cred = JSonParser.getCredentials("Credentials");
		JSONObject obj = cred.getJSONObject(0);
		loginPage = new LoginPage(driver);
		System.out.println("launched mwo application");
		loginPage.AppLaunchVerification();
		loginPage.validLoginFunctionality(obj.getString("username"), obj.getString("password"),
				obj.getString("serviceurl"), obj.getString("systemid"));
		syncPage = new SyncMonitorPage(driver);
		syncPage.syncMonitorScreenVerification();
		homePage = syncPage.syncVerification();
		homePage.homeScreenVerification();
		woPage = homePage.launchWorkOrders();
		previewPage = woPage.searchForWorkOrder(order_number);
		previewPage.acceptWorkOrder();
		previewPage.changeStatustoOnRoute();
		previewPage.changeStatustoOnSite();
		wo_suspendPage = previewPage.changeStatusToSuspend();
		previewPage = wo_suspendPage.suspendWorkOrder();
		previewPage.rejectButtonVerificationPostSuspendWO();
		wo_onholdPage = previewPage.changeWOStatusToReject();
		previewPage = wo_onholdPage.rejectWorkOrder(obj.getString("reject_reason_code"));
	}

	@Test(groups = { "Final.Regression.Android" }, priority = 3)
	// @Test(groups = { "Testing" }, priority = 3)
	public void onHoldWorkOrder() throws Exception {
		final String order_number = PLSQLQueries.createWorkOrder();
		Utils.log("WO created using PLSQL" + order_number);
		JSONArray cred = JSonParser.getCredentials("Credentials");
		JSONObject obj = cred.getJSONObject(0);
		loginPage = new LoginPage(driver);
		System.out.println("launched mwo application");
		loginPage.AppLaunchVerification();
		loginPage.validLoginFunctionality(obj.getString("username"), obj.getString("password"),
				obj.getString("serviceurl"), obj.getString("systemid"));
		syncPage = new SyncMonitorPage(driver);
		syncPage.syncMonitorScreenVerification();
		homePage = syncPage.syncVerification();
		homePage.homeScreenVerification();
		woPage = homePage.launchWorkOrders();
		previewPage = woPage.searchForWorkOrder(order_number);
		previewPage.acceptWorkOrder();
		previewPage.changeStatustoOnRoute();
		previewPage.changeStatustoOnSite();
		wo_onholdPage = previewPage.changeStatusToOnHold();
		previewPage = wo_onholdPage.onHoldWO(obj.getString("onhold_reason_code"));
		previewPage.buttonOffHoldVerification();
	}

	@Test(groups = { "Final.Regression.Android" }, priority = 6)
	// @Test(groups = {"Testing"}, priority=6)
	public void updateContactDetails() throws Exception {
		final String order_number = PLSQLQueries.createWorkOrder();
		Utils.log("WO created using PLSQL" + order_number);
		JSONArray cred = JSonParser.getCredentials("Credentials");
		JSONObject obj = cred.getJSONObject(0);
		loginPage = new LoginPage(driver);
		System.out.println("launched mwo application");
		loginPage.AppLaunchVerification();
		loginPage.validLoginFunctionality(obj.getString("username"), obj.getString("password"),
				obj.getString("serviceurl"), obj.getString("systemid"));
		syncPage = new SyncMonitorPage(driver);
		syncPage.syncMonitorScreenVerification();
		homePage = syncPage.syncVerification();
		homePage.homeScreenVerification();
		woPage = homePage.launchWorkOrders();
		previewPage = woPage.searchForWorkOrder(obj.getString("order_number"));
		previewPage = woPage.searchForWorkOrder(order_number);
		previewPage.acceptWorkOrder();
		additionalDetailsPage = previewPage.launchAdditionalDetailsScreen();
		additionalDetailsPage.additionalDetailsUIVerification();
		JSONArray wo_details = JSonParser.getCredentials("Update_WorkOrder");
		JSONObject contact_details = wo_details.getJSONObject(0);
		previewPage.contactDetailsVerification();
		contactPage = previewPage.launchContactDetailsScreen();
		contactPage.contactDetailsUIVerification();
		previewPage = contactPage.enterContactDetails(contact_details.getString("contact_name"),
				contact_details.getString("contact_number"));
		previewPage.objectDetailsVerfication();
		objectPage = previewPage.launchObjectDetailsScreen();
		objectPage.objectDetailsUIVerification();
		selectObjectPage = objectPage.launchObjectIDScreen();
		// objectPage = selectObjectPage.selectObject();
		objectPage.save();
		homePage = woPage.navigateBackToHomeScreen();
	}
}
