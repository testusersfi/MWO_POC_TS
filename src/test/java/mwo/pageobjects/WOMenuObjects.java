package mwo.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class WOMenuObjects {

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'UI Designer') and contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/title')]")
	public MobileElement UI_DESIGNER_MENU_ITEM;
}
