package ru.mail.go.api.connection;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.mail.go.api.domain.SearchResultCard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BaseConnection {
    private String url;
    protected static final Logger logger = LogManager.getLogger();
    private String resultCardsLocator = "//*[contains(@class,'Link-root SnippetResultTitle')]/ancestor::li";
    private String resultTitleClassName = "SnippetResultTitle-title result__title";
    private String resultUrlClassName = "Link-root SnippetResultInfo-url Link-orange Link-hoverable";

    public void sendGet(String url) {
        this.url = url;
    }

    public int getStatusCode() {
        Connection.Response response = null;
        try {
            response = Jsoup.connect(url).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response.statusCode();
    }

    private Document getDocument() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        options.addArguments("disabled-gpu");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://go.mail.ru/search?q=Минск");
        String pageSource = driver.getPageSource();
        driver.quit();
        return Jsoup.parse(pageSource);
    }

    private List<SearchResultCard> getListSearchResultCard() {
        Elements elements = getDocument().selectXpath(resultCardsLocator);
        List<SearchResultCard> resultCards = new ArrayList<>();
        for (Element element : elements) {
            SearchResultCard searchResultCard = new SearchResultCard(
                    element.getElementsByClass(resultTitleClassName).text(),
                    element.getElementsByClass(resultCardsLocator).text());
            if (element.getElementsByClass(resultUrlClassName).text().contains("Минск — Википедия")) {
                logger.info(element);
            }
            resultCards.add(searchResultCard);
        }
        return resultCards;
    }

    public boolean isResponseContainInformation(String information) {
        return getListSearchResultCard().stream().anyMatch(s -> s.getTitle().contains(information));
    }
}
