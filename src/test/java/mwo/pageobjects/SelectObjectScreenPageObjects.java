package mwo.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SelectObjectScreenPageObjects {

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Select an Object')]")
	public MobileElement SELECT_OBJECT_SCREEN_HEADER;
	
	@AndroidFindBy(id = "com.ifsworld.mworkorderapps9:id/item_lookup_barcode")
	public MobileElement BAR_CODE_SCAN;
	
	@AndroidFindBy(id = "com.ifsworld.mworkorderapps9:id/search_criteria")
	public MobileElement SELECT_OBJECT_SEARCH_TEXT_FIELD;
	
	@AndroidFindBy(id = "com.ifsworld.mworkorderapps9:id/row_count_bar")
	public MobileElement ROWCOUNT_BAR_DISPLAY;
	
	@AndroidFindBy(xpath = "//android.widget.ListView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/itemdescription')]")
	public MobileElement OBJECT_DESCRIPTION;
}
