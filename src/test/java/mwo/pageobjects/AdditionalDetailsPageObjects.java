package mwo.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class AdditionalDetailsPageObjects {

	@AndroidFindBy(xpath = "//android.view.View/android.widget.TextView[contains(@text,'Work Order')]")
	@iOSFindBy(xpath = "//UIASTATICTEXT[@text='mWorkOrder'")
	public MobileElement SCREEN_HEADER;

	@AndroidFindBy(xpath = "//android.widget.LinearLayout/android.widget.TextView[contains(@text, 'Additional Details')]")
	public MobileElement ADDITIONAL_DETAILS_TITLE;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Edit additional Work Order details')]")
	public MobileElement ADDITIONAL_DETAILS_SUBTITLE;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Directive') and contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/mobile_separate_work_order__directive__lbl')]")
	public MobileElement DIRECTIVE_LABEL;

	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id = 'com.ifsworld.mworkorderapps9:id/mobile_separate_work_order__directive']")
	public MobileElement DIRECTIVE_TEXTFIELD;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'WO Site') and contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/mobile_separate_work_order__site__lbl')]")
	public MobileElement WO_SITE_LABEL;
	
	@AndroidFindBy(xpath= "//android.widget.TextView[@resource-id = 'com.ifsworld.mworkorderapps9:id/mobile_separate_work_order__site']")
	public MobileElement WO_SITE_TEXT; 
}
