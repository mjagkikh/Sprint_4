package ru.yandex.praktikum.pageObj;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AboutImportantPageObj {
    private WebDriver driver;

    private By title = By.className("Home_FourPart__1uthg");

    private String questionId = "accordion__heading-%d";
    private String answerId = "accordion__panel-%d";

    public AboutImportantPageObj(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollToImportant() {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(title));
    }

    public void clickOnQuestion(int id) {
        driver.findElement(By.id(String.format(questionId, id))).click();
    }

    public boolean answerOnQuestion(int id) {
        WebElement element = driver.findElement(By.id(String.format(questionId, id)));
        if(!element.getText().isEmpty() && element.isDisplayed()) {
            return true;
        }
        return false;
    }
}