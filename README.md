# POC Test Automation Suite
MWO test automation suite is built in Java using Appium Java Client (Appium 1.6.3). The design is based on Page Object Model, with separate classes for Page Objects and Pages. Testers can run the tests as a Test NG tests 
The TestNG based tests are in the "mwo.tests" package. The " testng_mwo.xml" file at the root is used to configure the test classes / groups to be included in the test run.
Additional configuration options are possible from 'build.properties'. A user can also have a 'local.properties' file that is not in version control, but over-rides the 'build.properties' at run-time. This is so that the build.properties could be kept intact, while allowing each test developer to customize using 'local.properties'.
The Appium server is automatically launched from the java code (using the @BeforeSuite annotation). This means that the tester doesn't have to launch Appium.app before running the tests.
Ant is primarily used for packaging, test execution and generation of TestNG XSLT reports. 
As for Test Reporting, the amazing 'Extent Reports' (version 2.41.2) framework is used. This provides the ability to capture screenshots and embed those screenshots in the test reports. The TestNG reports are available at 'test-output' and 'test-xslt-output' directory. Extent Reports logs are generated at 'test-extentreport' directory. Date-wise TestNG logs are stored at 'testng-reports' and 'testng-xslt-reports' directories.


## Tools Used
•	Appium (1.6.3)
•	Test NG
•	Extent Reporting (2.41.2)
•	Ant
•	Java
•	TestNG XLST Reporting
•	Checkstyle (http://eclipse-cs.sourceforge.net/#!/install)


## Notes for Test Developers
•	The test code resides in src/test/java while the main framework code resides in src/main/java.
•	Follow the package naming conventions - APPNAME.pageobjects, pages and tests
•	The base class of all the page classes should be 'PageBase' and tests should be 'TestBase' 
•	The ClassNames should begin with Capital and have camel case. The methodNames should begin with small letter and should be in camel case.
•	The APPNAME property should have mwo. The app_APPNAME.properties and testng_APPNAME.xml should be created for the app.
•	Config.properties file contains the path of the node.exe and main.js, app_appname.properties contains application specific properties like appPackage, appActivity, appLocation, Device_ID, Android OS version
•	The property values in config.properties and overridden by app_APPNAME.properties, which are then overridden by local.properties. Finally command line args override everything. Note that ant scripts write the command line args to local.properties. The file local.properties is ignored from being submitted to git.
•	For execution of Android tests, download the .apk and place it under binaries folder and update the APK file path in app_APPNAME.properties. 
•	To run the tests on Android Emulator, ensure the correct version of chrome driver is used for the tests (using CHROME_DRIVER_EXECUTABLE property) corresponding to the 'Android System WebView' version. The Android real devices should have latest version of Chrome browser installed.
•	For executing the tests on single device, change the base class of 'TestBase' to 'TestBaseStandalone'. This is the current set-up, but investigations are on to set this up dynamically.

## Basic Flow of Test
@beforeSuite // This is defined in TestBase class
// Start Appium Server
// Initiate Extent Reports logfile

@beforeMethod // This is defined in TestBase class
// Initiate Appium Driver
// Start Extent Test

@Test // This is defined in your XxxTest class that extends TestBase class
// Run your testMethod1 (interactions with pages, assertions)

@afterMethod // This is defined in TestBase class
// Start Extent Test* End Extent Test
// Quit Driver

@beforeMethod // This is defined in TestBase class
// Initiate Appium Driver
// Start Extent Test

@Test // This is defined in your XxxTest class that extends TestBase class
// run your testMethod2 (interactions with pages, assertions)

@afterMethod // This is defined in TestBase class
// End Extent Test
// Quit Driver

@afterSuite // This is defined in TestBase class
// Finalise / close Extent Reports logfile
// Stop Appium Server


## References:

Open Source Integrations / Reference code used
•	https://github.com/anshooarora/extentreports-java
•	https://github.com/bratgatty/appium-commoncode-mobile
•	https://github.com/saikrishna321/PageObjectPatternAppium
•	https://github.com/saikrishna321/AppiumTestDistribution

Document References
•	http://appium.io/slate/en/master/?java#
•	http://extentreports.relevantcodes.com/java/