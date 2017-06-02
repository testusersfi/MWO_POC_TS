package mwo.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
//import io.appium.java_client.pagefactory.iOSFindBy;

public class NewWorkOrderPageObjects {
	
	@AndroidFindBy(xpath = "//android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[contains(@text,'Work Order')]")
	public MobileElement WO_NUMBER;
	
	 @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'New Work Order')]")
	 public MobileElement SCREEN_HEADER;
	 
	 @AndroidFindBy(id = "com.ifsworld.mworkorderapps9:id/mobile_separate_work_order__site__lbl")
	 public MobileElement WO_SITE_LBL;
	 
	 @AndroidFindBy(id = "com.ifsworld.mworkorderapps9:id/mobile_separate_work_order__site")
	 public MobileElement WO_SITE_TXT;
	 
	 @AndroidFindBy(id = "com.ifsworld.mworkorderapps9:id/mobile_separate_work_order__directive__lbl")
	 public MobileElement WO_DIRECTIVE_LBL;
	 
	 @AndroidFindBy(id = "com.ifsworld.mworkorderapps9:id/mobile_separate_work_order__directive")
	 public MobileElement WO_DIRECTIVE_TXT;
	 
	 @AndroidFindBy(id = "com.ifsworld.mworkorderapps9:id/mobile_separate_work_order__org_code_desc__lbl")
	 public MobileElement MAINT_ORG_LBL;
	 
	 @AndroidFindBy(id = "com.ifsworld.mworkorderapps9:id/mobile_separate_work_order__org_code_desc")
	 public MobileElement MAINT_ORG_DESC;
}
