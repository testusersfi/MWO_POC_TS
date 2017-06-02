package mwo.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class WOActionPageObjects {

	@AndroidFindBy(xpath = " //android.view.View/android.widget.TextView[contains(@text,'Work Order')]")
	@iOSFindBy(xpath = "//UIASTATICTEXT[@text='Work Order'")
	public MobileElement SCREEN_HEADER;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'WO Actions')]")
	public MobileElement WOACTIONS_TITLE;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'All actions that can be performed on this Work Order')]")
	public MobileElement WOACTIONS_SUBTITLE;

	@AndroidFindBy(xpath = "//android.widget.ListView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TableLayout/android.widget.TableRow/android.widget.TextView[contains(@text, 'Material') and contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/debrief_menu_option_name')]")
	public MobileElement WOACTIONS_MATERIAL;

	@AndroidFindBy(xpath = "//android.widget.ListView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TableLayout/android.widget.TableRow /android.widget.TextView[contains(@text, 'Plan and issue parts') and contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/debrief_menu_option_description')]")
	public MobileElement WOACTIONS_MATERIAL_SUBTITLE;

	@AndroidFindBy(xpath = "//android.widget.ListView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TableLayout/android.widget.TableRow/android.widget.TextView[contains(@text, 'Time Report') and contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/debrief_menu_option_name')]")
	public MobileElement WOACTIONS_TIME_REPORT;

	@AndroidFindBy(xpath = "//android.widget.ListView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TableLayout/android.widget.TableRow/android.widget.TextView[contains(@text, 'Expenses') and contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/debrief_menu_option_name')]")
	public MobileElement WOACTIONS_TIME_EXPENCE;
	
	public String ActionList="//android.widget.TextView[contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/debrief_menu_option_description') and @text=\"%s\"]" ;

}
