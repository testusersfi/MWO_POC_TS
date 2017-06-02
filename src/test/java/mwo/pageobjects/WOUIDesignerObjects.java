package mwo.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class WOUIDesignerObjects {

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'UI Designer')]")
	public MobileElement UIDESIGNER_SCREEN_TITLE;

}
