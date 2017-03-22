package mwo.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SelectMaintainanceOrgPageObjects {

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Select a maint org')]")
	public MobileElement SELECT_MAINT_ORG_SCREEN_HEADER;
	
	@AndroidFindBy(id = "com.ifsworld.mworkorderapps9:id/row_count_bar")
	public MobileElement ROWCOUNT_BAR_DISPLAY;
	
	@AndroidFindBy(xpath = "//android.widget.ListView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/itemdescription')]")
	public MobileElement ORG_ITEM_DESCRIPTION;
}
