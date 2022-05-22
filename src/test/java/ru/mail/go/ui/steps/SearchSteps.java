package ru.mail.go.ui.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ru.mail.go.ui.pageobjects.HomePage;

public class SearchSteps {
    private HomePage homePage = new HomePage();
    private ResultProcessing resultProcessing =new ResultProcessing();

    @Given("the user open go.mail website")
    public void openMailWebsite() {
        homePage.openPage();
    }

    @When("the user send search request  {string}")
    public void sendSearchRequest(String cityName) {
        homePage.sendSearchRequest(cityName);
    }

    @Then("search result contains {string}")
    public void verifySearchResultContainTitle(String title) {

    }

    @And("search result contains link {string}")
    public void verifySearchResultContainsUrl(String url) {
    }
}
