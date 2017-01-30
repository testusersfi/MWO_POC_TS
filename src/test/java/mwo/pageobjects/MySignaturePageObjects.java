package mwo.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class MySignaturePageObjects {

	@AndroidFindBy(xpath = "//android.view.View/android.widget.TextView[contains(@text,'Work Order')]")
	@iOSFindBy(xpath = "//UIASTATICTEXT[@text='mWorkOrder'")
	public MobileElement SCREEN_HEADER;

	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView[contains(@text, 'My Signature')]")
	public MobileElement MY_SIGNATURE_TITLE;

	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView[contains(@text, 'Please sign below to confirm the Work you have completed')]")
	public MobileElement SIGNATURE_DESCRIPTION;

	@AndroidFindBy(xpath = "//android.widget.TableLayout/android.widget.TableRow/android.widget.TextView[contains(@text, 'Directive')]")
	public MobileElement DIRECTIVE_LABEL;

	@AndroidFindBy(xpath = "// android.widget.TableLayout/android.widget.TableRow/android.widget.TextView[@resource-id='com.ifsworld.mworkorderapps9:id/mobile_separate_work_order__directive']")
	public MobileElement DIRECTIVE_TEXT_FIELD;

	@AndroidFindBy(xpath = "// android.widget.TableLayout/android.widget.TableRow/android.widget.TextView[contains(@text,'Actual Start')]")
	public MobileElement ACTUAL_START_LABEL;

	@AndroidFindBy(xpath = "// android.widget.TableLayout/android.widget.TableRow/android.widget.TextView[@resource-id='com.ifsworld.mworkorderapps9:id/mobile_separate_work_order__actual_start']")
	public MobileElement ACTUAL_START_TEXT_FIELD;

	@AndroidFindBy(xpath = "//android.widget.RelativeLayout/android.widget.TextView[contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/textView3') and contains(@text, 'Please Sign Below')]")
	public MobileElement CANVAS_SIGN_PAD_TITLE;

	@AndroidFindBy(xpath = "//android.widget.RelativeLayout/android.widget.ImageView[@resource-id='com.ifsworld.mworkorderapps9:id/clear_signature']")
	public MobileElement CLEAR_SIGN_ICON;

	@AndroidFindBy(id = "com.ifsworld.mworkorderapps9:id/signature_area")
	public MobileElement SIGNATURE_AREA;
	
	@AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/save') and contains(@text, 'Next')]")
	public MobileElement NEXT_BUTTON;
	
	

}
