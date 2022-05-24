package ru.mail.go.api;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.mail.go.api.domain.SearchResultCard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class GoMailTest {
@Test
    public void testGetSearch() throws IOException {

    WebDriverManager.chromedriver().setup();
    ChromeOptions options=new ChromeOptions();
    options.addArguments("headless");
    options.addArguments("disabled-gpu");
    WebDriver driver=new ChromeDriver(options);
    driver.get("https://go.mail.ru/search?q=Минск");
    String pageSource = driver.getPageSource();
    Document doc =Jsoup.parse(pageSource);
   // System.out.println(doc.toString());
    Elements elements = doc.selectXpath("//*[contains(@class,'Link-root SnippetResultTitle')]/ancestor::li");

    List<SearchResultCard> resultCards = new ArrayList<>();
    for (Element byClass : elements) {
        SearchResultCard searchResultCard=new SearchResultCard(
           byClass.getElementsByClass("SnippetResultTitle-title result__title").text(),
                byClass.getElementsByClass("Link-root SnippetResultInfo-url Link-orange Link-hoverable").text()
        );
        resultCards.add(searchResultCard);

    }
    System.out.println(resultCards);
    assertTrue(resultCards.stream().anyMatch(s->s.getTitle().contains("Минск — Википедия")));
    assertTrue(resultCards.stream().anyMatch(s->s.getUrl().contains("ru.wikipedia.org›wiki/Минск")));

}
}
