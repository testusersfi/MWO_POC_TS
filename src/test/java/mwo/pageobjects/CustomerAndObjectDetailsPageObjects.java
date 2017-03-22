package mwo.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CustomerAndObjectDetailsPageObjects {
	
	 @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Customer and Object Details')]")
	 public MobileElement CUSTOMER_OBJECT;
	 
	 @AndroidFindBy(id = "com.ifsworld.mworkorderapps9:id/mobile_separate_work_order__customer_id__lbl")
	 public MobileElement CUSTOMER_NUMBER;
	
	 @AndroidFindBy(id = "com.ifsworld.mworkorderapps9:id/mobile_separate_work_order__object_id__lbl")
	 public MobileElement OBJECT_ID_LABEL;
	 
	 @AndroidFindBy(id = "com.ifsworld.mworkorderapps9:id/mobile_separate_work_order__object_id")
	 public MobileElement OBJECT_ID;
	
	 @AndroidFindBy(id = "com.ifsworld.mworkorderapps9:id/mobile_separate_work_order__contact__lbl")
	 public MobileElement CUSTOMER_CONTACT;
	 
	 @AndroidFindBy(id = "com.ifsworld.mworkorderapps9:id/mobile_separate_work_order__phone__lbl")
	 public MobileElement PHONE_NUMBER;
}
