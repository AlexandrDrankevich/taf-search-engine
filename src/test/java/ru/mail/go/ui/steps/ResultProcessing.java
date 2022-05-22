package ru.mail.go.ui.steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.mail.go.ui.domain.SearchResultCard;
import ru.mail.go.ui.pageobjects.SearchResultPage;

import java.util.ArrayList;
import java.util.List;

public class ResultProcessing extends SearchResultPage {
    protected static final Logger logger = LogManager.getLogger();

       private static List<SearchResultCard> cards=new ArrayList<>();

    public void createSearchResultCards() {
        for (WebElement foundSearchResult : searchResultElements) {
            String title = foundSearchResult.findElement(By.cssSelector(cardsNameLocator)).getText();
            String url = foundSearchResult.findElement(By.cssSelector(cardsUrlLinkLocator)).getText();
            SearchResultCard searchResultCard = new SearchResultCard(title, url);
            cards.add(searchResultCard);
        }
        logger.info(cards);
    }

    public boolean isSearchResultContainsTitle(String title) {
        return cards.stream().map(s -> s.getTitle()).anyMatch(title::equals);
    }

    public boolean isSearchResultContainsUrl(String url) {
        return cards.stream().map(s -> s.getUrl()).anyMatch(url::equals);
    }
}
