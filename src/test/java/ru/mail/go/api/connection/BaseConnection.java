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
    private Connection.Response response;
    protected static final Logger logger = LogManager.getLogger();
    private String resultCardsLocator = "//*[contains(@class,'Link-root SnippetResultTitle')]/ancestor::li";
    private String resultTitleClassName = "SnippetResultTitle-title result__title";
    private String resultUrlClassName = "Link-root SnippetResultInfo-url Link-orange Link-hoverable";
    private List<SearchResultCard> resultCardsList;

    public void sendGet(String url) {
        this.url = url;
        logger.info("GET " + url);
        try {
            response = Jsoup.connect(url).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getStatusCode() {
        int statusCode = response.statusCode();
        logger.info("Status Code " + statusCode);
        return statusCode;
    }

    private Document getDocument() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        options.addArguments("disabled-gpu");
        WebDriver driver = new ChromeDriver(options);
        driver.get(url);
        String pageSource = driver.getPageSource();
        driver.quit();
        return Jsoup.parse(pageSource);
    }

    private List<SearchResultCard> getListSearchResultCard(String searchValue) {
        Elements elements = getDocument().selectXpath(resultCardsLocator);
        resultCardsList = new ArrayList<>();
        for (Element element : elements) {
            SearchResultCard searchResultCard = new SearchResultCard(
                    element.getElementsByClass(resultTitleClassName).text(),
                    element.getElementsByClass(resultUrlClassName).text());
            if (element.getElementsByClass(resultTitleClassName).text().contains(searchValue)) {
                logger.info(element);
            }
            resultCardsList.add(searchResultCard);
        }
        return resultCardsList;
    }

    public boolean isResponseContainTitle(String title) {
        if (resultCardsList == null) {
            resultCardsList = getListSearchResultCard(title);
        }
        return resultCardsList.stream().anyMatch(s -> s.getTitle().contains(title));
    }

    public boolean isResponseContainUrl(String url) {
        if (resultCardsList == null) {
            resultCardsList = getListSearchResultCard(url);
        }
        return resultCardsList.stream().anyMatch(s -> s.getUrl().contains(url));
    }
}
