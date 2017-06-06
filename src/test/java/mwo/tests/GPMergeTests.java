package mwo.tests;

import java.util.Map;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;
import com.appium.testng.TestBase;
import com.relevantcodes.extentreports.LogStatus;
//import mwo.apiresponses.PLSQLQueries;
import mwo.pages.AdditionalDetailsPage;
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
import mwo.pages.WOAddPicturePage;
import mwo.pages.WODatesPage;
import mwo.pages.WODesignerPage;
import mwo.pages.WOExpensesPage;
import mwo.pages.WOMeasuresPage;
import mwo.pages.WOMenuPage;
import mwo.pages.WOOperationPage;
import mwo.pages.WOPicturesPage;
import mwo.pages.WOPreviewPage;
import mwo.pages.WOReportInPage;
import mwo.pages.WOTimeReportPage;
import mwo.pages.WorkOrdersPage;
//import mwo.apiresponses.PLSQLQueries;
import com.appium.base.JSonParser;
import com.appium.base.Utils;
import com.appium.reports.ExtentTestManager;

/**
 * @author srinivas.bavirisetti
 *
 */
/**
 * @author srinivas.bavirisetti
 *
 */
public class GPMergeTests extends TestBase {

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
	SelectAnObjectPage selectObjectPage;
	WOTimeReportPage timeReportPage;
	WOExpensesPage expensesPage;
	CommentPage commentPage;
	WOOperationPage operationSelectionPage;
	WODesignerPage designerPage;
	WOMenuPage menupage;
	NewWOPage newWOPage;
	WOMeasuresPage measuresPage;
	SelectMaintainanceOrgPage maintOrgPage;
	WODatesPage woDatesPage;
	CustomerAndObjectDetailsPage coDetailsPage;
	WOPicturesPage picturesPage;
	WOAddPicturePage addPicturePage;

	JSONArray actions_data = JSonParser.getCredentials("WO_Action_Details");

	public GPMergeTests() throws Exception {

	}
	
	/* Following class is for validating the activation failure   */
	@Test(groups = { "Testing" }, priority = 1)
	public void activationFailureTest() throws Exception {
		JSONArray cred = JSonParser.getCredentials("Credentials");
		JSONObject obj = cred.getJSONObject(1);
		loginPage = new LoginPage(driver);
		System.out.println("launched mwo application");
		loginPage.AppLaunchVerification();
		loginPage.invalidLoginVerification(obj.getString("username"), obj.getString("password"),
				obj.getString("serviceurl"), obj.getString("systemid"));
	}

	/* Following class is for validating the user activation and issue material request  */
	@Test(groups = { "Final.Regression.Android" }, priority = 2)
	public void activateUserAndIssueMaterialRequest() throws Exception {
		// final String order_number = PLSQLQueries.createWorkOrder();
		// Utils.log("WO created using PLSQL" + order_number);
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
		previewPage.acceptWorkOrder();
		previewPage.changeStatustoOnRoute();
		previewPage.changeStatustoOnSite();
		actionsPage = previewPage.launchWOActionsScreen();
		materialsPage = actionsPage.launchMaterialsScreen();
		selectPartPage = materialsPage.launchPartsFromMyStock();
		JSONArray part = JSonParser.getCredentials("Part_details");
		JSONObject part_info = part.getJSONObject(0);
		materialsPage = selectPartPage.issueParts(part_info.getString("part_description"),
				part_info.getString("lot_batch_number"), part_info.getString("serial_number"));
		if(materialsPage !=null) {
		actionsPage = materialsPage.navigateBackToWOActionsScreen();
		actionsPage.woActionsScreenVerification();
		previewPage = actionsPage.navigateBackToPreviewPage();
		previewPage.previewScreenVerification();
		woPage = previewPage.navigateBackToWorkOrdersPage();
		woPage.WOListScreenHeaderUIVerification();
		homePage = woPage.navigateBackToHomeScreen();
		homePage.homeScreenVerification();
		syncPage = homePage.initiateManualSync();
		syncPage.syncCompletedVerification();
		}
		
	}

