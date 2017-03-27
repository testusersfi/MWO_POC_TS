package mwo.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;


public class SyncMonitorPageObjects {

  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.ifsworld.mworkorderapps9:id/sync__datatype' and contains(@text, 'Error')]")
  public MobileElement SYNC_FAILED_MESSAGE;

  @AndroidFindBy(xpath = "//android.view.View/android.widget.TextView[@text='Sync Monitor']")
  public MobileElement ACTION_BAR_TITLE;
  
  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.ifsworld.mworkorderapps9:id/sync__datatype' and contains(@text, 'Sync Ended')]")
  public MobileElement SYNC_COMPLETED_MESSAGE;

  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.ifsworld.mworkorderapps9:id/sync__datatype' and contains(@text, 'Error')]")
  public List<WebElement> SYNC_FAILURE_ERROR;
}