@selenium
Feature:navigate to bing

  Scenario: go to bing
    When the user requests https://www.bing.com/
    Then the user should be on the Bing home page