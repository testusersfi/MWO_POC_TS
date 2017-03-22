package mwo.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class WOSuspendPageObjects {
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/reason_title') and @text='Suspend or Abort']")
	@iOSFindBy(xpath = "//UIASTATICTEXT[@text='Suspend or Abort'")
	public MobileElement REASON_TITLE;

	@AndroidFindBy(id = "com.ifsworld.mworkorderapps9:id/reason_description")
	public MobileElement REASON_DESCRIPTION;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/mobile_separate_work_order__reason_type__lbl') and @text='Type']")
	public MobileElement REASON_TYPE_LABEL;

	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.LinearLayout/android.widget.TableLayout/android.widget.TableRow/android.widget.Spinner[@resource-id='com.ifsworld.mworkorderapps9:id/mobile_separate_work_order__reason_type']")
	public MobileElement REASON_TYPE_SPINNER;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/mobile_separate_work_order__reason_code__lbl') and @text='Reason']")
	public MobileElement REASON_CODE_LABEL;

	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.LinearLayout/android.widget.TableLayout/android.widget.TableRow/android.widget.Spinner[@resource-id='com.ifsworld.mworkorderapps9:id/mobile_separate_work_order__reason_code']")
	public MobileElement REASON_CODE_SPINNER;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/mobile_separate_work_order__reason_note__lbl') and @text='Note']")
	public MobileElement REASON_NOTES_LABEL;

	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.LinearLayout/android.widget.TableLayout/android.widget.TableRow/android.widget.EditText[@resource-id='com.ifsworld.mworkorderapps9:id/mobile_separate_work_order__reason_note']")
	public MobileElement REASON_COMMENTS_FIELD;
	
	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.LinearLayout/android.widget.TableLayout/android.widget.TableRow/android.widget.Spinner/android.widget.TextView[@resource-id='android:id/text1' and @text='Suspend']")
	public MobileElement SPINNER_DEFAULT_TEXT;
	
}