package mwo.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class WODatesPageObjects {

	@AndroidFindBy(xpath = "//android.view.View/android.widget.TextView[contains(@text,'Work Order')]")
	@iOSFindBy(xpath = "//UIASTATICTEXT[@text='mWorkOrder'")
	public MobileElement SCREEN_HEADER;
	
	@AndroidFindBy(id = "com.ifsworld.mworkorderapps9:id/attachment_option")
	public MobileElement ATTCHMENT_ICON;
	
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'WO Dates')]")
	public MobileElement WODATES_TITLE;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Planning')]")
	public MobileElement PLANNING_SECTION_TITLE;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Requested')]")
	public MobileElement REQUESTED_SECTION_TITLE;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id, 'android:id/message') and contains(@text, 'Do you want to Keep or Return')]")
	public MobileElement COMPLETE_WO_ALERT_MESSSAGE;
	
}



	

