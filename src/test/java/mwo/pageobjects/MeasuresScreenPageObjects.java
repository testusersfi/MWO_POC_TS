package mwo.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class MeasuresScreenPageObjects {

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Measures')]")
	@iOSFindBy(xpath = "//UIASTATICTEXT[@text='Measures'")
	public MobileElement MEASURES_SCREEN_HEADER;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id= 'com.ifsworld.mworkorderapps9:id/object_overview__sub_title' and contains(@text,'Select Object to register Measurements')]")
	@iOSFindBy(xpath = "//UIASTATICTEXT[@text='Select a lot batch no'")
	public MobileElement MEASURES_SCREEN_SUB_TITLE;

	@AndroidFindBy(id = "com.ifsworld.mworkorderapps9:id/object_overview_search_criteria")
	public MobileElement OBJECTS_SEARCH_TEXT_FIELD;

	@AndroidFindBy(id = "com.ifsworld.mworkorderapps9:id/item_lookup_barcode")
	@iOSFindBy(xpath = "//UIASTATICTEXT[@text='Barcode'")
	public MobileElement BAR_CODE_SCAN;

	@AndroidFindBy(id = "com.ifsworld.mworkorderapps9:id/list_item_seperator__header")
	public MobileElement LIST_ITEM_SEPERATOR;

	@AndroidFindBy(id = "com.ifsworld.mworkorderapps9:id/equipment_object__mch_name")
	public MobileElement OBJECT_MERCHANT_NAME;

	@AndroidFindBy(id = "com.ifsworld.mworkorderapps9:id/equipment_object__contract")
	public MobileElement OBJECT_CONTRACT;
	
	@AndroidFindBy(xpath = "//android.widget.ListView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TableLayout/android.widget.TextView[@resource-id='com.ifsworld.mworkorderapps9:id/equipment_object__contract']")
	public MobileElement OBJECT_CONTRACT1;
	
	@AndroidFindBy(xpath = "//android.widget.ListView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TableLayout/android.widget.TextView[@resource-id='com.ifsworld.mworkorderapps9:id/equipment_object__mch_name']")
	public MobileElement OBJECT_MERCHANT_NAME1;
	
	@AndroidFindBy(xpath = "//android.widget.ListView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[@resource-id='com.ifsworld.mworkorderapps9:id/equipment_object__mch_code']")
	public MobileElement OBJECT_MERCHANT_CODE1;

	@AndroidFindBy(id = "com.ifsworld.mworkorderapps9:id/equipment_object__mch_code")
	public MobileElement OBJECT_MERCHANT_CODE;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Recorded Value')]")
	public MobileElement RECORDED_VALUE_NEW;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id= 'com.ifsworld.mworkorderapps9:id/mobile_object_measurement__recorded_value']")
	public MobileElement RECORDED_VALUE_NEW_FIELD;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Recorded')]")
	public MobileElement RECORDED_VALUE_OLD;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id= 'com.ifsworld.mworkorderapps9:id/obj_measure_recorded_value']")
	public MobileElement RECORDED_VALUE_OLD_FIELD;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Total')]")
	public MobileElement RECORDED_VALUE_TOTAL;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id= 'com.ifsworld.mworkorderapps9:id/obj_measure_measured_value']")
	public MobileElement RECORDED_VALUE_TOTAL_FIELD;
	

}
