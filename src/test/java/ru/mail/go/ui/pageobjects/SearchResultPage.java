package ru.mail.go.ui.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends AbstractPage {

    @FindBy(css = "li[id*=js-result]")
    private static List<WebElement> searchResultElements;
    private static String cardsNameLocator="[class*='Link-root SnippetResultTitle']";
    private static String cardsUrlLinkLocator="[class*='Link-root SnippetResultInfo-url']";

    public static String getCardsNameLocator() {
        return cardsNameLocator;
    }

    public static String getCardsUrlLinkLocator() {
        return cardsUrlLinkLocator;
    }

    public static List<WebElement> getListSearchResultElements() {
        return searchResultElements;
    }

}
