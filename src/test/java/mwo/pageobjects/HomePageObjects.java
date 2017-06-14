package mwo.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class HomePageObjects {

  @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'mWorkOrder')]")
  @iOSFindBy(xpath = "//UIASTATICTEXT[@text='mWorkOrder'")
  public MobileElement SCREEN_HEADER;
  
  @AndroidFindBy(id = "com.ifsworld.mworkorderapps9:id/system_menu_help")
  @iOSFindBy(xpath = "//UIASTATICTEXT[@text='Welcome to Home Screen'")
  public MobileElement SYSTEM_MENU_HELP;
  

  
  //@AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/tasks') and contains(@text, 'Work Orders')]")
  @AndroidFindBy(id = "com.ifsworld.mworkorderapps9:id/tasks")
  public MobileElement WORK_ORDERS_BUTTON;
  
  //@AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/sync') and contains(@text, 'Sync')]")
  @AndroidFindBy(id = "com.ifsworld.mworkorderapps9:id/sync")
  public MobileElement SYNC_BUTTON;
  
  @AndroidFindBy(id = "com.ifsworld.mworkorderapps9:id/newWorkOrder")
  public MobileElement NEW_WORK_ORDER_BUTTON;
  
  @AndroidFindBy(id = "com.ifsworld.mworkorderapps9:id/admin")
  public MobileElement ADMIN_BUTTON;
  
  @AndroidFindBy(id = "com.ifsworld.mworkorderapps9:id/measures")
  public MobileElement MEASURES_BUTTON;
  
  /* @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Sync') and contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/title')]")
  public MobileElement MENU_SYNC_BUTTON;
  
  @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc,'More options')]")
  @iOSFindBy(xpath = "//UIASTATICTEXT[@text='More options'")
  public MobileElement MORE_OPTIONS_ICON; */

}
