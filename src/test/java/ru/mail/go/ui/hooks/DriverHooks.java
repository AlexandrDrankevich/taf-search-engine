package ru.mail.go.ui.hooks;

import io.cucumber.java.After;
import ru.mail.go.ui.driver.DriverSingleton;

public class DriverHooks {
    @After
    public void tearDown() {
        DriverSingleton.closeDriver();
    }
}
