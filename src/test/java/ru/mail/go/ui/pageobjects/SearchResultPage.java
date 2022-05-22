package ru.mail.go.ui.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.mail.go.ui.steps.ResultProcessing;

import java.util.List;

public class SearchResultPage extends AbstractPage {

    @FindBy(css = "li[id*=js-result_1]")
    protected List<WebElement> searchResultElements;
    protected String cardsNameLocator = "[class*='Link-root SnippetResultTitle']";
    protected String cardsUrlLinkLocator = "[class*='Link-root SnippetResultInfo-url']";
}
