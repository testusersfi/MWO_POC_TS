package mwo.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class ObjectDetailsPageObjects {

	@AndroidFindBy(xpath = "//android.view.View/android.widget.TextView[contains(@text,'Work Order')]")
	@iOSFindBy(xpath = "//UIASTATICTEXT[@text='mWorkOrder'")
	public MobileElement SCREEN_HEADER;
	
	@AndroidFindBy(xpath = "//android.widget.LinearLayout/android.widget.TextView[contains(@text, 'Object Details')]")
	public MobileElement OBJECT_DETAILS_TITLE;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Edit Work Order Object details')]")
	public MobileElement OBJECT_DETAILS_SUBTITLE;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Object ID') and contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/mobile_separate_work_order__object_id__lbl')]")
	public MobileElement OBJECTID_LABEL;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id = 'com.ifsworld.mworkorderapps9:id/mobile_separate_work_order__object_id']")
	public MobileElement OBJECTID_TEXTFIELD;

}
