package mwo.pageobjects;

import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class WOPreviewPageObjects {

	@AndroidFindBy(xpath = "//android.view.View/android.widget.TextView[contains(@text,'Work Order')]")
	@iOSFindBy(xpath = "//UIASTATICTEXT[@text='mWorkOrder'")
	public MobileElement SCREEN_HEADER;


	public String WORKORDER_NUMBER = "//android.widget.TableLayout[1]/android.widget.TableRow[2]/android.widget.TextView[contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/work_order__wo_no’) and @text=\"%s\"]";

	@AndroidFindBy(id = "com.ifsworld.mworkorderapps9:id/item_lookup_barcode")
	public MobileElement WORKORDER_BARCODE;

	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[@text='Accept']")
	public MobileElement ACCEPT_BUTTON;

	@AndroidFindBy(xpath = "//android.widget.LinearLayout/android.widget.Button[contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/next')]")
	public MobileElement NEXT_BUTTON;

	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[@text='On Route']")
	public MobileElement ONROUTE_BUTTON;

	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[@text='On Site']")
	public MobileElement ONSITE_BUTTON;

	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[@text='Reject']")
	public MobileElement REJECT_BUTTON;

	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[@text='On Hold']")
	public MobileElement ONHOLD_BUTTON;

	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[@text='Suspend']")
	public MobileElement SUSPEND_BUTTON;

	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.Button[contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/edit_details')]")
	public MobileElement WO_DETAILS_BUTTON;

	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.LinearLayout/android.widget.TableLayout/android.widget.TableRow/android.widget.TextView[contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/mobile_separate_work_order__directive__lbl')]")
	public MobileElement DETAILS_DIRECTIVE_LABEL;

	// android.widget.ScrollView/android.widget.LinearLayout/android.widget.TableLayout/android.widget.TableRow/android.widget.TextView[@resource-id='com.ifsworld.mworkorderapps9:id/mobile_separate_work_order__directive'
	// and @text=\”%s\”]

	public String DETAILS_DIRECTIVE_TEXT;

	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.LinearLayout/android.widget.TableLayout/android.widget.TableRow/android.widget.TextView[contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/mobile_separate_work_order__wo_site__clbl')]")
	public MobileElement DETAILS_SITE_LABEL;

	// android.widget.ScrollView/android.widget.LinearLayout/android.widget.TableLayout/android.widget.TableRow/android.widget.TextView[@resource-id='com.ifsworld.mworkorderapps9:id/mobile_separate_work_order__wo_site'
	// and @text=\”%s\”]

	public MobileElement DETAILS_SITE_NAME;

	@AndroidFindBy(xpath="//android.widget.ScrollView/android.widget.LinearLayout/android.widget.TableLayout/android.widget.TableRow/android.widget.TextView[@resource-id, 'com.ifsworld.mworkorderapps9:id/ mobile_separate_work_order__full_scheduled__lbl')]")
	public MobileElement DETAILS_SCHEDULED_LABEL;

	// android.widget.ScrollView/android.widget.LinearLayout/android.widget.TableLayout/android.widget.TableRow/android.widget.TextView[@resource-id='com.ifsworld.mworkorderapps9:id/mobile_separate_work_order__full_scheduled'
	// and @text=\”%s\”]

	public MobileElement DETAILS_SCHEDULED_TIME;

	//@MobileBy(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()" + ".resourceId(\"com.ifsworld.mworkorderapps9:id/work_order__wo_no\")).scrollIntoView(" + "new UiSelector().text(\"669\"));"))
	//public MobileElement TIME_REPORT;
}
