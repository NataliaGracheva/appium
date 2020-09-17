package pageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class Main {
    public static AppiumDriver driver;

    public Main(AppiumDriver driver) {
        this.driver = driver;
    }

    // универсальный метод поиска элемента для работы с разными локаторами
    public static WebElement waitForElement(By by, String error_message, long timeOutInSecond) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
        wait.withMessage(error_message + "\n");

        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }

    // метод который ищет элемент (input) и очищает его
    public static void waitForFieldAndClear(By by, long timeOutInSecond) {
        WebElement element = waitForElement(
                by,
                "Не получилось найти поле ввода",
                timeOutInSecond
        );
        element.clear();
    }

    // метод, который проверяет что элемента нет на странице (экране)
    public static void waitForElementNotPresent(By by, String error_message, long timeOutInSecond) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
        wait.withMessage(error_message + "\n");

        wait.until(
                ExpectedConditions.invisibilityOfElementLocated(by)
        );
        System.out.println("все ок - элемент не найден");
    }

    // метод, который проверяет что элемент есть на странице (экране)
    public static void waitForElementPresent(By by, String error_message, long timeOutInSecond) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
        wait.withMessage(error_message + "\n");

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(by)
        );
        System.out.println("все ок - элемент найден");
    }

    // метод для генерации email
    public static String getEmail(int length) {
        // https://en.wikipedia.org/wiki/Email_address
        // max 64
        String[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXWZabcdefghijklmnopqrstuvwxyz0123456789".split("");
        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            String c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }

        sb.append("@mail.ru");
        String email = sb.toString();
        System.out.println("Email: " + email);
        return email;
    }

    // метод для генерации пароля
    public static String getPassword(int length) {
        String[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXWZabcdefghijklmnopqrstuvwxyz0123456789".split("");
        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            String c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }

        String pass = sb.toString();
        System.out.println("Password: " + pass);
        return pass;
    }

    // метод для свайпа вверх
    public static void swipeUp() {
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();

        int x = size.width/2;
        int start_y = (int) (size.height*0.8);
        int end_y = (int) (size.height*0.2);

        action
                .press(PointOption.point(x, start_y))
                .waitAction()
                .moveTo(PointOption.point(x, end_y))
                .release()
                .perform();
    }

    // метод для прокрутки списка и поиска элемента
    public static void swipeUpToFindElement(By by, String error_message, int max_swipes) {
        int count = 1;

        while (driver.findElements(by).size() == 0) {
            if (count > max_swipes) {
                waitForElement(by, "Закончились свайпы. " + error_message, 5);
            }
            swipeUp();
            ++count;
        }
    }

    // метод для свайпа вправо
    public static void swipeToRight(int count) {
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();

        int start_x = (int) (size.width*0.8);
        int end_x = (int) (size.width*0.2);
        int y = size.height/2;

        for (int i = 0; i<count; i++) {
            action
                    .press(PointOption.point(start_x, y))
                    .waitAction()
                    .moveTo(PointOption.point(end_x, y))
                    .release()
                    .perform();
        }
    }
}
