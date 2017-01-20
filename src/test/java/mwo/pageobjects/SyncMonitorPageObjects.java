package mwo.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class SyncMonitorPageObjects {

  @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'com.ifsworld.mworkorderapps9:id/sync__datatype') and @text='Error']")
  public MobileElement SYNC_FAILURE_ERROR;

  @AndroidFindBy(xpath = "//android.view.View/android.widget.TextView[@text='Sync Monitor']")
  public MobileElement ACTION_BAR_TITLE;
  
}