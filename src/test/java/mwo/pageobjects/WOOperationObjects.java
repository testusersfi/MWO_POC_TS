package mwo.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class WOOperationObjects {

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Select an operation')]")
	public MobileElement SCREEN_HEADER;

	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/search_criteria')]")
	public MobileElement OPERATION_SEARCH_FIELD;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/list_item_seperator__header')]")
	public MobileElement DEFAULT_OPERATION;
	
}
