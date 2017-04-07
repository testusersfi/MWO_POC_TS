package mwo.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class WOPurchaseRequestPageObjects {

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Purchase Request') and contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/screen_title')]")
	public MobileElement PURCHASE_REQUEST_SCREEN_TITLE;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Raise a Purchase Request for this Work Order') and contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/screen_desc')]")
	public MobileElement PURCHASE_REQUEST_SCREEN_SUBTITLE;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Part No') and contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/mobile_purch_req_line__part_no__lbl')]")
	public MobileElement PART_NUMBER_LABEL;

	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/mobile_purch_req_line__part_no')]")
	public MobileElement PART_NUMBER_FIELD;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Part description') and contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/mobile_purch_req_line__part_description__lbl')]")
	public MobileElement PART_DESCRIPTION_LABEL;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/mobile_purch_req_line__part_description')]")
	public MobileElement PART_DESCRIPTION_FIELD;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Original Qty') and contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/mobile_purch_req_line__qty_req__lbl')]")
	public MobileElement ORIGINAL_QTY_LABEL;

	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/mobile_purch_req_line__qty_req')]")
	public MobileElement ORIGINAL_QTY_FIELD;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/mobile_purch_req_line__date_wanted__lbl') and contains(@text, 'Wanted Receipt Date')]")
	public MobileElement WANTED_RECEIPT_DATE_LABEL;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/mobile_purch_req_line__date_wanted')]")
	public MobileElement WANTED_RECEIPT_DATE_FIELD;


}
