package PageObject;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SearchPageObject extends Main {
    public final static String
            searchButton = "dev.akat.filmreel:id/menu_search_action",
            searchInput = "dev.akat.filmreel:id/search_src_text",
            currentFilm = "//*[contains(@text, '{substring}')]",
            collapseButton = "//android.widget.ImageButton[@content-desc=\"Свернуть\"]",
            goUpButton = "//android.widget.ImageButton[@content-desc=\"Перейти вверх\"]";

    public SearchPageObject(AppiumDriver driver) {
        super(driver);
    }

    public void clickSearch() {
        this.waitForElement(
                By.id(searchButton),
                "Не смог найти кнопку поиска",
                5
        ).click();
    }

    public void typeText(String search_value) {
        this.waitForElement(
                By.id(searchInput),
                "Не смог найти поле ввода",
                10
        ).sendKeys(search_value);
    }

    public void clickFilm(String film) {
        String xPath = currentFilm.replace("{substring}", film);
        this.waitForElement(
                By.xpath(xPath),
                "Не смог найти фильм " + film,
                10
        ).click();
    }

    public String getInputText() {
         return this.waitForElement(
                By.id(searchInput),
                "Не смог найти поле ввода",
                10
        ).getText();
    }

    public void clearInput() {
        this.waitForFieldAndClear(
                By.id(searchInput),
                5
        );
    }

    public void clickCollapse() {
        this.waitForElement(
                By.xpath(collapseButton),
                "Не смог найти кнопку Свернуть",
                5
        ).click();
    }

    public void clickGoUp() {
        this.waitForElement(
                By.xpath(goUpButton),
                "Не смог найти кнопку Перейти вверх",
                5
        ).click();
    }

}
