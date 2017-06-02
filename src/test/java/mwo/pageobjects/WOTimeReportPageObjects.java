package mwo.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class WOTimeReportPageObjects {

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Time Report') and contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/screen_title')]")
	public MobileElement TIME_REPORT_SCREEN_TITLE;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Enter the time you spent on this Work Order')]")
	public MobileElement TIME_REPORT_SCREEN_SUBTITLE;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Start Time') and contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/mobile_time_report__start_time__lbl')]")
	public MobileElement START_TIME_LABEL;

	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/mobile_time_report__start_time')]")
	public MobileElement START_TIME_FIELD;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'End Time') and contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/mobile_time_report__end_time__lbl')]")
	public MobileElement END_TIME_LABEL;

	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/mobile_time_report__end_time')]")
	public MobileElement END_TIME_FIELD;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Qty') and contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/mobile_time_report__hours__lbl')]")
	public MobileElement QTY_LABEL;

	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/mobile_time_report__hours')]")
	public MobileElement QTY_FIELD;

	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.Button[contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/edit_object')]")
	public MobileElement WO_OBJECT_DETAILS_BUTTON;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Operation Description') and contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/mobile_time_report__operation_desc__lbl')]")
	public MobileElement OPERATION_LABEL;

	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/mobile_time_report__operation_desc')]")
	public MobileElement OPERATION_FIELD;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Name') and contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/maint_employee__name__lbl')]")
	public MobileElement EMPLOYEE_NAME_LABEL;

	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/maint_employee__name')]")
	public MobileElement EMPLOYEE_NAME_TXTFIELD;
	
	
	

}
