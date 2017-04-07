package mwo.tests;

import java.util.Map;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;
import com.appium.testng.TestBase;
import com.relevantcodes.extentreports.LogStatus;
import mwo.pageobjects.AdminPageObjects;
import mwo.pages.AdminPage;
import mwo.pages.CustomerAndObjectDetailsPage;
import mwo.pages.HomePage;
import mwo.pages.LoginPage;
import mwo.pages.NewWOPage;
import mwo.pages.SelectAnObjectPage;
import mwo.pages.SelectMaintainanceOrgPage;
import mwo.pages.SyncMonitorPage;
import mwo.pages.WODatesPage;
import mwo.pages.WorkOrdersPage;
import com.appium.base.JSonParser;
import com.appium.base.PageBase;
import com.appium.base.Utils;
import com.appium.reports.ExtentTestManager;
//import mwo.apiresponses.PLSQLQueries;

public class SyncTests extends TestBase {

	LoginPage loginPage;
	SyncMonitorPage syncPage;
	HomePage homePage;
	NewWOPage newWOPage;
	WorkOrdersPage woPage;
	CustomerAndObjectDetailsPage coDetailsPage;
	PageBase basePage;
	SelectAnObjectPage selectObjectPage;
	WODatesPage woDatesPage;
	AdminPage adminPage;
	AdminPageObjects adminPageObjects;
	SelectMaintainanceOrgPage maintOrgPage;

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

}
