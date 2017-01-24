package mwo.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class MaterialListPageObjects {

	@AndroidFindBy(xpath = "//android.view.View/android.widget.TextView[contains(@text,'Work Order')]")
	@iOSFindBy(xpath = "//UIASTATICTEXT[@text='mWorkOrder'")
	public MobileElement SCREEN_HEADER;

	@AndroidFindBy(xpath = "//android.widget.LinearLayout/android.widget.TextView[contains(@text, 'Material List')]")
	public MobileElement MATERIALS_LIST_TITLE;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'All actions that can be performed on this Work Order')]")
	public MobileElement MATERIALS_LIST_SUBTITLE;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Material') and contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/debrief_menu_option_name')]")
	public MobileElement WOACTIONS_MATERIAL;

	@AndroidFindBy(xpath = "//android.widget.LinearLayout/android.widget.TextView[contains(@text, 'Plan and issue parts') and contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/MateiralListTitleDetails')]")
	public MobileElement WOACTIONS_MATERIAL_SUBTITLE;

}
