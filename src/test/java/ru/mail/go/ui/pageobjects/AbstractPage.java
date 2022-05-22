package ru.mail.go.ui.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.mail.go.ui.driver.DriverSingleton;

public class AbstractPage {
    protected WebDriver driver;
    protected static final Logger logger = LogManager.getLogger();

    protected AbstractPage() {
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }
}
