package mwo.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class MaterialsPageObjects {

	@AndroidFindBy(xpath = "//android.view.View/android.widget.TextView[contains(@text,'Work Order')]")
	@iOSFindBy(xpath = "//UIASTATICTEXT[@text='mWorkOrder'")
	public MobileElement SCREEN_HEADER;

	@AndroidFindBy(xpath = "//android.widget.FrameLayout/android.view.View/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[contains(@text, 'Materials’)]")
	public MobileElement MATERIALS_TITLE;
	
	@AndroidFindBy(xpath = "//android.widget.LinearLayout/android.widget.TextView[contains(@text, 'Select an option to issue parts used on this Work Order')]")
	public MobileElement MATERIALS_DESCRIPTION;
	
	@AndroidFindBy(xpath = "//android.widget.ListView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TableLayout/android.widget.TableRow/android.widget.TextView[contains(@text, 'Parts From My Stock') and contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/debrief_menu_option_name')]")
	public MobileElement PARTS_FROM_MY_STOCK_LABEL;
	
	@AndroidFindBy(xpath = "-//android.widget.ListView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TableLayout/android.widget.TableRow/android.widget.TextView[contains(@text, 'Quick part issue') and contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/debrief_menu_option_description')]")
	public MobileElement PARTS_FROM_MY_STOCK_DESCRIPTION;
	
	@AndroidFindBy(xpath = "//android.widget.ListView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TableLayout/android.widget.TableRow/android.widget.TextView[contains(@text, 'Issue Planned') and contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/debrief_menu_option_name')]")
	public MobileElement ISSUE_PLANNED_LABEL;
	
	@AndroidFindBy(xpath = "//android.widget.ListView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TableLayout/android.widget.TableRow/android.widget.TextView[contains(@text, 'Review and issue planned parts') and contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/debrief_menu_option_description')]")
	public MobileElement ISSUE_PLANNED_DESCRIPTION;
	
	@AndroidFindBy(xpath = "//android.widget.ListView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TableLayout/android.widget.TableRow/android.widget.TextView[contains(@text, 'Receive Reserved Materials') and contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/debrief_menu_option_name')]")
	public MobileElement RECEIVE_RESERVED_MATERIALS_LABEL;
	
	@AndroidFindBy(xpath = "//android.widget.ListView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TableLayout/android.widget.TableRow/android.widget.TextView[contains(@text, 'Receive Reserved Materials') and contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/debrief_menu_option_name')]")
	public MobileElement NEW_PLANNED_PART_LABEL;
	
	@AndroidFindBy(xpath = "//android.widget.ListView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TableLayout/android.widget.TableRow/android.widget.TextView[contains(@text, 'Receive Reserved Materials') and contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/debrief_menu_option_name')]")
	public MobileElement VIEW_PREVIOUS_LABEL;
}
