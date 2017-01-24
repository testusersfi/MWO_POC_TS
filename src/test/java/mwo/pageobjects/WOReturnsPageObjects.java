package mwo.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class WOReturnsPageObjects {

	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[contains(@text,'Returns') and contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/screen_title']")
	@iOSFindBy(xpath = "//UIASTATICTEXT[@text='Returns'")
	public MobileElement SCREEN_HEADER;

	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[contains(@text,'Enter and view parts to be returned on this Work Order') and contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/screen_desc']")
	public MobileElement SCREEN_DESCRIPTION;
	
	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.Button[contains(@text,'Previous') and contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/view_previous_entries']")
	public MobileElement PREVIOUS_BUTTON;

	@AndroidFindBy(xpath = "//android.widget.LinearLayout/android.widget.TableLayout/android.widget.TableRow/android.widget.TextView[contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/mobile_work_order_returns__part_no__lbl') and contains(@text, 'Part No')]")
	public MobileElement PART_NUMBER_LABEL;

	@AndroidFindBy(xpath = "//android.widget.LinearLayout/android.widget.TableLayout/android.widget.TableRow/android.widget.EditText[contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/mobile_work_order_returns__part_no') and contains(@text, 'Required')]")
	public MobileElement PART_NUMBER_TEXT_FIELD;

	@AndroidFindBy(xpath = "//android.widget.LinearLayout/android.widget.TableLayout/android.widget.TableRow/android.widget.TextView[contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/mobile_work_order_returns__qty_to_return__lbl') and contains(@text, 'Quantity To Return')")
	public MobileElement QUANTITY_TO_RETURN_FIELD_LABEL;

	@AndroidFindBy(xpath = "//android.widget.LinearLayout/android.widget.TableLayout/android.widget.TableRow/android.widget.EditText[@resource-id='com.ifsworld.mworkorderapps9:id/mobile_work_order_returns__qty_to_return']")
	public MobileElement QUANTITY_TO_RETURN_TEXT_FIELD;

}
