package mwo.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class LoginPageObjects {

  @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'com.ifsworld.mworkorderapps9:id/alertTitle') and @text='IFS Mobile Work Order']")
  public MobileElement LOGIN_ALERT_TITLE;

  @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'android:id/message') and contains(@text,'Thanks for installing IFS Mobile Work Order')]")
  public MobileElement LOGIN_ALERT_MESSAGE;

  @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id,'android:id/button1') and @text='Continue']")
  @iOSFindBy(xpath = "//UIAButton[contains(@name,'MyButton')]")
  public MobileElement ALERT_CONTINUE_BUTTON;

  @AndroidFindBy(
      xpath = "//android.widget.TextView[contains(@text, 'mWorkOrder')]")
  public MobileElement ACTION_BAR_TITLE;
  
  
  @AndroidFindBy(
	      xpath = "//android.widget.EditText[contains(@resource-id,'com.ifsworld.mworkorderapps9:id/directoryId')]")
  public MobileElement LOGIN_USERID_FIELD;
  
  @AndroidFindBy(
	      xpath = "//android.widget.EditText[contains(@resource-id,'com.ifsworld.mworkorderapps9:id/password')]")
  public MobileElement LOGIN_PASSWORD_FIELD;
  
  @AndroidFindBy(
	      xpath = "//android.widget.EditText[contains(@resource-id,'com.ifsworld.mworkorderapps9:id/serviceUrl')]")
  public MobileElement LOGIN_SERVICEURL_FIELD;
  
  @AndroidFindBy(
	      xpath = "//android.widget.EditText[contains(@resource-id,'com.ifsworld.mworkorderapps9:id/systemId')]")
  public MobileElement LOGIN_SYSTEMID_FIELD;
  
  @AndroidFindBy(
	      xpath = "//android.widget.Button[contains(@resource-id,'com.ifsworld.mworkorderapps9:id/activate')]")
  public MobileElement LOGIN_ACTIVATE_BUTTON;
  
  @AndroidFindBy(
	      xpath = "//android.widget.Button[contains(@resource-id,'com.ifsworld.mworkorderapps9:id/signIn') and contains(@text,'Login')]")
  public MobileElement LOGIN_SIGNIN_BUTTON;
  
  @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'android:id/message') and contains(@text,'Activating')]")
  public List<WebElement> ACTIVATING_MESSAGE;
  
  @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'android:id/message') and contains(@text,'Initializing')]")
  public List<WebElement> SYNC_INITIALIZING_MESSAGE;
  
  @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'android:id/message') and contains(@text,'You have entered an invalid username and/or password')]")
  public MobileElement INVALID_ACTIVATION_ERROR;
  
  @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id,'android:id/button1') and @text='OK']")
  @iOSFindBy(xpath = "//UIAButton[contains(@name,'OK')]")
  public MobileElement ALERT_OK_BUTTON;
  
  
  @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'android:id/message') and contains(@text,'Something went wrong trying to communicate with IFS')]")
  public MobileElement INVALID_LOGIN_ERROR;
  
  

}
