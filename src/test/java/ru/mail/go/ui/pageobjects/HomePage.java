package ru.mail.go.ui.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    private final String BASE_URL = "https://go.mail.ru/";
    @FindBy(css = "[name=q]")
    WebElement inputSearch;
    @FindBy(css = "[type=submit]")
    WebElement buttonSearch;

    public void openPage() {
        driver.get(BASE_URL);
    }

    public HomePage inputRequestValue(String requestValue) {
        inputSearch.sendKeys(requestValue);
        return this;
    }
    public HomePage clickButtonSearch(){
       ((JavascriptExecutor) driver).executeScript("arguments[0].click();", buttonSearch);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public HomePage sendSearchRequest(String cityName) {
        inputRequestValue(cityName);
        clickButtonSearch();
        return this;
    }
}
