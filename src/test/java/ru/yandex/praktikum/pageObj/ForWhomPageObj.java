package ru.yandex.praktikum.pageObj;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ForWhomPageObj {
    private WebDriver driver;
    private By firstNameInput = By.xpath(".//input[contains(@placeholder,'* Имя')]");
    private By lastNameInput = By.xpath(".//input[contains(@placeholder,'* Фамилия')]");
    private By addressInput = By.xpath(".//input[contains(@placeholder,'* Адрес: куда привезти заказ')]");
    private By metroStationDiv = By.className("select-search__input");
    private By phoneInput = By.xpath(".//input[contains(@placeholder,'* Телефон: на него позвонит курьер')]");
    private By nextButton = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");

    public ForWhomPageObj(WebDriver driver) {
        this.driver = driver;
    }

    public ForWhomPageObj fillNameInput(String firstName) {
        driver.findElement(firstNameInput).sendKeys(firstName);
        return this;
    }

    public ForWhomPageObj fillLastNameInput(String lastName) {
        driver.findElement(lastNameInput).sendKeys(lastName);
        return this;
    }

    public ForWhomPageObj fillAddressInput(String addres) {
        driver.findElement(addressInput).sendKeys(addres);
        return this;
    }

    public ForWhomPageObj clickOnMetro(String metro) {
        driver.findElement(metroStationDiv).click();
        driver.findElement(By.xpath(String.format(".//button[contains(.,'%s')]", metro))).click();
        return this;
    }

    public ForWhomPageObj fillPhoneInput(String phone) {
        driver.findElement(phoneInput).sendKeys(phone);
        return this;
    }

    public ForWhomPageObj clickNext() {
        driver.findElement(nextButton).click();
        return this;
    }
}