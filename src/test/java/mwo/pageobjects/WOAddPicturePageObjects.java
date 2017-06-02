package mwo.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class WOAddPicturePageObjects {

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Pictures') and contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/screen_title')]")
	public MobileElement ADD_PICTURE_SCREEN_TITLE;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Select a picture file or take a picture to attach to this Work Order') and contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/screen_desc')]")
	public MobileElement ADD_PICTURE_SCREEN_DESCRIPTION;

	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Description') and contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/textView2')]")
	public MobileElement PICTURE_DESCRIPTION_LABEL;

	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/mobile_work_order_picture__description')]")
	public MobileElement PICTURE_DESCRIPTION_TEXT_FIELD;

	@AndroidFindBy(xpath = "//android.widget.Button[contains(@text, 'File') and contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/btnFile')]")
	public MobileElement ATTACH_FILE_BUTTON;

	@AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/btnCamera') and contains(@text, 'Take Photo')]")
	public MobileElement TAKE_PHOTO_BUTTON;
	
	@AndroidFindBy(id = "com.ifsworld.mworkorderapps9:id/mobile_work_order_picture__picture")
	public MobileElement ATTACHED_CAMERA_IMAGE;
	
	@AndroidFindBy(id = "com.sec.android.app.camera:id/okay")
	public MobileElement POST_CAPTURE_OK_BUTTON;
	


}
