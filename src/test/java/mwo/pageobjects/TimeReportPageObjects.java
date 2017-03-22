package mwo.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class TimeReportPageObjects {

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Work Orders')]")
	@iOSFindBy(xpath = "//UIASTATICTEXT[@text='mWorkOrder'")
	public MobileElement SCREEN_HEADER;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/screen_title')]")
	public MobileElement TIMEREPORT_TITLE;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/screen_desc')]")
	public MobileElement TIME_REPORT_DESCRIPTION;

	
	@AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id,'com.ifsworld.mworkorderapps9:id/view_previous_entries')]")
	public MobileElement PREVIOUS_ENTRIES;


	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'com.ifsworld.mworkorderapps9:id/mobile_time_report__hours__lbl')]")
	public MobileElement TIMEREPORT_QUANTITY;

}



  