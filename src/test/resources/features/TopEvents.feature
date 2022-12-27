Feature: Top Events
  Scenario: To get the results of a specific team in top events
    Given User is on Home page with url "https://www.espn.in/"
    When User clicks on the Top events button and select an event
    And Select the date
    Then Result of match is displayed of selected date
  Scenario: To get summary of a match in top events
    Given User is on Home page with url "https://www.espn.in/"
    When User clicks on the Top events button and select world cup event
    And select date
    And Click on Summary of any match
    Then User is redirected to the summary page of match
    And The summary and details of the match
