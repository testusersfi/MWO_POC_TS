package mwo.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class WOPicturesPageObjects {

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Pictures']")
	public MobileElement PICTURES_SCREEN_TITLE;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'All picture attachments on this Work Order.')]")
	public MobileElement PICTURES_SCREEN_SUBTITLE;

	@AndroidFindBy(xpath = "//android.widget.ListView[contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/listview')]")
	public MobileElement IMAGES_LIST_VIEW;



}
