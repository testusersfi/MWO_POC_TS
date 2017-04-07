package mwo.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class WOExpensesPageObjects {

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Expenses') and contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/screen_title')]")
	public MobileElement EXPENSES_SCREEN_TITLE;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Enter Expenses incurred on this Work Order')]")
	public MobileElement EXPENSES_SCREEN_SUBTITLE;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Sales Part') and contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/mobile_expenses__catalog_no_lbl')]")
	public MobileElement SALES_PART_LABEL;

	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/mobile_expenses__catalog_no')]")
	public MobileElement SALES_PART_FIELD;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Quantity') and contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/mobile_expenses__qty_lbl')]")
	public MobileElement QUANTITY_LABEL;

	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/mobile_expenses__qty')]")
	public MobileElement QUANTITY_FIELD;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Cost') and contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/mobile_expenses__cost_lbl')]")
	public MobileElement COST_LABEL;

	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/mobile_expenses__cost')]")
	public MobileElement COST_FIELD;

}
