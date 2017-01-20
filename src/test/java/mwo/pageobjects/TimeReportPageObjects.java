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

	/*Quantity_edittext: 	//android.widget.EditText[contains(@resource-id,'com.ifsworld.mworkorderapps9:id/mobile_time_report__hours')]

	Next_button: //android.widget.LinearLayout/android.widget.Button[contains(@resource-id,'com.ifsworld.mworkorderapps9:id/next')]

	Add_button:
	// android.widget.LinearLayout/android.widget.Button[contains(@resource-id,
	// 'com.ifsworld.mworkorderapps9:id/save�)]

	Report in screen:

	Report in title:
	// android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView[@text='Report
	// In']

	Report In Description:
	// android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView[contains(@text,
	// 'Please Report In your Work Order')]

	SAVE_BUTTON (ids)
	  com.ifsworld.mworkorderapps9:id/save

	  Next_button:
	  com.ifsworld.mworkorderapps9:id/next

  
}
*/