	/* Following class is for for adding expense claim to an existing WO and sync with EE */
	@Test(groups = { "Final.Regression.Android" }, priority = 3)
	public void addExpenseClaimToTheWO() throws Exception {
		JSONArray cred = JSonParser.getCredentials("Credentials");
		JSONObject obj = cred.getJSONObject(0);
		loginPage = new LoginPage(driver);
		System.out.println("launched mwo application");
		loginPage.AppLaunchVerification();
		loginPage.validLoginFunctionality(obj.getString("username"), obj.getString("password"),
				obj.getString("serviceurl"), obj.getString("systemid"));
		homePage = new HomePage(driver);
		homePage.homeScreenVerification();
		woPage = homePage.launchWorkOrders();
		previewPage = woPage.searchForWorkOrder(obj.getString("order_number"));
		actionsPage = previewPage.launchWOActionsScreen();
		JSONObject expense_info = actions_data.getJSONObject(0);
		expensesPage = actionsPage.searchForExpence(expense_info.getString("expense_action_name"));
		commentPage = expensesPage.EnterExpenseDetails(expense_info.getString("quantity"),
				expense_info.getString("cost"));
		expensesPage = commentPage.SaveComments(expense_info.getString("comments"));
		expensesPage.SaveExpenseDetails();
		actionsPage = expensesPage.navigateBackToActionPage();
		actionsPage.woActionsScreenVerification();
		previewPage = actionsPage.navigateBackToPreviewPage();
		previewPage.previewScreenVerification();
		woPage = previewPage.navigateBackToWorkOrdersPage();
		woPage.WOListScreenHeaderUIVerification();
		homePage = woPage.navigateBackToHomeScreen();
		homePage.homeScreenVerification();
		syncPage = homePage.initiateManualSync();
		syncPage.syncCompletedVerification();

	}

	/* Following class is for validating launch of UI designer and adding time report to an existing WO & sync with EE */
	@Test(groups = { "Final.Regression.Android" }, priority = 4)
	public void verifyUIDesignerAccessAndAddTimeReportToTheWO() throws Exception {
		JSONArray cred = JSonParser.getCredentials("Credentials");
		JSONObject obj = cred.getJSONObject(0);
		loginPage = new LoginPage(driver);
		System.out.println("launched mwo application");
		loginPage.AppLaunchVerification();
		loginPage.validLoginFunctionality(obj.getString("username"), obj.getString("password"),
				obj.getString("serviceurl"), obj.getString("systemid"));
		homePage = new HomePage(driver);
		homePage.homeScreenVerification();
		woPage = homePage.launchWorkOrders();
		previewPage = woPage.searchForWorkOrder(obj.getString("order_number"));
		menupage = previewPage.launchWOAMenuScreen();
		designerPage = menupage.launchWODesignerScreen();
		designerPage.UIDesignerScreenVerification();
		previewPage = designerPage.navigateBackToPreviewScreen();
		actionsPage = previewPage.launchWOActionsScreen();
		JSONObject timereport_info = actions_data.getJSONObject(0);
		timeReportPage = actionsPage.searchForTimeReport(timereport_info.getString("timereport_action_name"));
		timeReportPage.enterEmployeeName(obj.getString("username"));
		operationSelectionPage = timeReportPage.EnterTimeReportDetails(timereport_info.getString("cost"));

		if (operationSelectionPage == null)
			timeReportPage.SaveTimeReport();

		else {
			timeReportPage = operationSelectionPage.SelectOperation();
			timeReportPage.EnterQuantity(timereport_info.getString("cost"));
			timeReportPage.SaveTimeReport();

		}
		actionsPage = timeReportPage.navigateBackToActionPage();
		previewPage = actionsPage.navigateBackToPreviewPage();
		previewPage.previewScreenVerification();
		woPage = previewPage.navigateBackToWorkOrdersPage();
		woPage.WOListScreenHeaderUIVerification();
		homePage = woPage.navigateBackToHomeScreen();
		homePage.homeScreenVerification();
		//Thread.sleep(2000);
		syncPage = homePage.initiateManualSync();
		syncPage.syncCompletedVerification();
	}

