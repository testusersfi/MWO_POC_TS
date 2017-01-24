package mwo.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class WOReportWebViewPageObjects {

	@AndroidFindBy(xpath = "//android.view.View/android.widget.TextView[contains(@text,'Work Order')]")
	@iOSFindBy(xpath = "//UIASTATICTEXT[@text='mWorkOrder'")
	public MobileElement SCREEN_HEADER;
	
	@AndroidFindBy(xpath = "//android.widget.LinearLayout/android.webkit.WebView")
	public MobileElement REPORT_WEBVIEW;
	
	@AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/btnRepSave') and contains(@text, 'Save')]")
	public MobileElement SAVE_BUTTON;
	
	@AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/btnRepSend') and contains(@text, 'Send')]")
	public MobileElement SEND_BUTTON;

	@AndroidFindBy(id = "//android.widget.Button[contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/btnRepNext') and contains(@text, 'Complete')]")
	public MobileElement COMPLETE_BUTTON;
	
	@AndroidFindBy(id = "//android.widget.Button[contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/btnRepNext') and contains(@text, 'Next')]")
	public MobileElement NEXT_BUTTON;
	
	@AndroidFindBy(id = "//android.widget.TextView[contains(@resource-id, 'android:id/message') and contains(@text, 'What do you want to do with this Work Order?')]")
	public MobileElement COMPLETE_WO_ALERT_MESSSAGE;
	
	@AndroidFindBy(id = "//android.widget.Button[contains(@resource-id, 'android:id/button3') and contains(@text, 'Return Travel')]")
	public MobileElement COMPLETE_WO_ALERT_BUTTON3;
	
	@AndroidFindBy(id = "//android.widget.Button[contains(@resource-id, 'android:id/button2') and contains(@text, 'Return')]")
	public MobileElement COMPLETE_WO_ALERT_BUTTON2;
	
	@AndroidFindBy(id = "//android.widget.Button[contains(@resource-id, 'android:id/button1') and contains(@text, 'Keep')]")
	public MobileElement COMPLETE_WO_ALERT_BUTTON1;
	
}



	

