package ru.mail.go.api.domain;

public class SearchResultCard {
    private String title;
    public String url;
    public SearchResultCard(String title, String url){
        this.title=title;
        this.url=url;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "Title: "+title+", "+"URL: "+url;
    }
}
