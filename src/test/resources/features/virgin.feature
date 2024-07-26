Feature: Testing different request on the Virgin games application

  @smoke
  Scenario: Verify the jackpots bingo as per the selected currency
    When User sends a GET request to jackpots bingo endpoint
    Then User must get back a valid status code 200 as per the "<currency>"

  @smoke
  Scenario Outline: Verify the Bingo jackpots as per selected currency is changed or not
    When User sends a GET request to jackpots endpoint
    Then User must get back a valid status code 200 as per"<currency>"
    Examples:
      | currency |
      | SEK      |
      | GBP      |
      | EUR      |