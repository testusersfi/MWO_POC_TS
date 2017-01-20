package mwo.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class ReportInPageObjects  {

  @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Work Orders')]")
  @iOSFindBy(xpath = "//UIASTATICTEXT[@text='mWorkOrder'")
  public MobileElement SCREEN_HEADER;
  
  @AndroidFindBy(id = "com.ifsworld.mworkorderapps9:id/item_lookup_barcode")
  @iOSFindBy(xpath = "//UIASTATICTEXT[@text='Welcome to Home Screen'")
  public MobileElement BAR_CODE_SCAN;
  
  @AndroidFindBy(id = "com.ifsworld.mworkorderapps9:id/tasks")
  public MobileElement WORK_ORDERS_BUTTON;
  
  public String WORKORDER_NUMBER = "//android.widget.TableLayout[1]/android.widget.TableRow[2]/android.widget.TextView[contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/work_order__wo_no’) and @text=\"%s\"]";

  @AndroidFindBy(id = "com.ifsworld.mworkorderapps9:id/item_lookup_barcode")
  public MobileElement WORKORDER_BARCODE;
  
  @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/action_button1’) and @text='ACCEPT']")
  public MobileElement ACCEPT_BUTTON;
  
  @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/action_button1’) and @text='ONROUTE']")
  public MobileElement ONROUTE_BUTTON;
  
  @AndroidFindBy(id = "com.ifsworld.mworkorderapps9:id/next")
  public MobileElement NEXT_BUTTON;
  
  
  @AndroidFindBy (xpath = "")
  public MobileElement WO_OVERVIEW_DESCRIPTION;
  
}
