package ru.yandex.praktikum.pageObj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmPageObj {
    private WebDriver driver;
    private By confirmButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");
    private By decline = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM Button_Inverted__3IF-i' and text()='Нет']");

    public ConfirmPageObj(WebDriver driver) {
        this.driver = driver;
    }

    public ConfirmPageObj confirmOrder() {
        driver.findElement(confirmButton).click();
        return this;
    }
}