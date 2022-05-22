package ru.mail.go.ui.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchSteps {
    @Given("the user open go.mail website")
    public void openMailWebsite() {
    }

    @When("the user send search request  {string}")
    public void sendSearchRequest(String cityName) {
    }

    @Then("search result contains {string}")
    public void verifySearchResultContainName(String cityName) {
    }

    @And("search result contains link {string}")
    public void verifySearchResultContainsLink(String URL) {
    }
}
