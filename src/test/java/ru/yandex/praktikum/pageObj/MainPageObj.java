package ru.yandex.praktikum.pageObj;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static ru.yandex.praktikum.basic.Constants.SCOOTER_URL;

public class MainPageObj {
    private final WebDriver driver;
    private By cookieButton = By.id("rcc-confirm-button");
    private By orderButtonOnTop = By.className("Button_Button__ra12g");
    private By orderButtonOnDown = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");
    private By orderStatusButton = By.xpath(".//button[@class='Header_Link__1TAG7' and text()='Статус заказа']");
    private By orderNumberInput = By.xpath(".//input[@class='Input_Input__1iN_Z Header_Input__xIoUq' and @placeholder='Введите номер заказа']");
    private By goButton = By.xpath(".//button[@class='Button_Button__ra12g Header_Button__28dPO' and text()='Go!']");
    private By scooterAnchor = By.className("Header_LogoScooter__3lsAR");
    private By yaAnchor = By.className("Header_LogoYandex__3TSOI");

    public MainPageObj(WebDriver driver) {
        this.driver = driver;
    }

    public MainPageObj acceptCookie() {
        driver.findElement(cookieButton).click();
        return this;
    }

    public MainPageObj clickOnTopOrderButton() {
        driver.findElement(orderButtonOnTop).click();
        return this;
    }

    public MainPageObj clickOnBottomOrderButton() {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(orderButtonOnDown));
        driver.findElement(orderButtonOnDown).click();
        return this;
    }

    public MainPageObj clickOnOrderStatus() {
        driver.findElement(orderStatusButton).click();
        return this;
    }

    public MainPageObj fillOrderNumber(String orderNumber) {
        driver.findElement(orderNumberInput).sendKeys(orderNumber);
        return this;
    }

    public MainPageObj waitOrderStatusElements() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(orderNumberInput));
        return this;
    }

    public MainPageObj clickGoButton() {
        driver.findElement(goButton).click();
        return this;
    }

    public MainPageObj clickScooterAnchor() {
        driver.findElement(scooterAnchor).click();
        return this;
    }

    public MainPageObj clickYaAnchor() {
        driver.findElement(yaAnchor).click();
        return this;
    }

    public boolean isMainPage() {
        return driver.getCurrentUrl().equals(SCOOTER_URL);
    }
}