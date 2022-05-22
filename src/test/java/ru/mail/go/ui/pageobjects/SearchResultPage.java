package ru.mail.go.ui.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends AbstractPage {

    @FindBy(xpath = "//*[contains(@class,'Link-root SnippetResultTitle')]/ancestor::li")
    protected List<WebElement> searchResultElements;
    protected String cardsNameLocator = "[class*='Link-root SnippetResultTitle']";
    protected String cardsUrlLinkLocator = "[class*='Link-root SnippetResultInfo-url']";
}