	/* Following class is for adding captured image an existing WO & sync with EE */
	@Test(groups = { "Final.Regression.Android" }, priority = 5)
	public void addPictureToTheWO() throws Exception {
		JSONArray cred = JSonParser.getCredentials("Credentials");
		JSONObject obj = cred.getJSONObject(0);
		loginPage = new LoginPage(driver);
		System.out.println("launched mwo application");
		loginPage.AppLaunchVerification();
		loginPage.validLoginFunctionality(obj.getString("username"), obj.getString("password"),
				obj.getString("serviceurl"), obj.getString("systemid"));
		homePage = new HomePage(driver);
		homePage.homeScreenVerification();
		woPage = homePage.launchWorkOrders();
		previewPage = woPage.searchForWorkOrder(obj.getString("order_number"));
		actionsPage = previewPage.launchWOActionsScreen();
		JSONObject addPicture = actions_data.getJSONObject(0);
		picturesPage = actionsPage.searchForPictures(addPicture.getString("pictures_action_name"));
		addPicturePage = picturesPage.navigateToAddPictureScreen();
		addPicturePage.addImageToWO();
		picturesPage = addPicturePage.navigateBackToPicturesScreen();
		picturesPage.picturesScreenUIVerification();
		actionsPage = picturesPage.navigateBackToActionsScreen();
		actionsPage.woActionsScreenVerification();
		previewPage = actionsPage.navigateBackToPreviewPage();
		previewPage.previewScreenVerification();
		woPage = previewPage.navigateBackToWorkOrdersPage();
		woPage.WOListScreenHeaderUIVerification();
		homePage = woPage.navigateBackToHomeScreen();
		homePage.homeScreenVerification();
		syncPage = homePage.initiateManualSync();
		syncPage.syncCompletedVerification();
	}

	/* Following class is for complete the Work Order & sync with EE */
	@Test(groups = { "Final.Regression.Android" }, priority = 6)
	public void completeWorkOrder() throws Exception {
		JSONArray cred = JSonParser.getCredentials("Credentials");
		JSONObject obj = cred.getJSONObject(0);
		loginPage = new LoginPage(driver);
		System.out.println("launched mwo application");
		loginPage.AppLaunchVerification();
		loginPage.validLoginFunctionality(obj.getString("username"), obj.getString("password"),
				obj.getString("serviceurl"), obj.getString("systemid"));
		homePage = new HomePage(driver);
		homePage.homeScreenVerification();
		woPage = homePage.launchWorkOrders();
		previewPage = woPage.searchForWorkOrder(obj.getString("order_number"));
		previewPage.acceptWorkOrder();
		previewPage.changeStatustoOnRoute();
		previewPage.changeStatustoOnSite();
		actionsPage = previewPage.launchWOActionsScreen();
		reportInPage = actionsPage.navigatetoReportInScreen();
		reportWebViewPage = reportInPage.navigateToWOReportScreen();
		customerSignaturePage = reportWebViewPage.navigateToCustomerSignatureScreen();
		customerSignaturePage.enterSignature(obj.getString("username"));
		mySignaturePage = customerSignaturePage.navigateToSelfSignScreen();
		reportWebViewPage = mySignaturePage.collectSelfSignature();
		woPage = reportWebViewPage.completeWorkOrder();
		homePage = woPage.navigateBackToHomeScreen();
		syncPage = homePage.initiateManualSync();
		syncPage.syncCompletedVerification();
	}

	/* Following class is to validate the Objects measurements Client to EE */ 
	@Test(groups = { "Final.Regression.Android" }, priority = 7)
	public void ObjectMeasurementsClientToEE() throws Exception {
		JSONArray cred = JSonParser.getCredentials("Credentials");
		JSONObject obj = cred.getJSONObject(0);
		loginPage = new LoginPage(driver);
		loginPage.AppLaunchVerification();
		loginPage.validLoginFunctionality(obj.getString("username"), obj.getString("password"),
				obj.getString("serviceurl"), obj.getString("systemid"));
		homePage = new HomePage(driver);
		homePage.homeScreenVerification();
		measuresPage = homePage.launchMeasuresScreen();
		measuresPage.SearchforObjects("10");
		homePage = measuresPage.navigateBackToHomePage();
		syncPage = homePage.initiateManualSync();
		syncPage.syncCompletedVerification();
	}

	/* Following class is to create new work orders from client and Sync with EE */ 
	@Test(groups = { "Final.Regression.Android" }, priority = 8)
	public void CreateNewWOFromClient() throws Exception {
		// Load the Test Data
		Map<String, Object[]> data = new TreeMap<String, Object[]>();
		data.put("1", new Object[] { "S.NO", "WO_NUMBER", "DIRECTIVE_TEXT" });
		JSONArray cred = JSonParser.getCredentials("Credentials");
		JSONObject obj = cred.getJSONObject(0);
		// Login to the mwo app
		loginPage = new LoginPage(driver);
		System.out.println("launched mwo application");
		loginPage.AppLaunchVerification();
		loginPage.validLoginFunctionality(obj.getString("username"), obj.getString("password"),
				obj.getString("serviceurl"), obj.getString("systemid"));
		homePage = new HomePage(driver);
		homePage.homeScreenVerification();
		// Create multiple work orders
		for (int i = 1; i <= 2; i++) {
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
		syncPage = homePage.initiateManualSync();
		syncPage.syncCompletedVerification();
	}

}