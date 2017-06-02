package mwo.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class WOCommentObjects {

	@AndroidFindBy(xpath = "//android.widget.TextView[1]")
	public MobileElement SCREEN_HEADER;

	@AndroidFindBy(xpath = "//android.widget.EditText[1]")
	public MobileElement COMMENT_FIELD;

}
