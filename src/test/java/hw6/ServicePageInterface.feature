Feature: Service page tests

  Scenario: Service page interface check
    Given I'm on the Home Page
    Then The browser title is Home Page
    When I login as user PITER CHAILOVSKII
    Then Displayed user name is PITER CHAILOVSKII
    And
