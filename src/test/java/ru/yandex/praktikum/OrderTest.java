package ru.yandex.praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.praktikum.basic.BasicTest;
import ru.yandex.praktikum.basic.ButtonType;
import ru.yandex.praktikum.pageObj.*;

import static org.junit.Assert.assertEquals;
import static ru.yandex.praktikum.basic.Constants.SCOOTER_URL;

@RunWith(Parameterized.class)
public class OrderTest extends BasicTest {
    private final ButtonType buttonType;
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String metroStation;
    private final String phoneNumber;
    private final String orderDate;
    private final int dayCount;
    private final String color;
    private final String comment;
    private final boolean isSuccessfull;

    public OrderTest(ButtonType buttonType, String firstName, String lastName,
                     String address, String metroStation, String phoneNumber,
                     String orderDate, int dayCount, String color,
                     String comment, boolean isSuccessfull) {
        this.buttonType = buttonType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.phoneNumber = phoneNumber;
        this.orderDate = orderDate;
        this.dayCount = dayCount;
        this.color = color;
        this.comment = comment;
        this.isSuccessfull = isSuccessfull;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                {ButtonType.TOP, "Билли", "Херрингтон", "Николаева", "Технопарк", "79134567890", "21.12.2023", 1, "black", "-", true},
                {ButtonType.BOTTOM, "Ван", "Даркхолм", "ул. Инженерная", "ЗИЛ", "89130987654", "21.12.2023", 2, "grey", "с подогревом ручек, пожалуйста", true},
        };
    }

    @Test
    public void shouldCreateOrder() {
        driver.get(SCOOTER_URL);
        MainPageObj mainPage = new MainPageObj(driver);
        switch (buttonType) {
            case TOP: mainPage.acceptCookie().clickOnTopOrderButton();
                break;
            case BOTTOM: mainPage.acceptCookie().clickOnBottomOrderButton();
                break;
        }
        ForWhomPageObj forWhomPage = new ForWhomPageObj(driver);
        forWhomPage.fillNameInput(firstName).fillLastNameInput(lastName)
                .fillAddressInput(address).clickOnMetro(metroStation)
                .fillPhoneInput(phoneNumber).clickNext();
        AboutRentPageObj aboutRentPage = new AboutRentPageObj(driver);
        aboutRentPage.fillDateInput(orderDate)
                .fillTimeInput(dayCount).chooseColor(color).fillComment(comment).confirm();
        ConfirmPageObj confirmPage = new ConfirmPageObj(driver);
        confirmPage.confirmOrder();
        OrderSuccessPageObj orderSuccessPage = new OrderSuccessPageObj(driver);
        assertEquals(isSuccessfull, orderSuccessPage.orderExist());
    }
}