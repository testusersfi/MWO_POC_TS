package mwo.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class HomePageObjects {

  @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'mWorkOrder')]")
  @iOSFindBy(xpath = "//UIASTATICTEXT[@text='mWorkOrder'")
  public MobileElement SCREEN_HEADER;
  
  @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/system_menu_help')]")
  @iOSFindBy(xpath = "//UIASTATICTEXT[@text='Welcome to Home Screen'")
  public MobileElement SYSTEM_MENU_HELP;
  
  @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc,'More options')]")
  @iOSFindBy(xpath = "//UIASTATICTEXT[@text='More options'")
  public MobileElement MORE_OPTIONS_ICON;
  
  @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/tasks') and contains(@text, 'Work Orders')]")
  public MobileElement WORK_ORDERS_BUTTON;

}
