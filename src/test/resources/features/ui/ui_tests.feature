@UI
Feature: Test Case 1 functionality

  Scenario: Test Case 1
    Given user is on the home page
    When accept cookie if visible
    Then verify page "sogeti" is opened
    When hover over the "Services" sub menu link
    When click on "Automation" tab link
    Then verify that page "Automation" header is displayed

  Scenario: Test Case 2
    Given user is on the home page
    When accept cookie if visible
    Then verify page "sogeti" is opened
    When hover over the "Services" sub menu link
    When click on "Automation" tab link
    Then verify that page "Automation" header is displayed
    When move to the "Contact us:" section
    And fill the fields with random generated data:
      | field1     | field2    | field3 | field4 | field5  | field6  |
      | First Name | Last Name | Email  | Phone  | Company | Message |
    And check the "I agree" checkbox
    And click on "Submit" button

  Scenario Outline: Test Case 3
    Given user is on the home page
    When accept cookie if visible
    Then verify page "sogeti" is opened
    When click on "Worldwide" global item
    Then verify Countries dropdown items are visible
    When click on "<country>" country from the dropdown
    And switch to new tab
    Then verify page "<pageUrl>" is opened
    And verify current page contains url as in previously clicked dropdown item
    And close tab
    And switch back to previous tab

    Examples:
      | country     | pageUrl            |
      | Belgium     | www.sogeti.be/     |
      | Finland     | www.sogeti.fi/     |
      | France      | www.fr.sogeti.com/ |
      | Germany     | www.sogeti.de/     |
      | Ireland     | www.sogeti.ie/     |
      | Luxembourg  | www.sogeti.lu/     |
      | Netherlands | www.sogeti.nl/     |
      | Norway      | www.sogeti.no/     |
      | Spain       | www.sogeti.es/     |
      | Sweden      | www.sogeti.se/     |
      | UK          | www.uk.sogeti.com/ |
      | USA         | www.us.sogeti.com/ |