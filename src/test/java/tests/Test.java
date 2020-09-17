package tests;

import initPoint.CoreTestCase;
import initPoint.testCases.AndroidTestCase;
import org.junit.Assert;
import org.openqa.selenium.ScreenOrientation;
import pageObject.Main;

public class Test extends CoreTestCase {
    public Main mainMethods;

    public void setUp() throws Exception {
        super.setUp();
        mainMethods = new Main(driver);
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    // android
    @org.junit.Test
    public void test_swipe_up() {
        if(this.platform.isIOS()) {
            return;
        }
        swipe.swipeToFilm("Scoob!", 15);
    }

    // iOS
    @org.junit.Test
    public void test_demo() {
        if(this.platform.isAndroid()) {
            return;
        }
        ios.init_demo();
    }

}
