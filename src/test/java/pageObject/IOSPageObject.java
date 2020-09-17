package pageObject;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class IOSPageObject extends Main {
    public final static String
            closeBtn = "ico close",
            demoBtn = "Демо-режим";

    public IOSPageObject(AppiumDriver driver) {
        super(driver);
    }

    public void click_close_btn() {
        this.waitForElement(
                By.id(closeBtn),
                "Не смог найти кнопку поиска",
                5
        ).click();
    }

    public void init_demo() {
        this.waitForElement(
                By.id(demoBtn),
                "Не смог найти кнопку поиска",
                5
        ).click();
    }
}
