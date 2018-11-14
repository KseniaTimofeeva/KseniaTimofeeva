Feature: Service page tests

  Scenario: Service page interface test
    Given I am on "Home Page"
    Then The browser title is "Home Page"
    When I login as user "PITER CHAILOVSKII"
    Then Displayed user name is "PITER CHAILOVSKII"
    And 4 pictures exist
    And 4 texts under pictures exist
    And 2 texts above exist

    When I click on "Service" button in Header
    Then dropdown in the header contains options:
      | SUPPORT            |
      | DATES              |
      | COMPLEX TABLE      |
      | SIMPLE TABLE       |
      | USER TABLE         |
      | TABLE WITH PAGES   |
      | DIFFERENT ELEMENTS |
      | PERFORMANCE        |

    When I click on "Service" subcategory in the left section
    Then dropdown in the left section contains options:
      | Support            |
      | Dates              |
      | Complex Table      |
      | Simple Table       |
      | User Table         |
      | Table With Pages   |
      | Different Elements |
      | Performance        |

    When I click on "Service" button in Header
    And I click on "Different Elements" button in Service dropdown
    Then The browser title is "Different Elements"
    And 4 checkboxes are displayed on "Different Elements" page
    And 4 radios are displayed on "Different Elements" page
    And 1 dropdown is displayed on "Different Elements" page
    And 2 buttons are displayed on "Different Elements" page
    And Right section is displayed on "Different Elements" page
    And Left section is displayed on "Different Elements" page

    When I select checkboxes:
      | Water |
      | Wind  |
    Then Log rows are displayed, checkbox name and its status is corresponding to values:
      | Water | True |
      | Wind  | True |

    When I select radio "Selen"
    Then Log row is displayed, radiobutton name and its status is corresponding to "Selen"

    When I select in dropdown "Yellow"
    Then Log row is displayed, dropdown name and selected value is corresponding to "Yellow"

    When I unselect checkboxes:
      | Water |
      | Wind  |
    Then Log rows are displayed, checkbox name and its status is corresponding to values:
      | Water | False |
      | Wind  | False |