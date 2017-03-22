package com.appium.base;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class BasePageObjects {

	@iOSFindBy(xpath = "//UIANavigationBar/UIAButton[@name='Back']")
	public MobileElement IOS_BACK;

	@iOSFindBy(xpath = "//UIANavigationBar/UIAButton[@name='Done']")
	public MobileElement IOS_DONE;

	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc,'More options')]")
	@iOSFindBy(xpath = "//UIASTATICTEXT[@text='More options'")
	public static MobileElement MORE_OPTIONS_ICON;

	@AndroidFindBy(id = "com.ifsworld.mworkorderapps9:id/next")
	public static MobileElement NEXT_BUTTON;

	@AndroidFindBy(id = "com.ifsworld.mworkorderapps9:id/save")
	public static MobileElement SAVE_BUTTON;

	@AndroidFindBy(id = "android:id/title")
	public static MobileElement SCAN_BAR_CODE_LONGPRESS;
	
	@AndroidFindBy(id = "com.ifsworld.mworkorderapps9:id/search_criteria")
	public static MobileElement SEARCH_TEXT_FIELD;
	
	@AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id, 'android:id/button2') and contains(@text, 'Return')]")
	public static MobileElement COMPLETE_WO_ALERT_BUTTON_RETURN;
	
	@AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id, 'android:id/button1') and contains(@text, 'Keep')]")
	public static MobileElement COMPLETE_WO_ALERT_BUTTON_KEEP;
	
	@AndroidFindBy(id = "com.ifsworld.mworkorderapps9:id/reason_description")
	public static MobileElement REASON_DESCRIPTION;
	
	public static String REASON_CODE_ANDROID = "//android.widget.ListView/android.widget.CheckedTextView[contains(@resource-id, 'android:id/text1') and @text = \"%s\"]";
	

}
