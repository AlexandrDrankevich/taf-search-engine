package ru.mail.go.ui.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends AbstractPage {
    @FindBy(css = "li[id*=js-result]")
    private static List<WebElement> foundSearchResults;
    private String cardsNameLocator="[class*='Link-root SnippetResultTitle']";
    private String cardsUrlLinkLocator="[class*='Link-root SnippetResultInfo-url']";


    public static List<WebElement> getSearchResultCards() {
        return foundSearchResults;
    }

}
