package mwo.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AdminPageObjects {

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Admin')]")
	public MobileElement ADMIN_SCREEN_HEADER;
	
	@AndroidFindBy(id = "com.ifsworld.mworkorderapps9:id/textView4")
	public MobileElement SERVICE_ADDRESS;
	
	@AndroidFindBy(id = "com.ifsworld.mworkorderapps9:id/textView3")
	public MobileElement SYNC_INTERVAL;
	
	@AndroidFindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.Spinner[1]/android.widget.TextView[1]")
	public MobileElement SYNC_INTERVAL_TEXT;
	
	@AndroidFindBy(xpath = "//android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[contains(@text,'1 Hour')]")
	public MobileElement SYNC_INTERVAL_1_HOUR;
	
	
	public static String SYNC_INTERVAL_1_MINUTE =  "//android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[@text=\"%s\"]";
	
	
	@AndroidFindBy(xpath = "//android.widget.FrameLayout/android.widget.ListView")
	public MobileElement DROP_DOWN_LISTVIEW;
	
	//@AndroidFindBy(xpath = "//android.widget.ListView[1]/android.widget.CheckedTextView[4][contains(@text, '10 Minute']")
	//public MobileElement SYNC_10_MINUTE;
	
	@AndroidFindBy(id = "com.ifsworld.mworkorderapps9:id/logText")
	public MobileElement LOG_TYPE;
	
	@AndroidFindBy(id = "com.ifsworld.mworkorderapps9:id/pushEnabled")
	public MobileElement PUSH_ENABLED;
	
	@AndroidFindBy(id = "com.ifsworld.mworkorderapps9:id/sendLog")
	public MobileElement SEND_LOG_FILES;
	
	@AndroidFindBy(id = "com.ifsworld.mworkorderapps9:id/sendOutMessages")
	public MobileElement SEND_MESSAGES;
	
	@AndroidFindBy(id = "com.ifsworld.mworkorderapps9:id/Init")
	public MobileElement INITIALIZE;
	
	@AndroidFindBy(id="com.ifsworld.mworkorderapps9:id/appsetting__sync_interval")
	public MobileElement SYNC_INTERVAL_SPINNER;
	
}
