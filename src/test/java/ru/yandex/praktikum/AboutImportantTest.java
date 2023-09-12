package ru.yandex.praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.praktikum.basic.BasicTest;
import ru.yandex.praktikum.pageObj.AboutImportantPageObj;
import ru.yandex.praktikum.pageObj.MainPageObj;

import static org.junit.Assert.assertEquals;
import static ru.yandex.praktikum.basic.Constants.SCOOTER_URL;

@RunWith(Parameterized.class)
public class AboutImportantTest extends BasicTest {

    private final int id;
    private final boolean answerDisplayed;

    public AboutImportantTest(int id, boolean answerDisplayed) {
        this.id = id;
        this.answerDisplayed = answerDisplayed;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                {0, true}, {1, true}, {2, true},
                {3, true}, {4, true}, {5, true},
                {6, true}, {7, true},
        };
    }

    @Test
    public void shouldShowTextOnClick() {
        driver.get(SCOOTER_URL);

        MainPageObj mainPage = new MainPageObj(driver);
        mainPage.acceptCookie();

        AboutImportantPageObj infoPage = new AboutImportantPageObj(driver);
        infoPage.scrollToImportant();
        infoPage.clickOnQuestion(id);
        assertEquals(String.format("На %d вопросе не показывается ответ", id), answerDisplayed, infoPage.answerOnQuestion(id));
    }
}