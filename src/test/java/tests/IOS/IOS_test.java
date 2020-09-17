package tests.IOS;

import pageObject.Main;
import initPoint.testCases.IOSTestCase;

public class IOS_test extends IOSTestCase {
    public Main mainMethods;

    public void setUp() throws Exception {
        super.setUp();
        mainMethods = new Main(driver);
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    @org.junit.Test // не работает при noReset
    public void test_ios() {
        ios.click_close_btn();
    }

    @org.junit.Test
    public void test_demo() {
        ios.init_demo();
    }
}
