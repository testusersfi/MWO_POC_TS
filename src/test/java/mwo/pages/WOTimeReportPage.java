package mwo.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.PageFactory;
import com.appium.base.PageBase;
import com.appium.base.Utils;
import com.relevantcodes.extentreports.LogStatus;
import com.appium.reports.ExtentTestManager;
import mwo.pageobjects.WOPreviewPageObjects;
import mwo.pageobjects.WOTimeReportPageObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WOTimeReportPage extends PageBase {

	WOTimeReportPageObjects timeReportPageObjects = new WOTimeReportPageObjects();

	public WOTimeReportPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), timeReportPageObjects);
	}
	
	
}
