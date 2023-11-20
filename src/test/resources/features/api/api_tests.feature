@API
Feature: API Tests

  Scenario: Looking up places by parameters of location
    When user get places by "de" country abbreviation and "bw" country code and "stuttgart" location
    Then verify that "country" is "Germany" and "state" is "Baden-Württemberg"
    Then verify for postal code "70597" the "place name" has "Stuttgart Degerloch"

  Scenario Outline: Looking up place by post code
    When user get postal code "<post_code>" for country code "<country_abbreviation>"
    Then verify that the place is "<place_name>" in country "<country>"

    Examples:
      | country       | post_code | place_name    | country_abbreviation |
      | United States | 90210     | Beverly Hills | US                   |
      | United States | 12345     | Schenectady   | US                   |
      | Canada        | B2R       | Waverley      | CA                   |