@UI_Tests
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
    When scroll down to the "Contact us:" section
    And fill the fields with random data:
      | First Name | Last Name | Email | Phone | Message |