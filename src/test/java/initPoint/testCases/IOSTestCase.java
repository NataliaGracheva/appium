package initPoint.testCases;

import pageObject.IOSPageObject;
import io.appium.java_client.ios.IOSDriver;
import junit.framework.TestCase;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;


public class IOSTestCase extends TestCase {
    public IOSDriver driver;
    public String AppiumUrl = " http://0.0.0.0:4723/wd/hub";
    public IOSPageObject ios = new IOSPageObject(driver);

    @Override
    public void setUp() throws Exception {
        super.setUp();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "IOS");
        capabilities.setCapability("platformVersion", "12.0");
        capabilities.setCapability("deviceName", "iPhone X");
        capabilities.setCapability("app", "/Users/n.gracheva/Desktop/ios_app/AlfaStrah.app");
        capabilities.setCapability("autoAcceptAlerts", "true");
        capabilities.setCapability("noReset", "true");

        driver = new IOSDriver(new URL(AppiumUrl), capabilities);
    }

    @Override
    public void tearDown() throws Exception {
        super.tearDown();
        driver.quit();
    }
}