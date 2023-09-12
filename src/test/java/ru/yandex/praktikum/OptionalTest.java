package ru.yandex.praktikum;

import org.junit.Test;
import ru.yandex.praktikum.basic.BasicTest;
import ru.yandex.praktikum.pageObj.MainPageObj;
import ru.yandex.praktikum.pageObj.OrderStatusPageObj;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static ru.yandex.praktikum.basic.Constants.SCOOTER_URL;

public class OptionalTest extends BasicTest {

    @Test
    public void shouldReturnNoSuchOrder() {
        driver.get(SCOOTER_URL);

        MainPageObj mainPage = new MainPageObj(driver);
        mainPage.acceptCookie();
        mainPage.clickOnOrderStatus().waitOrderStatusElements().fillOrderNumber("abcdef").clickGoButton();
        OrderStatusPageObj orderStatusPage = new OrderStatusPageObj(driver);
        assertEquals(true, orderStatusPage.isNoSuchOrder());
    }

    @Test
    public void shouldMoveToMainPage() {
        driver.get(SCOOTER_URL);

        MainPageObj mainPage = new MainPageObj(driver);
        mainPage.acceptCookie().clickScooterAnchor();
        assertEquals(true, mainPage.isMainPage());
    }

    @Test
    public void shouldMoveToYaPage() {
        driver.get(SCOOTER_URL);

        MainPageObj mainPage = new MainPageObj(driver);
        mainPage.acceptCookie().clickYaAnchor();
        boolean result = false;
        Set<String> windowHandles = driver.getWindowHandles();
        for(String handle:windowHandles) {
            result |= driver.switchTo().window(handle).getCurrentUrl().contains("dzen");
        }
        assertTrue(result);
    }
}