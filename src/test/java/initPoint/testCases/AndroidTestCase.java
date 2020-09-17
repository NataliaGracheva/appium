package initPoint.testCases;

import pageObject.CheckElementPageObject;
import pageObject.SearchPageObject;
import pageObject.SwipePageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;


public class AndroidTestCase extends TestCase {
    public AppiumDriver driver;
    public String AppiumUrl = " http://0.0.0.0:4723/wd/hub";
    public SearchPageObject search = new SearchPageObject(driver);
    public SwipePageObject swipe = new SwipePageObject(driver);
    public CheckElementPageObject check = new CheckElementPageObject(driver);

    @Override
    public void setUp() throws Exception {
        super.setUp();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "7.0");
        capabilities.setCapability("deviceName", "emulator");
        capabilities.setCapability("AutomationName", "Appium");
        capabilities.setCapability("appPackage", "dev.akat.filmreel");
        capabilities.setCapability("appActivity", "com.akat.filmreel.ui.MainActivity");
        capabilities.setCapability("app", "/Users/n.gracheva/Desktop/appium_test/appium/apk/app_debug-116643-84a20f.apk");

        driver = new AndroidDriver(new URL(AppiumUrl), capabilities);
    }

    @Override
    public void tearDown() throws Exception {
        super.tearDown();
        driver.quit();
    }
}