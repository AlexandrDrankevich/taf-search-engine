package ru.mail.go.api;

import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import ru.mail.go.api.domain.SearchResultCard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GoMailTest {
@Test
    public void testGetSearch() throws IOException {

  Connection.Response  response = Jsoup.connect("https://go.mail.ru/search?q=Минск").execute();

    int i = response.statusCode();
   String s = response.statusMessage();
    Assert.assertEquals(200,i);
    Document doc = response.parse();
    System.out.println(doc.toString());
   // String body = Jsoup.connect("https://go.mail.ru/search?q=Минск").execute().body();
   // JSONArray objects = new JSONArray(body);

    Elements elementById = doc.selectXpath("//*[@id=\"reactHeaderRoot\"]/div/div[1]/div[1]/a[1]/svg");
    List<SearchResultCard> resultCards = new ArrayList<>();
    /*for (Element byClass : elementsByClass) {
        SearchResultCard searchResultCard=new SearchResultCard(
           byClass.getElementsByClass("SnippetResultTitle-title result__title").text(),
                byClass.getElementsByClass("Link-root SnippetResultInfo-url Link-orange Link-hoverable").text()
        );
        resultCards.add(searchResultCard);

    }
    System.out.println(resultCards);*/


}
}
