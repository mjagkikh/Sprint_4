package ru.yandex.praktikum.pageObj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderSuccessPageObj {
    private WebDriver driver;
    private By orderCompleted = By.className("Order_ModalHeader__3FDaJ");
    private By orderNumber = By.className("Order_Text__2broi");

    public OrderSuccessPageObj(WebDriver driver) {
        this.driver = driver;
    }

    public boolean orderExist() {
        WebElement element = driver.findElement(orderCompleted);
        String text = element.getText();
        return text.contains("Заказ оформлен");
    }

    public String getOrderNumber() {
        WebElement element = driver.findElement(orderNumber);
        String text = element.getText();
        String number = text.substring(14, 20);
        return number;
    }
}