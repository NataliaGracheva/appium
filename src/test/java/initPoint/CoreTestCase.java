package initPoint;

import pageObject.CheckElementPageObject;
import pageObject.IOSPageObject;
import pageObject.SearchPageObject;
import pageObject.SwipePageObject;
import io.appium.java_client.AppiumDriver;
import junit.framework.TestCase;


public class CoreTestCase extends TestCase {
    public AppiumDriver driver;
    public Platform platform;

    public SearchPageObject search = new SearchPageObject(driver);
    public SwipePageObject swipe = new SwipePageObject(driver);
    public CheckElementPageObject check = new CheckElementPageObject(driver);
    public IOSPageObject ios = new IOSPageObject(driver);

    @Override
    public void setUp() throws Exception {
        super.setUp();
        this.platform = new Platform();
        driver = this.platform.getDriver();
    }

    @Override
    public void tearDown() throws Exception {
        super.tearDown();
        driver.quit();
    }
}