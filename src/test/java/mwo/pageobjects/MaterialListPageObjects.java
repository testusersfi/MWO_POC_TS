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

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Plan and issue parts')]")
	public MobileElement MATERIALS_LIST_SUBTITLE;

}
