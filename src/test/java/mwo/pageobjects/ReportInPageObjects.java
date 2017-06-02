package mwo.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class ReportInPageObjects  {

  @AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView[contains(@text, 'Report In')]")
  @iOSFindBy(xpath = "//UIASTATICTEXT[@text='Report In'")
  public MobileElement SCREEN_HEADER;
  
  @AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView[contains(@text, 'Please Report In your Work Order')]")
  public MobileElement SCREEN_DESCRIPTION;
  
  @AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[contains(@text, 'Report Codes')]")
  public MobileElement REPORT_CODES_SECTION;
  
  @AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[contains(@text, 'Descriptions')]")
  public MobileElement DESCRIPTIONS_SECTION;
  
  public String WORKORDER_NUMBER = "//android.widget.TableLayout[1]/android.widget.TableRow[2]/android.widget.TextView[contains(@resource-id, 'com.ifsworld.mworkorderapps9:id/work_order__wo_no') and @text=\"%s\"]";

}
