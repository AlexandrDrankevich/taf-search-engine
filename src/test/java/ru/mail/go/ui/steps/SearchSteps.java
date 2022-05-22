package ru.mail.go.ui.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import ru.mail.go.ui.pageobjects.HomePage;
import ru.mail.go.ui.pageobjects.SearchResultPage;

import static org.junit.Assert.assertTrue;

public class SearchSteps {
    private HomePage homePage = new HomePage();
    private ResultProcessing resultProcessing=new ResultProcessing();


    @When("the user open go.mail website")
    public void openMailWebsite() {
        homePage.openPage();
    }

    @When("the user send search request  {string}")
    public void sendSearchRequest(String cityName) {
        homePage.sendSearchRequest(cityName);
    }

    @Then("search result contains {string}")
    public void verifySearchResultContainsTitle(String title) {
        resultProcessing.createSearchResultCards();
      assertTrue(resultProcessing.isSearchResultContainsTitle(title));


    }

    @And("search result contains link {string}")
    public void verifySearchResultContainsUrl(String url) {
     assertTrue(resultProcessing.isSearchResultContainsUrl(url));
    }
}
