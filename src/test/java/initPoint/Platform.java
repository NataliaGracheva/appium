package initPoint;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Platform {
    public String AppiumUrl = "http://0.0.0.0:4723/wd/hub";
    public final String PLATFORM_IOS = "ios";
    public final String PLATFORM_ANDROID = "android";

    public AppiumDriver getDriver() throws Exception {
        URL url = new URL(AppiumUrl);

        if(this.isAndroid()) {
            return new AndroidDriver(url, this.getAndroidCapabilities());
        } else if(this.isIOS()) {
            return new IOSDriver(url, this.getIOSCapabilities());
        } else {
            throw new Exception("Не знаю, что за драйвер " + this.getPlatform());
        }

    }

    public boolean isAndroid() {
        return isPlatform(PLATFORM_ANDROID);
    }

    public boolean isIOS() {
        return isPlatform(PLATFORM_IOS);
    }

    public DesiredCapabilities getAndroidCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "7.0");
        capabilities.setCapability("deviceName", "emulator");
        capabilities.setCapability("AutomationName", "Appium");
        capabilities.setCapability("appPackage", "dev.akat.filmreel");
        capabilities.setCapability("appActivity", "com.akat.filmreel.ui.MainActivity");
        capabilities.setCapability("app", "/Users/n.gracheva/Desktop/appium_test/appium/apk/app_debug-116643-84a20f.apk");
        return capabilities;
    }

    public DesiredCapabilities getIOSCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "IOS");
        capabilities.setCapability("platformVersion", "12.0");
        capabilities.setCapability("deviceName", "iPhone X");
        capabilities.setCapability("app", "/Users/n.gracheva/Desktop/ios_app/AlfaStrah.app");
        capabilities.setCapability("autoAcceptAlerts", "true");
        capabilities.setCapability("noReset", "true");
        return capabilities;
    }

    public String getPlatform() {
        return System.getenv("PLATFORM");
    }

    public boolean isPlatform(String my_platform) {
        String platform = this.getPlatform();
        return my_platform.equals(platform);
    }

}
