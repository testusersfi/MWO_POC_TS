package mwo.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class SelectSerialNumberScreenPageObjects {

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Select a serial')]")
	@iOSFindBy(xpath = "//UIASTATICTEXT[@text='Select a serial'")
	public MobileElement SCREEN_HEADER;

	@AndroidFindBy(id = "com.ifsworld.mworkorderapps9:id/item_lookup_barcode")
	@iOSFindBy(xpath = "//UIASTATICTEXT[@text='Barcode'")
	public MobileElement BAR_CODE_SCAN;

	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@text, 'Search') and contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/search_criteria')]")
	public MobileElement SEARCH_TEXT_FIELD;

	@AndroidFindBy(xpath = "//android.widget.ListView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/itemdescription')]")
	public MobileElement PART_DESCRIPTION;

	@AndroidFindBy(xpath = "//android.widget.ListView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/item1')]")
	public MobileElement PART_ITEM1;

	@AndroidFindBy(xpath = "//android.widget.ListView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout /android.widget.TextView[contains(@text, 'NGS') and contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/item2')]")
	public MobileElement PART_ITEM2;

	@AndroidFindBy(id = "com.ifsworld.mworkorderapps9:id/row_count_bar")
	public MobileElement ROWCOUNT_BAR_DISPLAY;

}