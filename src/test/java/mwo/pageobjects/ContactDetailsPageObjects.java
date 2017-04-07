package mwo.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class ContactDetailsPageObjects {

	@AndroidFindBy(xpath = "//android.view.View/android.widget.TextView[contains(@text,'Work Order')]")
	@iOSFindBy(xpath = "//UIASTATICTEXT[@text='WorkOrder'")
	public MobileElement SCREEN_HEADER;
	
	@AndroidFindBy(xpath = "//android.widget.LinearLayout/android.widget.TextView[contains(@text, 'Contact Details')]")
	public MobileElement CONTACT_DETAILS_TITLE;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Edit Work Order contact details')]")
	public MobileElement CONTACT_DETAILS_SUBTITLE;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Contact') and contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/mobile_separate_work_order__contact__lbl')]")
	public MobileElement CONTACTNAME_LABEL;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id = 'com.ifsworld.mworkorderapps9:id/mobile_separate_work_order__contact']")
	public MobileElement CONTACTNAME_TEXTFIELD;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Phone No') and contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/mobile_separate_work_order__phone__lbl')]")
	public MobileElement PHONENO_LABEL;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id = 'com.ifsworld.mworkorderapps9:id/mobile_separate_work_order__phone']")
	public MobileElement PHONENO_TEXTFIELD;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Customer No') and contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/mobile_separate_work_order__customer_id__lbl')]")
	public MobileElement CUSTOMERNO_LABEL;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id = 'com.ifsworld.mworkorderapps9:id/mobile_separate_work_order__customer_id']")
	public MobileElement CUSTOMERNO_TEXTFIELD;
}
