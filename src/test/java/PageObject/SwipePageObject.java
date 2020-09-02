package PageObject;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SwipePageObject extends Main {
    public final static String
            searchedFilm = "//*[contains(@text, '{substring}')]";

    public SwipePageObject(AppiumDriver driver) {
        super(driver);
    }

    public void swipeToFilm(String film) {
        String xPath = searchedFilm.replace("{substring}", film);
        this.swipeUpToFindElement(
                By.xpath(xPath), "Не смог найти фильм " + film, 3
        );
    }

    public void swipeToRight(String count) {
        this.swipeToRight(count);
    }

}
