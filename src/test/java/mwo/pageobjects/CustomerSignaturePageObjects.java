package mwo.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class CustomerSignaturePageObjects {

	@AndroidFindBy(xpath = "//android.view.View/android.widget.TextView[contains(@text,'Work Order')]")
	@iOSFindBy(xpath = "//UIASTATICTEXT[@text='mWorkOrder'")
	public MobileElement SCREEN_HEADER;

	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView[contains(@text, 'Customer Signature')]")
	public MobileElement CUSTOMER_SIGNATURE_TITLE;

	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView[contains(@text, 'Please sign below to indicate that you are satisfied with the work that has been carried out on your behalf')]")
	public MobileElement SIGNATURE_DESCRIPTION;

	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.LinearLayout/android.widget.TableLayout/android.widget.TableRow/android.widget.TextView[contains(@text, 'Signed By') and contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/mobile_separate_work_order__signed_by__lbl')]")
	public MobileElement SIGNED_BY_LABEL;

	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.LinearLayout/android.widget.TableLayout/android.widget.TableRow/android.widget.TextView[contains(@text, 'Required') and (@resource-id='com.ifsworld.mworkorderapps9:id/com.ifsworld.mworkorderapps9:id/mobile_separate_work_order__signed_by')]")
	public MobileElement SIGN_BY_TEXT_FIELD;

	@AndroidFindBy(xpath = "//android.widget.RelativeLayout/android.widget.TextView[contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/textView3') and contains(@text, 'Please Sign Below')]")
	public MobileElement CANVAS_SIGN_PAD_TITLE;

	@AndroidFindBy(xpath = "//android.widget.RelativeLayout/android.widget.ImageView[@resource-id='com.ifsworld.mworkorderapps9:id/clear_signature']")
	public MobileElement CLEAR_SIGN_ICON;

	@AndroidFindBy(id = "com.ifsworld.mworkorderapps9:id/signature_area")
	public MobileElement SIGNATURE_AREA;
}
