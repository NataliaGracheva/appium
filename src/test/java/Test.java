import PageObject.Main;
import initPoint.CoreTestCase;
import org.junit.Assert;
import org.openqa.selenium.*;


public class Test extends CoreTestCase {
    public Main mainMethods;

    public void setUp() throws Exception {
        super.setUp();
        mainMethods = new Main(driver);
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    @org.junit.Test // тест, использующий метод для работы с разными локаторами
    public void test_find_film() {
        search.clickSearch();
        search.typeText("Boris");
        search.clickFilm("Boris");
    }

    @org.junit.Test // тест, использующий метод для очистки поля ввода
    public void test_search_and_clear() {
        search.clickSearch();
        search.typeText("film");

        String actual = search.getInputText();
        Assert.assertEquals(
                "Поле не содержит текст",
                "film",
                actual
        );

        search.clearInput();

        String actual2 = search.getInputText().trim();
        Assert.assertTrue(
                "Поле не пустое",
                actual2.isEmpty()
        );
    }

    @org.junit.Test // тест отмены поиска, использует метод, который проверяет, что элемента нет на экране
    public void test_cancel_search() {
        search.clickSearch();
        search.typeText("Boris");
        check.checkVisibility("Boris - Il film");
        search.clickCollapse();
        search.clickGoUp();
        check.checkMissing("Boris - Il film");
    }

    @org.junit.Test
    public void test_login() {
        Main.getEmail(10);
        Main.getPassword(10);
    }

    @org.junit.Test
    public void test_swipe_up() {
        swipe.swipeToFilm("Made in Italy");
    }

    @org.junit.Test // тест, проверяющий запуск в горизонтальной ориентации и свайп вправо
    public void test_rotate_and_swipe_right() {
        driver.rotate(ScreenOrientation.LANDSCAPE);
        swipe.swipeToRight(3);
        check.checkVisibility("Tenet");
    }

}
