Feature: As a user I want to get ability to search information about City
@smoke
  Scenario Outline: Search result should contain appropriate name and url
    Given the user open go.mail website
    When  the user send search request  "<CityName>"
    Then search result contains "<CityName>"
    And search result contains link "<URL>"

    Examples:
      | CityName | URL                                   |
      | Минск  | https://ru.wikipedia.org/wiki/Минск |