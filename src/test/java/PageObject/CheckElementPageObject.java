package PageObject;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class CheckElementPageObject extends Main {
    public final static String
            targetElement = "//*[contains(@text, '{substring}')]";

    public CheckElementPageObject(AppiumDriver driver) {
        super(driver);
    }

    public void checkMissing(String text) {
        String xPath = targetElement.replace("{substring}", text);
        this.waitForElementNotPresent(
                By.xpath(xPath),
                "Найден элемент с текстом " + text,
                10
        );
    }

    public void checkVisibility(String text) {
        String xPath = targetElement.replace("{substring}", text);
        this.waitForElementPresent(
                By.xpath(xPath),
                "Не найден элемент с текстом " + text,
                10
        );
    }

}
