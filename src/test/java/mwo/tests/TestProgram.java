package mwo.tests;

import java.io.File;
import java.io.FileOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;

public class TestProgram {
	public static AppiumDriver<MobileElement> driver;
	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		
		caps.setCapability("deviceName", "9111833b");
	    caps.setCapability("platformVersion", "5.0.2");
	    caps.setCapability("app", System.getProperty("user.dir") + "/build/wordpress.apk");
	    caps.setCapability("package", "org.wordpress.android");
	    caps.setCapability("appActivity", "org.wordpress.android.ui.WPLaunchActivity");
	    caps.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY,
	        "org.wordpress.android.ui.accounts.SignInActivity");
	    driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
	}



public void excelwriting() {
	XSSFWorkbook workbook = new XSSFWorkbook();
	XSSFSheet sheet = workbook.createSheet("Mobile WorkOrders");
	Map<String, Object[]> data = new TreeMap<String, Object[]>();
	data.put("1", new Object[] {"S.NO", "WO_NUMBER", "DIRECTIVE_TEXT"});
	data.put("2", new Object[] {"1", "A11111", "testing testing"});
	//Iterate over data and write to sheet
			Set<String> keyset = data.keySet();
			int rownum = 0;
			for (String key : keyset)
			{
			    Row row = sheet.createRow(rownum++);
			    Object [] objArr = data.get(key);
			    int cellnum = 0;
			    for (Object obj : objArr)
			    {
			       Cell cell = row.createCell(cellnum++);
			       if(obj instanceof String)
			            cell.setCellValue((String)obj);
			        else if(obj instanceof Integer)
			            cell.setCellValue((Integer)obj);
			    }
			}
			try 
			{
				//Write the workbook in file system
			    FileOutputStream out = new FileOutputStream(new File("C:\\Users\\srinivas.bavirisetti\\workspace\\mwo_app_tests\\WorkOrders_Prepared_From_Mobile.xlsx"));
			    
			    workbook.write(out);
			    out.close();			    
			    System.out.println("WorkOrders_Prepared_From_Mobile.xlsx written successfully on disk.");
			     
			} 
			catch (Exception e) 
			{
			    e.printStackTrace();
			}
}
}
