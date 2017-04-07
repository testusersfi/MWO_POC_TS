package mwo.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class WOOnHoldPageObjects {

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/reason_title') and @text='On Hold']")
	@iOSFindBy(xpath = "//UIASTATICTEXT[@text='On Hold'")
	public MobileElement ONHOLD_REASON_TITLE;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/reason_title') and @text='Reject']")
	@iOSFindBy(xpath = "//UIASTATICTEXT[@text='Reject'")
	public MobileElement REJECT_REASON_TITLE;
	
	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.LinearLayout/android.widget.TableLayout/android.widget.TableRow/android.widget.TextView[contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/mobile_separate_work_order__reason_code__lbl') and @text='Reason']")
	public MobileElement REASON_CODE_LABEL;

	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.LinearLayout/android.widget.TableLayout/android.widget.TableRow/android.widget.Spinner[@resource-id='com.ifsworld.mworkorderapps9:id/mobile_separate_work_order__reason_code']")
	public MobileElement REASON_CODE_SPINNER;

	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.LinearLayout/android.widget.TableLayout/android.widget.TableRow/android.widget.TextView[contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/mobile_separate_work_order__reason_note__lbl') and @text='Note']")
	public MobileElement REASON_NOTES_LABEL;

	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.LinearLayout/android.widget.TableLayout/android.widget.TableRow/android.widget.EditText[@resource-id='com.ifsworld.mworkorderapps9:id/mobile_separate_work_order__reason_note']")
	public MobileElement REASON_COMMENTS_FIELD;
	
	@AndroidFindBy(className = "//android.widget.ListView")
	public MobileElement REASON_CODES_LIST_VIEW;
}

