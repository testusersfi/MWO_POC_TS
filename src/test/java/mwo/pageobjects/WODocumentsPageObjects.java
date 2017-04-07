package mwo.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class WODocumentsPageObjects {

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Documents') and contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/document_attachment_title')]")
	public MobileElement DOCUMENTS_SCREEN_TITLE;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'All documents attached to this Work Order') and contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/document_attachment_desc')]")
	public MobileElement TIME_REPORT_SCREEN_SUBTITLE;
}
