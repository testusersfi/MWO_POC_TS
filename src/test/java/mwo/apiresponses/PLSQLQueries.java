package mwo.apiresponses;

import ifs.fnd.ap.Record;
import ifs.fnd.ap.RecordAttribute;
import ifs.fnd.ap.PlsqlCommand;
import ifs.fnd.ap.PlsqlCommandCollection;
import ifs.fnd.ap.PlsqlSelectCommand;
import ifs.fnd.ap.PlsqlBaseMethodCommand;
import ifs.fnd.ap.PlsqlBaseMethodAction;
import ifs.fnd.ap.PlsqlBaseMethodType;
import ifs.fnd.ap.RecordCollection;
import java.util.Properties;
import java.util.Scanner;
import ifs.fnd.ap.APException;
import ifs.fnd.ap.BindVariableDirection;
import ifs.fnd.ap.FndServerConnection;
import java.io.File;
import java.io.FileNotFoundException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import com.appium.base.PageBase;
import com.appium.reports.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

public class PLSQLQueries {
	public static String wo_number;
	public static Record bindVars;
	static PageBase basePage;
	public static String createWorkOrder() throws FileNotFoundException, KeyManagementException, NoSuchAlgorithmException {
		TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
			@Override
			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				return null;
			}

			@Override
			public void checkClientTrusted(X509Certificate[] certs, String authType) {
			}

			@Override
			public void checkServerTrusted(X509Certificate[] certs, String authType) {
			}
		} };

		// Install the all-trusting trust manager
		SSLContext sc = SSLContext.getInstance("SSL");
		sc.init(null, trustAllCerts, new java.security.SecureRandom());
		HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

		// Create all-trusting host name verifier
		HostnameVerifier allHostsValid = new HostnameVerifier() {
			public boolean verify(String hostname, SSLSession session) {
				return true;
			}
		};
		try {
			Properties props = System.getProperties();
			props.setProperty("com.sun.net.ssl.checkRevocation", "false");
			System.setProperty("javax.net.ssl.trustStore", "C:/Progra~1/Java/jdk1.8.0_121/jre/lib/security/cacerts");
			System.setProperty("javax.net.ssl.trustStorePassword", "changeit");

			// Create a server Connection
			System.out.println("Creating ServerConnection...");
			// Server2 srvConn = new Server2();
			FndServerConnection srvConn = new FndServerConnection();
			//srvConn.setConnectionString("http://ldnpvgbm1036-2.corpnet.ifsworld.com:61080");
			srvConn.setConnectionString("http://ldnaccngsdev1:58080");
			srvConn.setCredentials("ACC_UKUSER", "ACC_UKUSER");

			if (srvConn.connect()) {
				System.out.println("ServerConnection Created.");
				// PlsqlSelectCommand cmd = new PlsqlSelectCommand(srvConn.srv,
				// "SELECT mch_code FROM IFSAPP.maintenance_object_lov WHERE
				// connection_type = 'EQUIPMENT'");
				String content = new Scanner(new File("C:\\Users\\srinivas.bavirisetti\\workspace\\mwo_app_tests\\pl_sql_scripts\\create_wo.sql")).useDelimiter("\\Z").next();
				System.out.println(content);
				PlsqlCommand command = new PlsqlCommand(srvConn.srv, content);
				Record bindVars = command.getBindVariables();
				bindVars.add("out_result").setBindVariableDirection(BindVariableDirection.OUT);
				command.execute();
				String wo_number = bindVars.find("out_result").getString();
				System.out.println("work_order_number:"+ wo_number);
				if(wo_number != null) {
				ExtentTestManager.getTest().log(LogStatus.PASS, " created Work order number using PLSQL script and work order number is "+ wo_number);
				return bindVars.find("out_result").getString();
				} else {
					ExtentTestManager.getTest().log(LogStatus.FAIL, "creating work order is failed");
				}
				srvConn.disconnect();		
			} else
				System.out.println("ServerConnection Not Created.");
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to establish the database connection");
		} catch (APException err) {
			err.printStackTrace(System.out);
		}
		
		return null;
	}
	
}
