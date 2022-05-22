package ru.mail.go.ui.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "pretty",
        monochrome = true,
        tags="@smoke",
        glue = "ru.mail.go.ui",
        features = "classpath:ru/mail/go/features"
)
public class CucumberTestRunner {
}
